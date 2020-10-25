package ClientSide.GUI;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;

import java.util.ArrayList;

public class ChatController {
    private GUI guiController;
    private ArrayList<String> messages;

    @FXML
    private Button submitButton;
    @FXML
    private ScrollPane onlineUsersPane;
    @FXML
    private ScrollPane messagePane;
    @FXML
    private TextArea textInput;

    public void initialize() {
        messages = new ArrayList<>();
    }

    public void setGuiController(GUI guiController) {
        this.guiController = guiController;
    }

    public void addMessage(String sender, String message) {
        messages.add((sender+ " : " + message));
    }

    public void renderMessages() {

    }
}
