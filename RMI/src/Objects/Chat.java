package Objects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class Chat {
    private String name;
    private UUID id;
    private ArrayList<ChatMessage> messages;


    public Chat(String name, UUID id) {
        this.name = name;
        this.id = id;
        messages = new ArrayList<>();
    }

    public ArrayList<ChatMessage> getMessages() {
        return messages;
    }

    public void addMessage(ChatMessage message) {
        messages.add(message);
    }

    public UUID getId() {
        return id;
    }
}
