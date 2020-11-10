package ClientSide.ClientConnection;

import ClientSide.ClientConnection.Threads.InputListenerThread;
import ClientSide.ClientController.ClientController;
import Common.Objects.Chat;
import Common.Objects.ChatMessage;
import Common.Objects.SocketMessage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class ClientConnectionImpl implements ClientConnection {
    private static ClientController clientController;
    private static InputListenerThread inputListenerThread;
    private Socket socket;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    private SocketMessage response;

    private static final String host = "localhost";
    private static final int port = 3333;


    public ClientConnectionImpl() {
    }

    @Override
    public void setClientController(ClientController clientController) {
        this.clientController = clientController;
    }

    @Override
    public void connectToServer() throws Exception {
        if (inputListenerThread != null) throw new Exception("A listener thread is already active");
        else {
            createSocket();
            inputListenerThread = new InputListenerThread(socket, this);
            inputListenerThread.start();
        }
    }

    private void createSocket() throws IOException {
        socket = new Socket(host, port);
        out = new ObjectOutputStream(socket.getOutputStream());
    }

    @Override
    public synchronized void addUser(String userName) throws Exception {
        //Create a new socket request
        HashMap<String, Object> payload = new HashMap<>();
        payload.put("userName", userName);
        UUID requestId = UUID.randomUUID();
        SocketMessage socketMessage = new SocketMessage(requestId, "request", "addUser", payload);

        //Send the message to the server
        out.writeObject(socketMessage);

        //Wait for the server response
        while(response == null) {
            wait();
        }

        if (response.getId() != requestId ) throw new Exception("response Id doesn't correspond with the request Id");

        if (response.isException()) throw (Exception) response.getPayload().get("exception");
    }



    @Override
    public void chatUpdate(Chat chat) {
        clientController.chatUpdate(chat);
    }

    @Override
    public void removeUser(String userName) throws Exception {
        //Create a new socket request
        HashMap<String, Object> payload = new HashMap<>();
        payload.put("userName", userName);
        UUID requestId = UUID.randomUUID();
        SocketMessage socketMessage = new SocketMessage(requestId, "request", "removeUser", payload);

        //Send the message to the server
        out.writeObject(socketMessage);

        //Wait for the server response
        while(response == null) {
            wait();
        }

        if (response.getId() != requestId ) throw new Exception("response Id doesn't correspond with the request Id");

        if (response.isException()) throw (Exception) response.getPayload().get("exception");
    }

    @Override
    public void sendMessage(ChatMessage message, String chatId) throws Exception {
        //Create a new socket request
        HashMap<String, Object> payload = new HashMap<>();
        payload.put("message", message);
        payload.put("chatId", chatId);
        UUID requestId = UUID.randomUUID();
        SocketMessage socketMessage = new SocketMessage(requestId, "request", "removeUser", payload);

        //Send the message to the server
        out.writeObject(socketMessage);

        //Wait for the server response
        while(response == null) {
            wait();
        }

        if (response.getId() != requestId ) throw new Exception("response Id doesn't correspond with the request Id");

        if (response.isException()) throw (Exception) response.getPayload().get("exception");
    }

    @Override
    public ArrayList<String> getOnlineUsers() throws Exception {
        //Create a new socket request
        HashMap<String, Object> payload = new HashMap<>();
        UUID requestId = UUID.randomUUID();
        SocketMessage socketMessage = new SocketMessage(requestId, "request", "removeUser", payload);

        //Send the message to the server
        out.writeObject(socketMessage);

        //Wait for the server response
        while(response == null) {
            wait();
        }

        if (response.getId() != requestId ) throw new Exception("response Id doesn't correspond with the request Id");

        if (response.isException()) throw (Exception) response.getPayload().get("exception");
        else return (ArrayList<String>) response.getPayload().get("onlineUsers");
    }

    @Override
    public void createChat(String userName, String chatName, ArrayList<String> chatUsers) throws Exception {
        //Create a new socket request
        HashMap<String, Object> payload = new HashMap<>();
        payload.put("userName", userName);
        payload.put("chatName", chatName);
        payload.put("chatUsers", chatUsers);
        UUID requestId = UUID.randomUUID();
        SocketMessage socketMessage = new SocketMessage(requestId, "request", "removeUser", payload);

        //Send the message to the server
        out.writeObject(socketMessage);

        //Wait for the server response
        while(response == null) {
            wait();
        }

        if (response.getId() != requestId ) throw new Exception("response Id doesn't correspond with the request Id");

        if (response.isException()) throw (Exception) response.getPayload().get("exception");
    }


    @Override
    public void updateResponse(SocketMessage message) {
        response = message;
        notify();
    }
}

