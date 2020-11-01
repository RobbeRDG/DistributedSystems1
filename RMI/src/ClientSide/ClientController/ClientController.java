package ClientSide.ClientController;

import Objects.Chat;

import java.io.IOException;

public interface ClientController {
    int addUser(String userName);
    void showChat() throws IOException;
    void showLogin() throws IOException;
    void chatUpdate(Chat chat);

    void sendMessage(String messageText, String tabId);
}
