package ClientSide.ClientConnection;

import ClientSide.ClientController.ClientController;

import java.util.ArrayList;
import java.util.HashMap;

public interface ClientConnection {
    void connectToServer() throws Exception;

    void addUser(String userName) throws Exception;

    void setClientController(ClientController clientController) throws Exception;

    void chatUpdate(HashMap<String, String> chat);

    void removeUser(String userName) throws Exception;

    void sendMessage(String messageSender, String messageText, String tabId) throws Exception;

    ArrayList<String> getOnlineUsers() throws Exception;

    void createChat(String userName, String chatName, ArrayList<String> chatUsers) throws Exception;

    void updateResponse(String response);

    void closeSocket();
}
