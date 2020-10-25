package Objects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class ChatUser {
    private String name;
    private ArrayList<UUID> subscriptionIds;

    public ChatUser(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addSubscriptionId(UUID chatId) {
        subscriptionIds.add(chatId);
    }

    public ArrayList<UUID> getSubscriptionIds() {
        return subscriptionIds;
    }
}
