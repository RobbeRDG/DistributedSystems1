package chatroom;


import Client.ClientController.ClientController;
import Client.ClientController.ClientControllerImpl;
import Common.Objects.Chat;
import Common.Objects.ChatMessage;
import be.msec.labgrpc.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChatRoomClient {
    private static final Logger logger = Logger.getLogger(TutorialClient.class.getName());
    private static ClientController clientController;

    private final ManagedChannel channel;
    private final ChatRoomGrpc.ChatRoomBlockingStub blockingStub;
    private final ChatRoomGrpc.ChatRoomStub asyncStub;

    //////////////////////////////////////////////////////////////////////////////////////////
    ////     LOGIC
    //////////////////////////////////////////////////////////////////////////////////////////


    public ChatRoomClient(String host, int port){
        this(ManagedChannelBuilder.forAddress(host, port).usePlaintext(true));
    }

    public ChatRoomClient(ManagedChannelBuilder<?> channelBuilder) {
        channel = channelBuilder.build();
        blockingStub = ChatRoomGrpc.newBlockingStub(channel);
        asyncStub = ChatRoomGrpc.newStub(channel);
    }

    public void setClientController(ClientControllerImpl clientController) {
        this.clientController = clientController;
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    private Chat getChatObject(ChatUpdate chatUpdate) {
        //Get the chatId
        UUID chatId = UUID.fromString(chatUpdate.getChatId());

        //Get the chatName
        String chatName = chatUpdate.getChatName();

        //Get all the subscribers
        ArrayList<String> subscribers = new ArrayList<>();
        for (int i=0; i<chatUpdate.getSubscribersCount(); i++) {
            subscribers.add(chatUpdate.getSubscribers(i));
        }

        //Get all the messages
        ArrayList<ChatMessage> messages = new ArrayList<>();
        for (int i=0; i<chatUpdate.getMessagesCount(); i++) {
            messages.add(new ChatMessage(chatUpdate.getMessages(i)));
        }

        return new Chat(chatName, chatId, subscribers, messages);
    }


    //////////////////////////////////////////////////////////////////////////////////////////
    ////     CONNECTION
    //////////////////////////////////////////////////////////////////////////////////////////

    public void addUser(String userName) throws Exception {
        AddUserRequest request = AddUserRequest.newBuilder()
                .setUserName(userName)
                .build();

        AddUserResponse response = blockingStub.addUser(request);

        connectToChatUpdater(userName);
    }

    private void connectToChatUpdater(String userName) {
        ConnectToChatUpdaterRequest request = ConnectToChatUpdaterRequest.newBuilder()
                .setUserName(userName)
                .build();

        StreamObserver<ChatUpdate> chatUpdateStreamObserver = new StreamObserver<ChatUpdate>() {
            @Override
            public void onNext(ChatUpdate chatUpdate) {
                Chat chat = getChatObject(chatUpdate);

                clientController.chatUpdate(chat);
            }

            @Override
            public void onError(Throwable t) {
            }

            @Override
            public void onCompleted() {
            }
        };

        asyncStub.connectToChatUpdater(request, chatUpdateStreamObserver);
    }



    public void removeUser(String userName) throws Exception {
        try {
            RemoveUserRequest request = RemoveUserRequest.newBuilder()
                    .setUserName(userName)
                    .build();

            RemoveUserResponse response = blockingStub.removeUser(request);
        } catch (Exception e) {
            throw e;
        } finally {
            shutdown();
        }
    }

    public ArrayList<String> getOnlineUsers() throws Exception {
        GetOnlineUsersRequest request = GetOnlineUsersRequest.newBuilder().build();

        GetOnlineUsersResponse response = blockingStub.getOnlineUsers(request);

        //Get all the online users
        ArrayList<String> onlineUsers = new ArrayList<>();
        for (int i=0; i<response.getUsersCount(); i++) {
            onlineUsers.add(response.getUsers(i));
        }

        return onlineUsers;
    }

    public void sendMessage(String userName, String messageText, UUID chatId) throws Exception {
        SendMessageRequest request = SendMessageRequest.newBuilder()
                .setMessageSender(userName)
                .setMessageText(messageText)
                .setChatId(chatId.toString())
                .build();

        SendMessageResponse response = blockingStub.sendMessage(request);
    }

    public void createChat(String userName, String chatName, ArrayList<String> chatUsers) throws Exception {
        CreateChatRequest request = CreateChatRequest.newBuilder()
                .setUserName(userName)
                .setChatName(chatName)
                .addAllSubscribers(chatUsers)
                .build();

        CreateChatResponse response = blockingStub.createChat(request);
    }
}
