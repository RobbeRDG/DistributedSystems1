package ClientSide.ClientConnection;

import ClientSide.ClientConnection.Listener.ClientListenerImpl;
import ClientSide.ClientController.ClientController;
import Common.ClientListener;
import Common.Objects.Chat;
import Common.Objects.ChatMessage;
import Common.ServerConnection;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.UUID;

public class ClientConnection {
    private static ServerConnection serverConnection;
    private static ClientController clientController;
    private static ClientListener clientListener;


    //###############################################################################################################
    //      LOGIC
    //###############################################################################################################


    public ClientConnection() throws RemoteException {
        generateClientListener();
    }

    private void generateClientListener() throws RemoteException {
        //Only generate one clientListener per connection so first check if one already exist
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

    public void setClientController(ClientController clientController) {
        this.clientController = clientController;
    }

    //###############################################################################################################
    //      USERS
    //###############################################################################################################


    public void addUser(String userName) throws Exception {
        serverConnection.addUser(userName, clientListener);
    }

    public ArrayList<String> getOnlineUsers() throws Exception {
        return serverConnection.getOnlineUsers();
    }

    public void removeUser(String userName) throws Exception {
        serverConnection.removeUser(userName);
    }

    //###############################################################################################################
    //      CHAT
    //###############################################################################################################


    public void chatUpdate(Chat chat) {
        clientController.chatUpdate(chat);
    }



    public void sendMessage(ChatMessage message, String tabId) throws Exception {
        serverConnection.sendMessage(message, UUID.fromString(tabId));
    }

    public void createChat(String userName, String chatName, ArrayList<String> chatUsers) throws Exception {
        serverConnection.createChat(userName, chatName, chatUsers);
    }
}

