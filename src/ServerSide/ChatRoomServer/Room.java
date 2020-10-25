package ServerSide.ChatRoomServer;

import Objects.Chat;
import Objects.ChatMessage;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface Room extends Remote {

    public int addUser(String userName) throws RemoteException;
    public void broadcastMessage(ChatMessage message) throws RemoteException;
    public ArrayList<Chat> getSubscriptions(String userName) throws RemoteException;


}