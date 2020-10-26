package ServerSide.ChatRoomServer;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ChatRoomServer {

    public void startServer() {
        try {
            // Create on port 2222
            Registry registry = LocateRegistry.createRegistry(2222);

            // Create a new service named CounterService
            registry.rebind("ChatService", new RoomImpl());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("System is ready");
    }


}