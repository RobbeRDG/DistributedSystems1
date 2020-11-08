package Common;

import Common.Objects.Chat;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientListener extends Remote, Serializable {
    void chatUpdate(Chat chat) throws RemoteException;
}
