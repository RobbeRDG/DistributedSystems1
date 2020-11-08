package ServerSide.ServerController;

import Common.ClientListener;
import Common.Objects.ChatMessage;

import java.util.ArrayList;
import java.util.UUID;

public interface ServerController {
    void addUser(String userName) throws Exception;
    void removeUser(String userName) throws Exception;
    ArrayList<String> getOnlineUsers() throws Exception;
    void sendMessage(ChatMessage message, UUID chatId) throws Exception;
    void createChat(String userName, String chatName, ArrayList<String> subscribers) throws Exception;
}
