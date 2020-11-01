package Objects;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

public class Chat implements Serializable {
    private static final long serialVersionUID = 3L;

    private String name;
    private UUID id;
    private ArrayList<ChatMessage> messages;
    private ArrayList<String> subscribers;


    public Chat(String name, UUID id) {
        this.name = name;
        this.id = id;
        messages = new ArrayList<>();
        subscribers = new ArrayList<>();
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

    public ArrayList<String> getSubscribers() {
        return subscribers;
    }

    public void addSubscriber(String userName) {
        subscribers.add(userName);
    }

    public String getName() {
        return name;
    }
}
