package ClientSide.GUI.Chat;

import ClientSide.ClientController.ClientController;
import Common.Objects.Chat;
import Common.Objects.ChatMessage;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;

import java.io.IOException;


public class ChatTabController {
    private ClientController clientController;
    private String tabId;
    private Chat chat;
    @FXML
    private SplitPane root;
    @FXML
    private ListView messageListView;
    @FXML
    private Button submitButton;
    @FXML
    private TextField textField;
    @FXML
    private ListView subscribersListView;

    public void handleSubmitButton(javafx.event.ActionEvent actionEvent) throws IOException {
        //Get the textField input
        String messageText = textField.getText();

        //If the message is empty, do nothing
        if (messageText.isEmpty()) return;

        //send the message to the clientController
        clientController.sendMessage(messageText, tabId);

        textField.clear();
    }

    public void setClientController(ClientController clientController) {
        this.clientController = clientController;
    }

    public void updateTab(Chat chat) {
        this.chat = chat;
        tabId = chat.getId().toString();
        renderMessages();
        renderUsers();
    }

    private void renderMessages() {
        //get the message list
        ObservableList<ChatMessage> messages = FXCollections.observableArrayList(chat.getMessages());

        Platform.runLater(new Runnable() {
            @Override public void run() {
                messageListView.setItems(messages);
            }
        });

    }

    private void renderUsers() {
        ObservableList<String> users = FXCollections.observableArrayList(chat.getSubscribers());

        Platform.runLater(new Runnable() {
            @Override public void run() {
                subscribersListView.setItems(users);
            }
        });
    }
}
