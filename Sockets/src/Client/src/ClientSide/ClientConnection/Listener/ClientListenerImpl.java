package ClientSide.ClientConnection.Listener;

import ClientSide.ClientConnection.ClientConnection;
import Common.ClientListener;
import Common.Objects.Chat;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ClientListenerImpl extends UnicastRemoteObject implements ClientListener {
    private static final long serialVersionUID = 1L;
    private ClientConnection connection;

    public ClientListenerImpl(ClientConnection connection) throws RemoteException {
        super();
        setConnection(connection);
    }

    private void setConnection(ClientConnection connection) {
        if (this.connection == null) {
            this.connection = connection;
        }
    }

    @Override
    public void chatUpdate(Chat chat) throws RemoteException {
        sendChatUpdate(chat);
    }

    private void sendChatUpdate(Chat chat) {
        connection.chatUpdate(chat);
    }
}
