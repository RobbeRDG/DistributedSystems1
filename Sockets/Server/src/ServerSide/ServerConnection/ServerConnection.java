package ServerSide.ServerConnection;

import Common.Objects.Chat;
import ServerSide.ServerConnection.Threads.ChatThread;

import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

public interface ServerConnection {
    void startServerConnection() throws Exception;

    void createNewChatThread(Socket socket);

    void addUser(HashMap<String, Object> payload, ChatThread chatThread) throws Exception;

    void removeUser(HashMap<String, Object> payload) throws Exception;

    ArrayList<String> getOnlineUsers() throws Exception;

    void sendMessage(HashMap<String, Object> payload) throws Exception;

    void createChat(HashMap<String, Object> payload) throws Exception;

    void chatUpdate(String userName, Chat chat);


}
