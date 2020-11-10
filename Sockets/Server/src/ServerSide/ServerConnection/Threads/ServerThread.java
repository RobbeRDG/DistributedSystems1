package ServerSide.ServerConnection.Threads;

import ServerSide.ServerConnection.ServerConnection;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*
* This class runs a while loop constantly checking if a new socket wants to connect
 */
public class ServerThread extends Thread {
    private int portNumber;
    private ServerSocket serverSocket;
    private ServerConnection connectionController;

    public ServerThread(int portNumber, ServerConnection connectionController) throws IOException {
        this.portNumber = portNumber;
        this.connectionController = connectionController;
        createServerSocket();
    }

    @Override
    public void run() {
        Socket socket = null;

        //Start looking for requests
        while (true) {
            try {
                socket = serverSocket.accept();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            // new thread for a client
            connectionController.createNewChatThread(socket);
        }
    }

    private void createServerSocket() throws IOException {
        serverSocket = new ServerSocket(portNumber);
    }
}
