package ChatRoomClient;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ChatListener extends Remote {
    void newMessage(String user, String Message) throws RemoteException;
}
