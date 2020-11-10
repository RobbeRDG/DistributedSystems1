package ServerSide.ServerConnection.Threads;

import Common.Objects.Chat;
import Common.Objects.SocketMessage;
import ServerSide.ServerConnection.ServerConnection;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.UUID;

public class ChatThread extends Thread{
    private Socket socket;
    private ServerConnection connectionController;
    private OutputStreamWriter out;
    private InputStreamReader in;

    public ChatThread(Socket socket, ServerConnection connectionController) throws IOException {
        this.socket = socket;
        this.connectionController = connectionController;

        in = new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8);
        out = new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8);
    }

    @Override
    public void run() {
        while (true) {
            try {
                in.read();
                SocketMessage socketMessage = (SocketMessage) message;
                if (socketMessage.isRequest()) handleRequest(socketMessage);
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
    }


    /*
    This method sends the message request to the correct servercontroller method
     */
    private void handleRequest(SocketMessage socketMessage) throws Exception {
        //Get the socketMessage request and payload
        String name = socketMessage.getName();
        HashMap<String, Object> payload = socketMessage.getPayload();

        SocketMessage returnMessage = new SocketMessage(socketMessage.getId(), "response");


       try {
           switch (name) {
               case "addUser":
                   connectionController.addUser(payload, this);
                   break;
               case "removeUser":
                   connectionController.removeUser(payload);
                   returnMessage.setName("ok");
                   break;
               case "sendMessage":
                   connectionController.sendMessage(payload);
                   returnMessage.setName("ok");
                   break;
               case "createChat":
                   connectionController.createChat(payload);
                   returnMessage.setName("ok");
                   break;
               case "getOnlineUsers":
                   returnMessage.addPayload("onlineUsers", connectionController.getOnlineUsers());
                   returnMessage.setName("ok");
                   break;
               default:
                   break;
           }
       } catch (Exception e) {
           System.out.println(e.getMessage());
           returnMessage.setName("exception");
           returnMessage.addPayload("exceptionMessage", e);
       } finally {
            respondToClient(returnMessage);
       }





    }

    private void respondToClient(SocketMessage returnMessage) {
        try {
            out.writeObject(returnMessage);
            out.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }


    public void chatUpdate(Chat chat) {
        UUID updateId = UUID.randomUUID();
        HashMap<String, Object> payload = new HashMap<>();
        payload.put("chat", chat);
        SocketMessage returnMessage = new SocketMessage(updateId, "chatUpdate", "chatUpdate", payload);
        respondToClient(returnMessage);
    }
}
