package Common.Objects;


public class ChatUser extends ChatObject {
    private String name;

    public ChatUser(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
