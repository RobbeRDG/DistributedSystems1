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
import java.util.ArrayList;
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

    public void connectToServer() throws Exception{
        // Fire to localhost port 2222
        Registry myRegistry = LocateRegistry.getRegistry("localhost", 2222);

        // Initialize the chatroom
        serverConnection = (ServerConnection) myRegistry.lookup("ChatService");
    }

    public void addUser(String userName) throws Exception {
        serverConnection.addUser(userName, clientListener);
    }


    public void setClientController(ClientController clientController) {
        this.clientController = clientController;
    }

    public void chatUpdate(Chat chat) {
        clientController.chatUpdate(chat);
    }

    public void removeUser(String userName) throws Exception {
        serverConnection.removeUser(userName);
    }

    public void sendMessage(ChatMessage message, String tabId) throws Exception {
        serverConnection.sendMessage(message, UUID.fromString(tabId));
    }

    public ArrayList<String> getOnlineUsers() throws Exception {
        return serverConnection.getOnlineUsers();
    }

    public void createChat(String userName, String chatName, ArrayList<String> chatUsers) throws Exception {
        serverConnection.createChat(userName, chatName, chatUsers);
    }
}

