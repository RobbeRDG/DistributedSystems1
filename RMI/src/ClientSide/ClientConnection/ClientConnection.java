package ClientSide.ClientConnection;

import ClientSide.ClientConnection.Listener.ClientListener;
import ClientSide.ClientConnection.Listener.ClientListenerImpl;
import ClientSide.ClientController.ClientController;
import Objects.Chat;
import Objects.ChatMessage;
import ServerSide.ServerConnection.ServerConnection;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.UUID;

public class ClientConnection {
    private static ServerConnection serverConnection;
    private static ClientController clientController;
    private static ClientListener clientListener;

    public ClientConnection() throws RemoteException {
        generateClientListener();
    }

    private void generateClientListener() throws RemoteException {
        if (clientListener == null) {
            clientListener = new ClientListenerImpl(this);
        }
    }

    public void connectToServer() {
        try {
            // Fire to localhost port 2222
            Registry myRegistry = LocateRegistry.getRegistry("localhost", 2222);

            // Initialize the chatroom
            serverConnection = (ServerConnection) myRegistry.lookup("ChatService");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int addUser(String userName) {
        int noResponse = 444;
        int statusCode = noResponse;

        try {
            statusCode = serverConnection.addUser(userName, clientListener);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return statusCode;
    }


    public void setClientController(ClientController clientController) {
        this.clientController = clientController;
    }

    public void chatUpdate(Chat chat) {
        clientController.chatUpdate(chat);
    }

    public void removeUser(String userName) {
        try {
            serverConnection.removeUser(userName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(ChatMessage message, String tabId) {
        try {
            serverConnection.sendMessage(message, UUID.fromString(tabId));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

