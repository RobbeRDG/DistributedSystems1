package ServerSide.ServerConnection;

import Common.*;
import Common.Objects.*;
import Common.ServerConnection;
import ServerSide.ServerController.ServerController;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

public class ServerConnectionImpl extends UnicastRemoteObject implements ServerConnection {
    private static final long serialVersionUID = 1L;
    private ServerController controller;
    private HashMap<String, ClientListener> clientListeners;

    //###############################################################################################################
    //      LOGIC
    //###############################################################################################################



    public ServerConnectionImpl(ServerController controller) throws RemoteException {
        super();
        this.controller = controller;
        clientListeners = new HashMap<>();
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


    //###############################################################################################################
    //      USERS
    //###############################################################################################################

    @Override
    public void addUser(String userName, ClientListener clientListener) throws Exception {
        try {
            //Add the new listener to the clientListeners
            clientListeners.put(userName, clientListener);
            //Check if the user doesnt already exist
            controller.addUser(userName);
        } catch (Exception e) {
            //if something went wrong remove the just added listener
            clientListeners.remove(userName);
        }
    }

    @Override
    public void removeUser(String userName) throws Exception {
        controller.removeUser(userName);
    }

    @Override
    public ArrayList<String> getOnlineUsers() throws Exception {
        return controller.getOnlineUsers();
    }



    //###############################################################################################################
    //      CHAT
    //###############################################################################################################


    @Override
    public void sendMessage(ChatMessage message, UUID chatId) throws Exception {
        controller.sendMessage(message, chatId);
    }

    @Override
    public void createChat(String userName, String chatName, ArrayList<String> subscribers) throws Exception {
        controller.createChat(userName, chatName, subscribers);
    }

    public void chatUpdate( String userName, Chat chat ) throws RemoteException {
        clientListeners.get(userName).chatUpdate(chat);
    }



}