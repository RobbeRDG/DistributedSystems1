package Common.Objects;

import java.io.Serializable;
import java.rmi.Remote;

public class ChatMessage implements Remote, Serializable {
    private static final long serialVersionUID = 6L;

    private String sender;
    private String messageText;

    public ChatMessage(String sender, String messageText) {
        this.sender = sender;
        this.messageText = messageText;
    }

    public ChatMessage(String messageString) {
        String[] messageArray = messageString.split(" : ");
        this.sender = messageArray[0];
        this.messageText = messageArray[1];
    }

    public String toString() {
        return (sender + " : " + messageText);
    }

    public String getSender() {
        return sender;
    }
}
