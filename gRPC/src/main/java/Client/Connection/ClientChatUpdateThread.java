package Client.Connection;

import Client.ClientController.ClientController;
import Common.Objects.Chat;
import Common.Objects.ChatMessage;
import chatroom.ChatRoomGrpc;
import chatroom.ChatUpdate;
import chatroom.ConnectToChatUpdaterRequest;
import io.grpc.ManagedChannel;
import io.grpc.stub.StreamObserver;

import java.util.ArrayList;
import java.util.UUID;

public class ClientChatUpdateThread extends Thread{
    private final ClientController clientController;
    private final ManagedChannel channel;
    private final ChatRoomGrpc.ChatRoomBlockingStub blockingStub;
    private final ChatRoomGrpc.ChatRoomStub asyncStub;
    private final ConnectToChatUpdaterRequest request;

    public ClientChatUpdateThread(ManagedChannel channel, ConnectToChatUpdaterRequest request, ClientController clientController) {
        this.channel = channel;
        blockingStub = ChatRoomGrpc.newBlockingStub(channel);
        asyncStub = ChatRoomGrpc.newStub(channel);
        this.request = request;
        this.clientController = clientController;
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

    @Override
    public void run() {
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



}
