package ServerSide.ServerConnection.Threads;

import Common.Objects.Chat;
import Common.SocketMessageEncoder;
import ServerSide.ServerConnection.ServerConnection;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;
import java.util.UUID;

public class ChatThread extends Thread{
    private Socket socket;
    private ServerConnection connectionController;
    private PrintWriter out;
    private BufferedReader in;
    private static final SocketMessageEncoder encoder = new SocketMessageEncoder();


    public ChatThread(Socket socket, ServerConnection connectionController) throws IOException {
        this.socket = socket;
        this.connectionController = connectionController;

        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
    }

    @Override
    public void run() {
        try {
            String message;
            while ((message = in.readLine()).isEmpty() != true) {
                if (encoder.getType(message).equals("closeSocket")) break;
                handleRequest(message);
            }
        } catch (Exception e) {
                e.printStackTrace();
                return;
        }
    }


    /*
    This method sends the message request to the correct servercontroller method
     */
    private void handleRequest(String message) throws Exception {
        //Get the socketMessage request and payload
        String requestType = encoder.getType(message);

        if (requestType == "ok" || requestType == "exception") return;
        else {
            HashMap<String, String> requestParam = encoder.getParameterHashMap(message);

            try {
                switch (requestType) {
                    case "addUser":
                        connectionController.addUser(requestParam, this);
                        break;
                    case "removeUser":
                        connectionController.removeUser(requestParam);

                        break;
                    case "sendMessage":
                        connectionController.sendMessage(requestParam);

                        break;
                    case "createChat":
                        connectionController.createChat(requestParam);

                        break;
                    case "getOnlineUsers":
                        String returnMessage = "ok" + ";" + connectionController.getOnlineUsers(requestParam);
                        out.println(returnMessage);
                        break;
                    default:
                        break;
                }


            } catch (Exception e) {
                System.out.println(e.getMessage());
                String exceptionMessage = encoder.encodeException(e);
                out.write(exceptionMessage);
            }
        }
    }


    public void chatUpdate(String socketMessage) {
        out.println(socketMessage);
    }
}
