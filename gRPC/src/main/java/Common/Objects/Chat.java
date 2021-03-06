package Common.Objects;

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

    public Chat(String name, UUID id, ArrayList<String> subscribers, ArrayList<ChatMessage> messages) {
        this.name = name;
        this.id = id;
        this.messages = messages;
        this.subscribers = subscribers;
    }

    public ArrayList<ChatMessage> getMessages() {
        return messages;
    }

    public ArrayList<String> getMessagesInString(){
        ArrayList<String> messageStrings = new ArrayList<>();
        for (ChatMessage chatMessage : messages){
            messageStrings.add(chatMessage.toString());
        }
        return messageStrings;
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

    public void addSubscribers(ArrayList<String> subscribers) {
        this.subscribers.addAll(subscribers);
    }
}
