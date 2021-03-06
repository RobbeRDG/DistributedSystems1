package ServerSide.ServerController;

import Common.Objects.*;
import ServerSide.ServerConnection.ServerConnection;
import ServerSide.ServerConnection.ServerConnectionImpl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class ServerControllerImpl implements ServerController{
    private ServerConnection serverConnection;
    private HashMap<String, ChatUser> users;
    private HashMap<UUID, Chat> chats;

    //Define the id of the broadcast chat
    private static final UUID broadcastChatId = UUID.randomUUID();

    //###############################################################################################################
    //      LOGIC
    //###############################################################################################################

    public ServerControllerImpl() throws RemoteException {
        //initialize the user hashmap
        users = new HashMap<String, ChatUser>();

        //initialize the group chat
        Chat groupChat = new Chat("Broadcast", broadcastChatId);

        //initialize the chats hashmap and place a group chat in it
        chats = new HashMap<UUID, Chat>();
        chats.put(broadcastChatId, groupChat);

        //Initialize the serverConnection
        serverConnection = new ServerConnectionImpl(this);
    }

    public static void main(String[] args) throws RemoteException {
        try {
            ServerControllerImpl serverController = new ServerControllerImpl();
            serverController.start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

    }

    private void start() throws Exception {
        //Start the serverConnection
        serverConnection.startServerConnection();
    }



    //###############################################################################################################
    //      USER
    //###############################################################################################################

    @Override
    public synchronized void addUser(String userName) throws Exception {
        try {
            //Check if the userName already exists in the users hashmap
            if (users.containsKey(userName)) {
                //if the user already exists, return an Exception
                throw new IllegalArgumentException(userName + " couldn't be created: User already exists");
            } else {
                //if the user doesnt exist, create a new user and subscribe him to the broadcast chat
                ChatUser user = new ChatUser(userName);

                users.put(userName, user);
                chats.get(broadcastChatId).addSubscriber(userName);


                //message all the subscribers with the new update to the broadcast chat
                chatUpdate(broadcastChatId);

                System.out.println("Created a new user: " + userName);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    @Override
    public synchronized void removeUser(String userName) throws Exception {
        try {
            //Check if the user exists
            if (users.get(userName) == null) {
                String exceptionMessage = (userName + " couldn't be deleted : User not registered on the server");
                throw new IllegalArgumentException(exceptionMessage);
            }

            //remove user from the users hashmap
            users.remove(userName);

            //Remove tha user from all his subscriptions
            for (Chat chat : chats.values()) {
                if (chat.getSubscribers().contains(userName)) {
                    chat.getSubscribers().remove(userName);

                    //update the new chat
                    chatUpdate(chat.getId());
                }
            }

            System.out.println(userName + " has been deleted");

        } catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    @Override
    public ArrayList<String> getOnlineUsers() throws Exception {
        try {
            return new ArrayList<>(users.keySet());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }


    //###############################################################################################################
    //      CHAT
    //###############################################################################################################

    public synchronized void sendMessage(String messageSender, String messageText, UUID chatId) throws Exception {
        try {
            //Create a message
            ChatMessage message = new ChatMessage(messageSender, messageText);

            //find if the user and chat exist
            if(!users.containsKey(message.getSender())) throw new IllegalArgumentException("Couldn't send message : User (" + message.getSender() + ") is not registerd on the server");
            if(!chats.containsKey(chatId)) throw new IllegalArgumentException("Couldn't send message : Chat (" + chatId.toString() + ") can't be located on the server");

            //find the corresponding chat
            Chat chat = chats.get(chatId);

            //Add the message to the chat
            chat.addMessage(message);

            //Notify all subscribers from that chat with the new Message
            chatUpdate(chatId);

            System.out.println("New message handled ( " + message.toString() +" )");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    @Override
    public synchronized void createChat(String userName, String chatName, ArrayList<String> subscribers) throws Exception {
        try {
            //find if the user exist
            if(!users.containsKey(userName)) throw new Exception("Couldn't create new chat : User does not exist");

            //generate a new chatId
            UUID chatId = UUID.randomUUID();

            //Create the new Chat
            Chat chat = new Chat(chatName, chatId);

            //add the sender to the subscribers
            subscribers.add(userName);

            //set each user as subscriber in the chat
            chat.addSubscribers(subscribers);

            //Add the chat to the chat hashmap
            chats.put(chatId, chat);

            //notify the subscribers of the new chat
            chatUpdate(chatId);

            System.out.println("New chat created: " + chatName);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    private synchronized void chatUpdate(UUID chatId) {
        try {
            //Get the chat
            Chat chat = chats.get(chatId);

            //for each subscriber of that chat, send the new updated chat object to the listener of that user
            for( String userName: chat.getSubscribers()) {
                try {
                    //find the corresponding listener
                    serverConnection.chatUpdate(userName, chat);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }





}
