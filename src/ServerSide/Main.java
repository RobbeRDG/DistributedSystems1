package ServerSide;

import ServerSide.ChatRoomServer.ChatRoomServer;

public class Main {
    public static void main(String[] args) {
        ChatRoomServer serverMain = new ChatRoomServer();
        serverMain.startServer();
    }
}
