package Client.ChatRoomListener;

import Server.ChatRoomServer.Room;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

public class ChatRoomListener {
    private Room chatRoom;
    private Listener listener;
    public ChatRoomListener(){
    }

    public void startListener() throws RemoteException, NotBoundException {
        // Fire to localhost port 2222
        Registry myRegistry = LocateRegistry.getRegistry("localhost", 2222);

        // Initialize the chatroom
        Room room = (Room) myRegistry.lookup("ChatService");
        chatRoom = room;


        //Initialize the chatListener
        ListenerImpl listener = new ListenerImpl();
        this.listener = listener;
    }

    public Room getChatRoom() {
        return chatRoom;
    }

    public Listener getListener() {
        return listener;
    }
}
