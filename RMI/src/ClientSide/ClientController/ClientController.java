package ClientSide.ClientController;

import Objects.Chat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface ClientController {
    int addUser(String userName);
    void showChat() throws IOException;
    void showLogin() throws IOException;
    void chatUpdate(Chat chat);
    String getUser();

    void sendMessage(String messageText, String tabId);
    ArrayList<String> getOnlineUsers();

    void createChat(String chatName, ArrayList<String> chatUsers);
}
