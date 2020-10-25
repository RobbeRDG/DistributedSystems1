package ServerSide.ChatRoomServer;

import Objects.ChatUser;
import Objects.Chat;
import Objects.ChatMessage;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

public class RoomImpl extends UnicastRemoteObject implements Room {
    private HashMap<UUID, Chat> chats;
    private HashMap<String, ChatUser> users;

    //Define the status codes
    private static final int ok = 200;
    private static final int already_exists = 409;

    //Define the id of the broadcast chat
    private static final UUID broadcastChatId = UUID.randomUUID();

    public RoomImpl() throws RemoteException {
        //initialize the user hashmap
        users = new HashMap<String, ChatUser>();

        //initialize the chats hashmap and place a group chat in it
        chats = new HashMap<UUID, Chat>();
        chats.put(broadcastChatId, new Chat("Broadcast", broadcastChatId));
    }


    @Override
    public void broadcastMessage(ChatMessage message) throws RemoteException {
        chats.get(broadcastChatId).addMessage(message);
    }

    @Override
    public ArrayList<Chat> getSubscriptions(String userName) throws RemoteException {
        //first get the correct user
        ChatUser user = users.get(userName);

        //get all the chats he is subscribed to and add them to the subscriptionlist
        ArrayList<Chat> subscriptions = new ArrayList<>();
        for (UUID chatId: user.getSubscriptionIds()) {
            subscriptions.add(chats.get(chatId));
        }

        return subscriptions;
    }

    @Override
    public int addUser(String userName) throws RemoteException {
        try {
            //Check if the userName already exists in the users hashmap
            if (users.containsKey(userName)) {
                //if the user already exists, return an error code
                return already_exists;
            } else {
                //if the user doesnt exist, create a new user and subscribe him to the broadcast chat
                ChatUser user = new ChatUser(userName);

                users.put(userName, user);
                user.addSubscriptionId(broadcastChatId);
                return ok;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 500;
        }
    }
}