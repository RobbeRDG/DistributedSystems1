package ClientSide.ClientController;

import Common.Objects.Chat;

import java.io.IOException;
import java.util.ArrayList;

public interface ClientController {
    void showChat() throws IOException;
    void showLogin() throws IOException;
    void addUser(String userName) throws IllegalArgumentException;
    void chatUpdate(Chat chat);
    String getUser();

    void sendMessage(String messageText, String tabId);
    ArrayList<String> getOnlineUsers();

    void createChat(String chatName, ArrayList<String> chatUsers);
}
