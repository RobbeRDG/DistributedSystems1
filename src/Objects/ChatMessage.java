package Objects;

public class ChatMessage {
    private ChatUser sender;
    private String messageText;

    public ChatMessage(ChatUser sender, String messageText) {
        this.sender = sender;
        this.messageText = messageText;
    }

    public String toString() {
        return (sender.getName() + " : " + messageText);
    }
}
