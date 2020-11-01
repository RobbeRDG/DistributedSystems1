package ServerSide.ServerConnection;

import ClientSide.ClientConnection.Listener.ClientListener;
import Objects.ChatMessage;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.UUID;

public interface ServerConnection extends Remote, Serializable {

    int addUser(String userName, ClientListener clientListener) throws RemoteException;
    void removeUser(String userName) throws RemoteException;
    void sendMessage(ChatMessage message, UUID chatID) throws RemoteException;
    void createChat(String userName, String chatName, ArrayList<String> subscribers) throws Exception;
    ArrayList<String> getOnlineUsers() throws RemoteException;
}