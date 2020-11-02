package ServerSide.ServerConnection;

import ClientSide.ClientConnection.Listener.ClientListener;
import Objects.ChatMessage;
import Objects.ServerLogicException;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.UUID;

public interface ServerConnection extends Remote, Serializable {

    void addUser(String userName, ClientListener clientListener) throws ServerLogicException, RemoteException;
    void removeUser(String userName) throws ServerLogicException, RemoteException;
    void sendMessage(ChatMessage message, UUID chatID) throws ServerLogicException, RemoteException;
    void createChat(String userName, String chatName, ArrayList<String> subscribers) throws ServerLogicException, RemoteException;
    ArrayList<String> getOnlineUsers() throws ServerLogicException, RemoteException;
}