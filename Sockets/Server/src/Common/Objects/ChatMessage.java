package Common.Objects;

import java.io.Serializable;
import java.rmi.Remote;
import java.util.UUID;

public class ChatMessage  implements  Serializable {
    private static final long serialVersionUID = 6L;

    private String sender;
    private String messageText;
    private UUID messageId;

    public ChatMessage(String sender, String messageText) {
        this.sender = sender;
        this.messageText = messageText;
        messageId = UUID.randomUUID();
    }

    public String toString() {
        return (sender + " : " + messageText);
    }

    public String getSender() {
        return sender;
    }

    public String getMessageText() {
        return messageText;
    }

    public UUID getId() {
        return messageId;
    }
}