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

public class ServerConnectionImpl{
    private ServerController controller;


    public ServerConnectionImpl(ServerController controller) throws Exceptions {
        this.controller = controller;
    }

    public void startServerConnection() throws Exception{
        //TODO
        //Create a new server
        ServerSockets serverSocket = new ServerSocket(3333);


    }



    public void sendMessage(ChatMessage message, UUID chatId) throws Exception {
        //TODO
    }

    public void createChat(String userName, String chatName, ArrayList<String> subscribers) throws Exception {
        //TODO
    }

    //###############################################################################################################
    //      AUTHENTICATION
    //###############################################################################################################

    public void addUser(String userName, ClientListener clientListener) throws Exception {
        //TODO
    }

    public void removeUser(String userName) throws Exception {
        //TODO
    }

    public ArrayList<String> getOnlineUsers() throws Exception {
        //TODO
    }


}