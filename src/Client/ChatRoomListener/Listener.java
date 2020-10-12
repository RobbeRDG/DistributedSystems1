package Client.ChatRoomListener;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Listener extends Remote {
    void newMessage(String user, String Message) throws RemoteException;
}
