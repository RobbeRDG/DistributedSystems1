package ClientSide.Connection;

import Objects.Chat;
import Objects.ChatMessage;
import ServerSide.ChatRoomServer.Room;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

public class Connection {
    private Room chatRoom;

    public Connection(){
    }

    public void connectToChatRoom() throws RemoteException, NotBoundException {
        // Fire to localhost port 2222
        Registry myRegistry = LocateRegistry.getRegistry("localhost", 2222);

        // Initialize the chatroom
        Room room = (Room) myRegistry.lookup("ChatService");
        chatRoom = room;
    }

    public int addUser(String userName) {
        int statusCode = -1;

        try {
            statusCode = chatRoom.addUser(userName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return statusCode;
    }

    public void broadcastMessage(ChatMessage message) {
        try {
            chatRoom.broadcastMessage(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Chat> getSubscriptions(String userName) {
        ArrayList<Chat> subscriptions = new ArrayList<>();

        try {
            subscriptions = chatRoom.getSubscriptions(userName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return subscriptions;
    }
}
