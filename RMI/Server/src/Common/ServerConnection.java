package Common;

import Common.Objects.ChatMessage;

import java.io.Serializable;
import java.rmi.Remote;
import java.util.ArrayList;
import java.util.UUID;

public interface ServerConnection extends Remote, Serializable {

    void addUser(String userName, ClientListener clientListener) throws Exception;
    void removeUser(String userName) throws Exception;
    void sendMessage(String messageText, String messageSender, UUID chatId) throws Exception;
    void createChat(String userName, String chatName, ArrayList<String> subscribers) throws Exception;
    ArrayList<String> getOnlineUsers() throws Exception;
}