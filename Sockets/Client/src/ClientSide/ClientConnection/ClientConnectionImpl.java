package ClientSide.ClientConnection;

import ClientSide.ClientConnection.Threads.InputListenerThread;
import ClientSide.ClientController.ClientController;
import Common.Objects.Chat;
import Common.SocketMessageEncoder;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ClientConnectionImpl implements ClientConnection {
    private static ClientController clientController;
    private static InputListenerThread inputListenerThread;
    private Socket socket;
    private PrintWriter out;
    private String response;
    private static final SocketMessageEncoder encoder = new SocketMessageEncoder();

    private static final String host = "localhost";
    private static final int port = 3333;

    /////////////////////////////////////////////////////////////////////////////////////////////////////
    //////          LOGIC
    /////////////////////////////////////////////////////////////////////////////////////////////////////

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
        out = new PrintWriter(socket.getOutputStream(), true);
    }


    @Override
    public synchronized void updateResponse(String response) {
        this.response = response;
        notify();
    }

    @Override
    public void chatUpdate(HashMap<String, String> chatHashMap) {
        Chat chat = encoder.decodeChatUpdate(chatHashMap);
        clientController.chatUpdate(chat);
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////
    //////          TO SERVER
    /////////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public synchronized void addUser(String userName) throws Exception {
        //Create a new socket request
        HashMap<String, String> args = new HashMap();
        args.put("userName", userName);
        String socketMessage = encoder.encodeToSocketMessage("addUser", args);

        //Send the message to the server
        out.println(socketMessage);

        //Wait for the server response
        while(response == null) {
            wait();
        }

        if (encoder.getType(response).equals("exception")) throw encoder.getException(response);
        response = null;
    }



    @Override
    public synchronized void removeUser(String userName) throws Exception {
        //Create a new socket request
        HashMap<String, String> args = new HashMap();
        args.put("userName", userName);
        String socketMessage = encoder.encodeToSocketMessage("removeUser", args);

        //Send the message to the server
        out.println(socketMessage);

        //Wait for the server response
        while(response == null) {
            wait();
        }

        if (encoder.getType(response).equals("exception")) throw encoder.getException(response);
        response = null;
    }


    @Override
    public synchronized void sendMessage(String messageSender, String messageText, String chatId) throws Exception {
        //Create a new socket request
        HashMap<String, String> args = new HashMap() {{
            put("messageText", messageText);
            put("messageSender", messageSender);
            put("chatId", chatId);
        }};
        String socketMessage = encoder.encodeToSocketMessage("sendMessage", args);

        //Send the message to the server
        out.println(socketMessage);

        //Wait for the server response
        while(response == null) {
            wait();
        }

        if (encoder.getType(response).equals("exception")) throw encoder.getException(response);
        response = null;
    }


    @Override
    public synchronized ArrayList<String> getOnlineUsers() throws Exception {
        //Create a new socket request
        HashMap<String, String> args = new HashMap();
        String socketMessage = encoder.encodeToSocketMessage("getOnlineUsers", args);

        //Send the message to the server
        out.println(socketMessage);

        //Wait for the server response
        while(response == null) {
            wait();
        }

        if (encoder.getType(response).equals("exception")) throw encoder.getException(response);

        //Get the message Arraylist
        HashMap<String,String> responseParameters = encoder.getParameterHashMap(response);
        ArrayList<String> onlineUsersArraylist = new ArrayList<>();
        onlineUsersArraylist.addAll(Arrays.asList(responseParameters.get("onlineUsers").split("/")));

        response = null;

        return onlineUsersArraylist;

    }



    @Override
    public synchronized void createChat(String userName, String chatName, ArrayList<String> chatUsers) throws Exception {
        //Create a new socket request
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<chatUsers.size(); i++) {
            sb.append(chatUsers.get(i));
            if (i != (chatUsers.size() - 1)) sb.append("/");
        }
        String subscribersString = sb.toString();

        HashMap<String, String> args = new HashMap() {{
            put("userName", userName);
            put("chatName", chatName);
            put("subscribers", subscribersString);
        }};
        String socketMessage = encoder.encodeToSocketMessage("createChat", args);

        //Send the message to the server
        out.println(socketMessage);

        //Wait for the server response
        while(response == null) {
            wait();
        }

        if (encoder.getType(response).equals("exception")) throw encoder.getException(response);

        response = null;
    }

    @Override
    public void closeSocket() {
        out.println("closeSocket;");
    }



}

