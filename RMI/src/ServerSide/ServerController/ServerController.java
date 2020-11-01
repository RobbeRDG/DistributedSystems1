package ServerSide.ServerController;

import ClientSide.ClientConnection.Listener.ClientListener;
import Objects.ChatMessage;

import java.util.UUID;

public interface ServerController {
    int addUser(String userName, ClientListener clientListener);
    void removeUser(String userName);

    void sendMessage(ChatMessage message, UUID chatId);
}
