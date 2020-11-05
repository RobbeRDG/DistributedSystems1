package ServerSide.ServerConnection;

import ClientSide.ClientConnection.Listener.ClientListener;
import Objects.ChatMessage;
import ServerSide.ServerController.ServerController;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.UUID;

public class ServerConnectionImpl extends UnicastRemoteObject implements ServerConnection {
    private static final long serialVersionUID = 1L;
    private ServerController controller;


    public ServerConnectionImpl(ServerController controller) throws RemoteException {
        super();
        this.controller = controller;
    }

    public void startServerConnection() {
        try {
            // Create on port 2222
            Registry registry = LocateRegistry.createRegistry(2222);

            // Create a new service named ChatService
            registry.rebind("ChatService", this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("System is ready");
    }



    @Override
    public void sendMessage(ChatMessage message, UUID chatId) throws Exception {
        controller.sendMessage(message, chatId);
    }

    @Override
    public void createChat(String userName, String chatName, ArrayList<String> subscribers) throws Exception {
        controller.createChat(userName, chatName, subscribers);
    }

    //###############################################################################################################
    //      AUTHENTICATION
    //###############################################################################################################

    @Override
    public void addUser(String userName, ClientListener clientListener) throws Exception {
        controller.addUser(userName, clientListener);
    }

    @Override
    public void removeUser(String userName) throws Exception {
        controller.removeUser(userName);
    }

    @Override
    public ArrayList<String> getOnlineUsers() throws Exception {
        return controller.getOnlineUsers();
    }


}