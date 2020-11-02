package ServerSide.ServerController;

import ClientSide.ClientConnection.Listener.ClientListener;
import Objects.ChatMessage;
import Objects.ServerLogicException;

import java.util.ArrayList;
import java.util.UUID;

public interface ServerController {
    void addUser(String userName, ClientListener clientListener) throws ServerLogicException;
    void removeUser(String userName) throws ServerLogicException;
    ArrayList<String> getOnlineUsers() throws ServerLogicException;
    void sendMessage(ChatMessage message, UUID chatId) throws ServerLogicException;
    void createChat(String userName, String chatName, ArrayList<String> subscribers) throws ServerLogicException;
}
