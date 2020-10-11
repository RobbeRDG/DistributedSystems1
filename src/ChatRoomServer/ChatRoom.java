package ChatRoomServer;

import ChatRoomClient.ChatListener;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface ChatRoom extends Remote {

    public int addUser(String userName, ChatListener listener) throws RemoteException;
    public void sendMessageTo(ArrayList<String> recievers, String sender, String message) throws RemoteException;
    public void broadcastMessage(String sender, String message) throws RemoteException;


}