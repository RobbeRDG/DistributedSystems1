package ChatRoomServer;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerMain {

    private void startServer() {
        try {
            // Create on port 2222
            Registry registry = LocateRegistry.createRegistry(2222);

            // Create a new service named CounterService
            registry.rebind("ChatService", new ChatRoomImpl());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("System is ready");
    }

    public static void main(String[] args) {
        ServerMain serverMain = new ServerMain();
        serverMain.startServer();
    }
}