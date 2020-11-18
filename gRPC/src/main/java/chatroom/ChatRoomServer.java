package chatroom;

import Common.Objects.Chat;
import Server.Interceptor.GlobalGrpcExceptionHandler;
import Server.ServerController.ServerController;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

//////////////////////////////////////////////////////////////////////////////////////////
//        SERVER
//////////////////////////////////////////////////////////////////////////////////////////


public class ChatRoomServer {
    private static final Logger logger = Logger.getLogger(ChatRoomServer.class.getName());
    private final int port;
    private final Server server;
    static ServerController serverController;
    static HashMap<String,StreamObserver<ChatUpdate>> chatUserStreams;

    public ChatRoomServer(int port, ServerController serverController) throws IOException {
        this(ServerBuilder.forPort(port), port, serverController);
    }

    // Create a ChatRoom server using serverBuilder as a base and features as data.
    public ChatRoomServer(ServerBuilder<?> serverBuilder, int port, ServerController serverController) {
        this.port = port;
        server = serverBuilder.addService(new ChatRoomService())
                .intercept(new GlobalGrpcExceptionHandler())
                .build();
        this.serverController = serverController;
        chatUserStreams = new HashMap<>();
    }

    //Start the server
    public void start() throws IOException {
        server.start();
        logger.info("Server started, listening on " + port);
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                // Use stderr here since the logger may have been reset by its JVM shutdown hook.
                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                try {
                    ChatRoomServer.this.stop();
                } catch (InterruptedException e) {
                    e.printStackTrace(System.err);
                }
                System.err.println("*** server shut down");
            }
        });
    }

    // Stop serving requests and shutdown resources.
    public void stop() throws InterruptedException {
        if (server != null) {
            server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
        }
    }

    // Await termination on the main thread since the grpc library uses daemon threads.
    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    public  void startServerConnection() throws IOException, InterruptedException {
        this.start();
        this.blockUntilShutdown();
    }

    public void chatUpdate(String userName, Chat chat) {
        ChatUpdate chatUpdate = ChatUpdate.newBuilder()
                .setChatName(chat.getName())
                .setChatId(chat.getId().toString())
                .addAllMessages(chat.getMessagesInString())
                .addAllSubscribers(chat.getSubscribers())
                .build();

        chatUserStreams.get(userName).onNext(chatUpdate);
    }



//////////////////////////////////////////////////////////////////////////////////////////
//        SERVICE
//////////////////////////////////////////////////////////////////////////////////////////

    private static class ChatRoomService extends ChatRoomGrpc.ChatRoomImplBase {
        @Override
        public void addUser(AddUserRequest addUserRequest, StreamObserver<ChatUpdate> responseObserver){
            String userName = addUserRequest.getUserName();
            try {
                chatUserStreams.put(userName, responseObserver);
                serverController.addUser(userName);
            } catch (Exception e) {
                chatUserStreams.remove(userName, responseObserver);
                responseObserver.onError(e);
            }
        }

        @Override
        public void removeUser(RemoveUserRequest removeUserRequest, StreamObserver<RemoveUserResponse> responseObserver) {
            try{
                String userName = removeUserRequest.getUserName();
                serverController.removeUser(userName);
                chatUserStreams.remove(userName);
                responseObserver.onNext(RemoveUserResponse.newBuilder().setMessage("ok").build());
                responseObserver.onCompleted();
            } catch (Exception e){
                responseObserver.onError(e);
            }
        }

        @Override
        public void sendMessage(SendMessageRequest sendMessageRequest, StreamObserver<SendMessageResponse> responseObserver){
            try{
                String sender = sendMessageRequest.getMessageSender();
                String messageText = sendMessageRequest.getMessageText();
                String chatId = sendMessageRequest.getChatId();

                serverController.sendMessage(sender,messageText, UUID.fromString(chatId));

                responseObserver.onNext(SendMessageResponse.newBuilder().setMessage("ok").build());
                responseObserver.onCompleted();
            } catch (Exception e){
                responseObserver.onError(e);
            }
        }

        @Override
        public void createChat(CreateChatRequest createChatRequest, StreamObserver<CreateChatResponse> responseObserver){
            try{
                String userName = createChatRequest.getUserName();
                String chatName = createChatRequest.getChatName();
                String[] subscribersArray = createChatRequest.getSubscribersList().toArray(new String[0]);

                serverController.createChat(userName,chatName, new ArrayList<>(Arrays.asList(subscribersArray)));

                responseObserver.onNext(CreateChatResponse.newBuilder().setMessage("ok").build());
                responseObserver.onCompleted();
            } catch (Exception e){
                responseObserver.onError(e);
            }
        }

        @Override
        public void getOnlineUsers(GetOnlineUsersRequest getOnlineUsersRequest, StreamObserver<GetOnlineUsersResponse> responseObserver){
            try {
                ArrayList<String> onlineUsers = serverController.getOnlineUsers();

                responseObserver.onNext(GetOnlineUsersResponse.newBuilder().addAllUsers(onlineUsers).build());
                responseObserver.onCompleted();
            } catch (Exception e) {
                responseObserver.onError(e);
            }


        }

    }
}
