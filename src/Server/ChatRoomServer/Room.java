package Server.ChatRoomServer;

import Client.ChatRoomListener.Listener;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface Room extends Remote {

    public int addUser(String userName, Listener listener) throws RemoteException;
    public void sendMessageTo(ArrayList<String> recievers, String sender, String message) throws RemoteException;
    public void broadcastMessage(String sender, String message) throws RemoteException;


}