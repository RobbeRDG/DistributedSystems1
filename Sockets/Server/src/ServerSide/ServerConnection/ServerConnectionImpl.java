package ServerSide.ServerConnection;

import Common.Objects.*;
import Common.SocketMessageEncoder;
import ServerSide.ServerConnection.Threads.ChatThread;
import ServerSide.ServerConnection.Threads.ServerThread;
import ServerSide.ServerController.ServerController;

import java.net.Socket;
import java.util.*;

public class ServerConnectionImpl implements ServerConnection {
    private ServerController controller;
    private HashMap<String, ChatThread> clientThreads;
    private static final SocketMessageEncoder encoder = new SocketMessageEncoder();


    private static final int port = 3333;

    //###############################################################################################################
    //      LOGIC
    //###############################################################################################################

    public ServerConnectionImpl(ServerController controller){
        this.controller = controller;
        clientThreads = new HashMap<>();
    }


    @Override
    public void startServerConnection() throws Exception {
        ServerThread serverThread = new ServerThread(port, this);
        serverThread.start();
        System.out.println("Server started on port " + port);
    }

    @Override
    public void createNewChatThread(Socket socket) {
        try {
            ChatThread chatThread = new ChatThread(socket,this);
            chatThread.start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //###############################################################################################################
    //      USERS
    //###############################################################################################################

    @Override
    public void addUser(HashMap<String, String> requestParam, ChatThread chatThread) throws Exception {
        String userName = requestParam.get("userName");

        if (userName != null) {
            try {
                clientThreads.put(userName, chatThread);
                controller.addUser(userName);
            } catch (Exception e) {
                clientThreads.remove(userName);
                throw e;
            }
        }
        else throw new Exception("Something went wrong");
    }

    @Override
    public void removeUser(HashMap<String, String> requestParam) throws Exception {
        String userName = requestParam.get("userName");

        if (userName != null) controller.removeUser(userName);
        else throw new Exception("Something went wrong");
    }

    @Override
    public String getOnlineUsers(HashMap<String, String> requestParam) throws Exception {
        ArrayList<String> onlineUsersArrayList = controller.getOnlineUsers();
        StringBuilder sb = new StringBuilder();
        sb.append("onlineUsers:");
        for (int i=0; i<onlineUsersArrayList.size(); i++) {
            sb.append(onlineUsersArrayList.get(i));
            if (i != (onlineUsersArrayList.size() - 1)) sb.append("/");
        }

        return sb.toString();

    }


    //###############################################################################################################
    //      CHAT
    //###############################################################################################################

    @Override
    public void sendMessage(HashMap<String, String> requestParam) throws Exception {
        String messageText = requestParam.get("messageText");
        String messageSender = requestParam.get("messageSender");
        UUID chatId = UUID.fromString(requestParam.get("chatId"));

        if (messageText != null && messageSender != null && chatId != null) controller.sendMessage(messageSender, messageText, chatId);
        else throw new Exception("Something went wrong");
    }

    @Override
    public void createChat(HashMap<String, String> requestParam) throws Exception {
        String userName = requestParam.get("userName");
        String chatName = requestParam.get("chatName");
        ArrayList<String> subscribers = new ArrayList<>(Arrays.asList(requestParam.get("subscribers").split("/")));

        if (userName != null && chatName !=null && subscribers != null) controller.createChat(userName, chatName, subscribers);
    }

    @Override
    public void chatUpdate(String userName, Chat chat) {
        ChatThread chatThread = clientThreads.get(userName);

        String chatSocketMessage = chat.toSocketMessage();

        chatThread.chatUpdate("chatUpdate" + ";" + chatSocketMessage);
    }


}