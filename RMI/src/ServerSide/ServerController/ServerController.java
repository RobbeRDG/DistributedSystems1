package ServerSide.ServerController;

import ClientSide.ClientConnection.Listener.ClientListener;
import Objects.ChatMessage;

import java.util.ArrayList;
import java.util.UUID;

public interface ServerController {
    void addUser(String userName, ClientListener clientListener) throws Exception;
    void removeUser(String userName) throws Exception;
    ArrayList<String> getOnlineUsers() throws Exception;
    void sendMessage(ChatMessage message, UUID chatId) throws Exception;
    void createChat(String userName, String chatName, ArrayList<String> subscribers) throws Exception;
}
