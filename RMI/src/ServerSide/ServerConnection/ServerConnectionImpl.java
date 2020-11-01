package ServerSide.ServerConnection;

import ClientSide.ClientConnection.Listener.ClientListener;
import Objects.ChatMessage;
import ServerSide.ServerController.ServerController;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

public class ServerConnectionImpl extends UnicastRemoteObject implements ServerConnection {
    private static final long serialVersionUID = 1L;
    private ServerController controller;


    public ServerConnectionImpl(ServerController controller) throws RemoteException {
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
    public void sendMessage(ChatMessage message, UUID chatId) throws RemoteException {
        controller.sendMessage(message, chatId);
    }

    @Override
    public void createChat(String userName, String chatName, String[] subscribers) throws RemoteException {
    }

    //###############################################################################################################
    //      AUTHENTICATION
    //###############################################################################################################

    @Override
    public int addUser(String userName, ClientListener clientListener) throws RemoteException {
        return controller.addUser(userName, clientListener);
    }

    @Override
    public void removeUser(String userName) throws RemoteException {
        controller.removeUser(userName);
    }

}