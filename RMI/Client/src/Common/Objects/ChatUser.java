package Common.Objects;

import Common.ClientListener;

public class ChatUser {
    private String name;

    public ChatUser(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}