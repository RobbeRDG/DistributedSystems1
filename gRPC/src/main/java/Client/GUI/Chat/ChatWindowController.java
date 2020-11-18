package Client.GUI.Chat;

import Client.ClientController.ClientController;
import Client.ClientController.ClientControllerImpl;
import Common.Objects.Chat;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

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

    public void addTab(String tabId, Chat chat) {
        try {
            //Load the chatTab fxml file
            FXMLLoader loader = new FXMLLoader();
            SplitPane pane = loader.load(getClass().getResource("/ChatTab.fxml").openStream());


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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void handleAddChatButton(javafx.event.ActionEvent actionEvent) {
        try {
            //Create new chat dialog window
            Dialog<ArrayList<String>> newChatDialog = createNewChatDialog();

            //Display the dialog
            Optional<ArrayList<String>> chatParameters = newChatDialog.showAndWait();

            chatParameters.ifPresent(paramters -> {
                //Extract the correct parameters
                String chatName = paramters.get(0);
                ArrayList<String> subscribers = new ArrayList<>();
                for (int i=1; i<paramters.size(); i++) {
                    subscribers.add(paramters.get(i));
                }

                clientController.createChat(chatName, subscribers);
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Dialog<ArrayList<String>> createNewChatDialog() {
        try {
            //Create the custom dialog.
            Dialog<ArrayList<String>> dialog = new Dialog<>();
            dialog.setTitle("New Chat");
            dialog.setHeaderText("Please complete the form to create a new chat");

            // Set the button types.
            ButtonType submit = new ButtonType("Create", ButtonBar.ButtonData.OK_DONE);
            dialog.getDialogPane().getButtonTypes().addAll(submit, ButtonType.CANCEL);

            //Create the layout grid
            GridPane grid = new GridPane();
            grid.setHgap(10);
            grid.setVgap(10);
            grid.setPadding(new Insets(20, 150, 10, 10));

            //Create the chat name input and place in grid
            TextField chatNameInput = new TextField();
            grid.add(new Label("Chat name:"), 0, 0);
            grid.add(chatNameInput, 1, 0);

            //Create the user selector field
            ListView<String> userListView = new ListView<>();
            userListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

            //Get the online users from the chat server
            ArrayList<String> onlineUsersArrayList = clientController.getOnlineUsers();
            ObservableList<String> onlineUsers = FXCollections.observableArrayList(onlineUsersArrayList);
            userListView.setItems(onlineUsers);
            grid.add(userListView, 0, 1);

            //Add the grid to the dialog
            dialog.getDialogPane().setContent(grid);

            //Set the button press events
            dialog.setResultConverter(dialogButton -> {
                if (dialogButton == submit) {
                    //Get the chatname and selected chat users
                    String chatName = chatNameInput.getText();
                    List<String> chatUsers = userListView.getSelectionModel().getSelectedItems();


                    //If the chat or chat users are empty, show popup
                    if (chatName.isEmpty() || chatUsers.isEmpty()) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error Dialog");
                        alert.setHeaderText("Incomplete information");
                        alert.setContentText("Make sure you have chosen a chat name and selected at least one user for the chat");
                        alert.showAndWait();
                    }

                    //if the submit button is pressed, return the parameters
                    else {
                        ArrayList<String> chatParameters = new ArrayList<>();
                        //Place the chat name on the first index
                        chatParameters.add(chatName);

                        //Place the chat users on the following parameters
                        chatParameters.addAll(chatUsers);

                        return chatParameters;
                    }
                }
                return null;
            });

            return dialog;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
