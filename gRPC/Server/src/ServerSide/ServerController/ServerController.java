package ServerSide.ServerController;

import java.util.ArrayList;
import java.util.UUID;

public interface ServerController {
    void addUser(String userName) throws Exception;
    void removeUser(String userName) throws Exception;
    ArrayList<String> getOnlineUsers() throws Exception;
    void sendMessage(String messageSender, String messageText, UUID chatId) throws Exception;
    void createChat(String userName, String chatName, ArrayList<String> subscribers) throws Exception;
}
