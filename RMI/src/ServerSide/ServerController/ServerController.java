package ServerSide.ServerController;

import ClientSide.ClientConnection.Listener.ClientListener;
import Objects.ChatMessage;

import java.util.ArrayList;
import java.util.UUID;

public interface ServerController {
    int addUser(String userName, ClientListener clientListener);
    void removeUser(String userName);

    void sendMessage(ChatMessage message, UUID chatId);
    ArrayList<String> getOnlineUsers();

    void createChat(String userName, String chatName, ArrayList<String> subscribers) throws Exception;
}
