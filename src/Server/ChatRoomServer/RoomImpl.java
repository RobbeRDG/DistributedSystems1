package Server.ChatRoomServer;

import Client.ChatRoomListener.Listener;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class RoomImpl extends UnicastRemoteObject implements Room {
    private HashMap<String, Listener> users;
    //Define the status codes
    private static final int ok = 200;
    private static final int already_exists = 409;

    public RoomImpl() throws RemoteException {
        //initialize an empty listener hashmap
        users = new HashMap<String, Listener>();
    }


    @Override
    public void broadcastMessage(String sender, String message) throws RemoteException {
        Iterator it = users.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();

            Listener listener = (Listener)pair.getValue();
            listener.newMessage(sender, message);
        }
    }

    @Override
    public void sendMessageTo(ArrayList<String> recievers, String sender, String message) throws RemoteException {
        recievers.add(sender);

        for (String reciever: recievers) {
            try {
                Listener listener = users.get(reciever);
                listener.newMessage(sender, message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public int addUser(String userName, Listener listener) throws RemoteException {
        try {
            //Check if th userName already exists in the users list
            if (users.containsKey(userName)) {
                return already_exists;
            } else {
                users.put(userName, listener);
                return ok;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 500;
        }
    }
}