package ClientSide.ClientConnection.Threads;

import ClientSide.ClientConnection.ClientConnection;
import Common.Objects.Chat;
import Common.Objects.SocketMessage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class InputListenerThread extends Thread{
    private ClientConnection connection;
    private ObjectInputStream in;

    public InputListenerThread( Socket socket, ClientConnection connection) throws IOException {
        in = new ObjectInputStream(socket.getInputStream());;
        this.connection = connection;
    }

    @Override
    public void run() {
        while (true) {
            try {
                SocketMessage input = (SocketMessage) in.readObject();
                handleMessage(input);

            } catch (Exception e) {
                return;
            }

        }
    }

    private void handleMessage(SocketMessage message) {
        if (message.getType() == "chatUpdate") sendChatUpdate((Chat) message.getPayload().get("chat"));
        if (message.getType() == "response") relayResponse(message);

            else {
                connection.updateResponse(message);
            }
        }

    private void relayResponse(SocketMessage message) {
        connection.updateResponse(message);
    }





    private void sendChatUpdate(Chat chat) {
        connection.chatUpdate(chat);
    }
}
