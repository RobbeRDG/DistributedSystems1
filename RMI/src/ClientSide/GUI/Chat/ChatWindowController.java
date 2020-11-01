package ClientSide.GUI.Chat;

import ClientSide.ClientController.ClientController;
import ClientSide.ClientController.ClientControllerImpl;
import Objects.Chat;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.HashMap;

public class ChatWindowController {
    private ClientController clientController;
    private HashMap<String,ChatTabController> chatTabControllers;

    @FXML
    private Button addChatButton;
    @FXML
    private ListView onlineUsersListView;
    @FXML
    private TabPane chatsTabPane;
    @FXML
    private AnchorPane root;

    public ChatWindowController() {
        chatTabControllers = new HashMap<>();
    }

    public void setGuiController(ClientControllerImpl clientController) {
        this.clientController = clientController;
    }

    public void updateTab(String tabId, Chat chat) {
        //Get the controller from the tab
        ChatTabController chatTabController = chatTabControllers.get(tabId);

        //update the corresponding tab
        chatTabController.updateTab(chat);
    }

    public void addTab(String tabId, Chat chat) throws IOException {
        //Load the chatTab fxml file
        FXMLLoader loader = new FXMLLoader();
        SplitPane pane = loader.load(getClass().getResource("ChatTab.fxml").openStream());


        //pass the clientController to the tab controller
        ChatTabController chatTabController = (ChatTabController)loader.getController();
        chatTabController.setClientController(clientController);

        //render the online users and messages
        chatTabController.updateTab(chat);

        //Add the tabcontroller to the tabcontrollers hashmap
        chatTabControllers.put(tabId,chatTabController);

        //Add a new tab to the tabpane
        Platform.runLater(new Runnable() {
            @Override public void run() {
                chatsTabPane.getTabs().add(new Tab(chat.getName(), pane));
            }
        });
    }
}
