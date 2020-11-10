package ClientSide.ClientConnection;

import ClientSide.ClientController.ClientController;
import Common.Objects.Chat;
import Common.Objects.ChatMessage;
import Common.Objects.SocketMessage;

import java.io.ObjectInputStream;
import java.util.ArrayList;

public interface ClientConnection {
    void connectToServer() throws Exception;

    void addUser(String userName) throws Exception;

    void setClientController(ClientController clientController) throws Exception;

    void chatUpdate(Chat chat);

    void removeUser(String userName) throws Exception;

    void sendMessage(ChatMessage message, String tabId) throws Exception;

    ArrayList<String> getOnlineUsers() throws Exception;

    void createChat(String userName, String chatName, ArrayList<String> chatUsers) throws Exception;

    void updateResponse(SocketMessage message);
}
