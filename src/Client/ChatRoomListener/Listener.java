package Client.ChatRoomListener;

import Client.GUI.GUI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Listener extends Remote {
    void newMessage(String user, String Message) throws RemoteException;
    void setGuiController(GUI guiController);
}
