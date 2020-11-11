package ServerSide.ServerConnection;

import Common.Objects.Chat;
import ServerSide.ServerConnection.Threads.ChatThread;

import java.net.Socket;
import java.util.HashMap;

public interface ServerConnection {
    void startServerConnection() throws Exception;

    void createNewChatThread(Socket socket);

    void addUser(HashMap<String, String> requestParam, ChatThread chatThread) throws Exception;

    void removeUser(HashMap<String, String> requestParam) throws Exception;

    String getOnlineUsers(HashMap<String, String> requestParam) throws Exception;

    void sendMessage(HashMap<String, String> requestParam) throws Exception;

    void createChat(HashMap<String, String> requestParam) throws Exception;

    void chatUpdate(String userName, Chat chat);


}
