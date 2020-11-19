package Client.Connection;


import Client.ClientController.ClientController;
import Client.ClientController.ClientControllerImpl;
import chatroom.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;

import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class ChatRoomClient {
    private static ClientController clientController;

    private final ManagedChannel channel;
    private final ChatRoomGrpc.ChatRoomBlockingStub blockingStub;
    private final ChatRoomGrpc.ChatRoomStub asyncStub;
    private final UUID clientId = UUID.randomUUID();

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

    public void connectToServer() {
        ConnectToChatUpdaterRequest request = ConnectToChatUpdaterRequest.newBuilder()
                .setClientId(clientId.toString())
                .build();

        new ClientChatUpdateThread(channel, request, clientController).run();
    }


    //////////////////////////////////////////////////////////////////////////////////////////
    ////     CONNECTION
    //////////////////////////////////////////////////////////////////////////////////////////

    public void addUser(String userName) throws Exception {
        try {
            AddUserRequest request = AddUserRequest.newBuilder()
                    .setUserName(userName)
                    .setClientId(clientId.toString())
                    .build();

            AddUserResponse response = blockingStub.addUser(request);
        } catch (StatusRuntimeException e) {
            if (e.getStatus().getCode() == Status.Code.INVALID_ARGUMENT) throw new IllegalArgumentException(e.getMessage());
            else throw e;
        }
    }

    public void removeUser(String userName) throws Exception {
        try {
            RemoveUserRequest request = RemoveUserRequest.newBuilder()
                    .setUserName(userName)
                    .build();

            RemoveUserResponse response = blockingStub.removeUser(request);
        } catch (StatusRuntimeException e) {
            if (e.getStatus().getCode() == Status.Code.INVALID_ARGUMENT) throw new IllegalArgumentException(e.getMessage());
            else throw e;
        } finally {
            shutdown();
        }
    }

    public ArrayList<String> getOnlineUsers() throws Exception {
        try {
            GetOnlineUsersRequest request = GetOnlineUsersRequest.newBuilder().build();

            GetOnlineUsersResponse response = blockingStub.getOnlineUsers(request);

            //Get all the online users
            ArrayList<String> onlineUsers = new ArrayList<>();
            for (int i=0; i<response.getUsersCount(); i++) {
                onlineUsers.add(response.getUsers(i));
            }

            return onlineUsers;
        } catch (StatusRuntimeException e) {
            if (e.getStatus().getCode() == Status.Code.INVALID_ARGUMENT) throw new IllegalArgumentException(e.getMessage());
            else throw e;
        }
    }

    public void sendMessage(String userName, String messageText, UUID chatId) throws Exception {
        try {
            SendMessageRequest request = SendMessageRequest.newBuilder()
                    .setMessageSender(userName)
                    .setMessageText(messageText)
                    .setChatId(chatId.toString())
                    .build();

            SendMessageResponse response = blockingStub.sendMessage(request);
        } catch (StatusRuntimeException e) {
            if (e.getStatus().getCode() == Status.Code.INVALID_ARGUMENT) throw new IllegalArgumentException(e.getMessage());
            else throw e;
        }
    }

    public void createChat(String userName, String chatName, ArrayList<String> chatUsers) throws Exception {
        try {
            CreateChatRequest request = CreateChatRequest.newBuilder()
                    .setUserName(userName)
                    .setChatName(chatName)
                    .addAllSubscribers(chatUsers)
                    .build();

            CreateChatResponse response = blockingStub.createChat(request);
        } catch (StatusRuntimeException e) {
            if (e.getStatus().getCode() == Status.Code.INVALID_ARGUMENT) throw new IllegalArgumentException(e.getMessage());
            else throw e;
        }
    }


}
