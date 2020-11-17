package ClientSide.ClientConnection.Threads;

import ClientSide.ClientConnection.ClientConnection;
import Common.Objects.Chat;
import Common.SocketMessageEncoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.HashMap;

public class InputListenerThread extends Thread{
    private ClientConnection connection;
    private BufferedReader in;
    private static final SocketMessageEncoder encoder = new SocketMessageEncoder();

    public InputListenerThread(Socket socket, ClientConnection connection) throws IOException {
        in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
        this.connection = connection;
    }

    @Override
    public void run() {
        try {
            String message;
            while ((message = in.readLine()).isEmpty() != true) {
                handleMessage(message);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    private void handleMessage(String message) {
        if (encoder.getType(message).equals("chatUpdate")) {
            sendChatUpdate(encoder.getParameterHashMap(message));
        }
        else relayResponse(message);
    }

    private void relayResponse(String message) {
        connection.updateResponse(message);
    }

    private void sendChatUpdate(HashMap<String,String> chatHashMap) {
        connection.chatUpdate(chatHashMap);
    }
}
