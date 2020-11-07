package Common.Objects;

import Common.ClientListener;

public class ChatUser {
    private String name;private ClientListener clientListener;

    public ChatUser(String name, ClientListener clientListener) {
        this.name = name;
        this.clientListener = clientListener;
    }

    public String getName() {
        return name;
    }


    public ClientListener getClientListener() {
        return clientListener;
    }
}
