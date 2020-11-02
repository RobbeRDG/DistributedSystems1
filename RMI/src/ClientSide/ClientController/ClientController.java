package ClientSide.ClientController;

import Objects.Chat;
import Objects.ServerLogicException;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public interface ClientController {
    void showChat() throws IOException;
    void showLogin() throws IOException;
    void addUser(String userName) throws ServerLogicException, RemoteException, Exception;
    void chatUpdate(Chat chat);
    String getUser();

    void sendMessage(String messageText, String tabId);
    ArrayList<String> getOnlineUsers();

    void createChat(String chatName, ArrayList<String> chatUsers);
}
