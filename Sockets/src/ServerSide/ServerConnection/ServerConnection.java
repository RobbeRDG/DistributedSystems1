package ServerSide.ServerConnection;

import ClientSide.ClientConnection.Listener.ClientListener;
import Objects.ChatMessage;

import java.io.Serializable;
import java.rmi.Remote;
import java.util.ArrayList;
import java.util.UUID;

public interface ServerConnection extends Remote, Serializable {

    void addUser(String userName, ClientListener clientListener) throws Exception;
    void removeUser(String userName) throws Exception;
    void sendMessage(ChatMessage message, UUID chatID) throws Exception;
    void createChat(String userName, String chatName, ArrayList<String> subscribers) throws Exception;
    ArrayList<String> getOnlineUsers() throws Exception;
}