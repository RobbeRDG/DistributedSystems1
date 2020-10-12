package Client.ChatRoomListener;

import Server.ChatRoomServer.Room;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ChatRoomListener {
    public ChatRoomListener(){
    }

    public void startListener() throws RemoteException, NotBoundException {
        // Fire to localhost port 2222
        Registry myRegistry = LocateRegistry.getRegistry("localhost", 2222);

        // Initialize the chatroom
        Room room = (Room) myRegistry.lookup("ChatService");


        //Initialize the chatListener
        ListenerImpl listener = new ListenerImpl();
    }
}
