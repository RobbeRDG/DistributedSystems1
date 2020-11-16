package Common.Objects;

import java.util.HashMap;
import java.util.UUID;

public class SocketMessage {
    private static UUID messageId;
    private String type;
    private String name;
    private HashMap<String, Object> payload;

    public SocketMessage(UUID messageId, String type) {
        this.messageId = messageId;
        this.type = type;
        name = "";
        payload = new HashMap<>();
    }

    public SocketMessage(UUID messageId, String type, String name, HashMap<String, Object> payload) {
        this.messageId = messageId;
        this.type = type;
        this.name = name;
        this.payload = payload;
    }

    public String getName() {
        return name;
    }

    public HashMap<String, Object> getPayload() {
        return payload;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addPayload(String key, Object object) {
        payload.put(key, object);
    }

    public String getType() {
        return type;
    }

    public boolean isRequest() {
        if (type == "request") return true;
        else return false;
    }

    public UUID getId() {
        return messageId;
    }
}
