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

    public void addSubscribers(ArrayList<String> subscribers) {
        this.subscribers.addAll(subscribers);
    }

    public String toSocketMessage() {
        //Place the subscribers in a string
        StringBuilder sb1 = new StringBuilder();
        sb1.append("subscribers:");
        for (int i=0; i<subscribers.size(); i++) {
            sb1.append(subscribers.get(i));
            if (i != subscribers.size()-1) sb1.append("/");
        }
        String subscriberString = sb1.toString();

        //Place the messages in a string
        StringBuilder sb2 = new StringBuilder();
        sb2.append("messages");
        for (int i=0; i<messages.size(); i++) {
            sb2.append(messages.get(i).getId().toString());
            if (i != messages.size()-1) sb2.append("/");
        }
        String messagesString = sb2.toString();

        //Place the differenct messages in a string
        StringBuilder sb3 = new StringBuilder();
        for (int i=0; i<messages.size(); i++) {
            ChatMessage message = messages.get(i);
            sb3.append(message.getId().toString());
            sb3.append(message.getSender());
            sb3.append(message.getMessageText());
            if (i != messages.size()-1) sb3.append(",");
        }
        String messageDetails = sb3.toString();

        return subscriberString + "," + messagesString + "," + messageDetails;
    }
}
