package ServerSide.ServerConnection;

import Common.Objects.*;
import ServerSide.ServerConnection.Threads.ChatThread;
import ServerSide.ServerConnection.Threads.ServerThread;
import ServerSide.ServerController.ServerController;

import java.net.Socket;
import java.util.*;

public class ServerConnectionImpl implements ServerConnection {
    private ServerController controller;
    private HashMap<String, ChatThread> clientThreads;

    private static final int port = 3333;

    //###############################################################################################################
    //      LOGIC
    //###############################################################################################################

    public ServerConnectionImpl(ServerController controller){
        this.controller = controller;
    }


    @Override
    public void startServerConnection() throws Exception {
        ServerThread serverThread = new ServerThread(port, this);
        serverThread.start();
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
    public void addUser(HashMap<String, Object> payload, ChatThread chatThread) throws Exception {
        String userName = null;

        try {
            userName = (String) payload.get(userName);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }

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
    public void removeUser(HashMap<String, Object> payload) throws Exception {
        String userName = null;

        try {
            userName = (String) payload.get(userName);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }

        if (userName != null) controller.removeUser(userName);
        else throw new Exception("Something went wrong");
    }

    @Override
    public ArrayList<String> getOnlineUsers() throws Exception {
        return controller.getOnlineUsers();
    }


    //###############################################################################################################
    //      CHAT
    //###############################################################################################################

    @Override
    public void sendMessage(HashMap<String, Object> payload) throws Exception {
        ChatMessage userName = null;
        UUID chatId = null;

        try {
            userName = (ChatMessage) payload.get(userName);
            chatId = (UUID) payload.get(chatId);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }

        if (userName != null && chatId != null) controller.sendMessage(userName, chatId);
        else throw new Exception("Something went wrong");
    }

    @Override
    public void createChat(HashMap<String, Object> payload) throws Exception {
        String userName = null;
        String chatName = null;
        ArrayList<String> subscribers = null;

        try {
            userName = (String) payload.get(userName);
            chatName = (String) payload.get(chatName);
            subscribers = (ArrayList<String>) payload.get(subscribers);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }

        if (userName != null && chatName !=null && subscribers != null) controller.createChat(userName, chatName, subscribers);
    }

    @Override
    public void chatUpdate(String userName, Chat chat) {
        ChatThread clientThread = clientThreads.get(userName);

        clientThread.chatUpdate(chat);
    }


}