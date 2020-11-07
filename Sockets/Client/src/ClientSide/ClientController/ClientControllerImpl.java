package ClientSide.ClientController;

import ClientSide.ClientConnection.ClientConnection;
import Common.Objects.Chat;
import Common.Objects.ChatMessage;
import ClientSide.GUI.Chat.ChatWindowController;
import ClientSide.GUI.Login.LoginController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

public class ClientControllerImpl extends Application implements ClientController {
    private static final long serialVersionUID = 2L;

    private static ClientConnection connection;
    private static Stage primaryStage;
    private static ArrayList<UUID> subscriptionIds;
    private static LoginController loginController;
    private static ChatWindowController chatWindowController;
    private static Pane loginPane;
    private static Pane chatPane;
    private static String userName;


    //###############################################################################################################
    //      STARTUP
    //###############################################################################################################
    public static void main(String[] args) {
        // starts the FX toolkit, instantiates this class,
        // and calls start(...) on the FX Application thread:
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            //set the primary stage
            this.primaryStage = primaryStage;

            //initialize the subscriptions
            subscriptionIds = new ArrayList<>();

            //initialize the connection
            connection = new ClientConnection();
            //Pass the ClientMain to the connection for callbacks
            connection.setClientController(this);

            //connect to the chatRoom server
            connection.connectToServer();

            //load the chat and login controller
            loadControllers();

            //show the login screen
            showLogin();
        } catch (Exception e) {
            handleException(e);
        }

    }

    private void loadControllers() {
        // load the login fxml
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../GUI/Login/login.fxml"));
            loginPane = loader.load();

            //load the controller and pass the chatRoom and listener
            loginController = (LoginController)loader.getController();

            //Set the ClientSide.GUI Controller
            loginController.setGuiController(this);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // load the chat fxml
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../GUI/Chat/ChatWindow.fxml"));
            chatPane = loader.load();

            //load the controller and pass the chatRoom and listener
            chatWindowController = (ChatWindowController)loader.getController();
            //Set the ClientSide.GUI Controller
            chatWindowController.setGuiController(this);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showLogin() throws IOException {
        //Display the login fxml file
        Scene scene = new Scene(loginPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void showChat() throws IOException {
        //Display the chat fxml file
        Scene scene = new Scene(chatPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }





    @Override
    public void addUser(String userName) throws IllegalArgumentException {
        try {
            this.userName = userName;
            connection.addUser(userName);
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception e) {
            handleException(e);
        }
    }

    @Override
    public void chatUpdate(Chat chat) {
        try {
            if (subscriptionIds.contains(chat.getId())) { //if the chat is not new, update the existing tab
                chatWindowController.updateTab(chat.getId().toString(), chat);

                Platform.runLater(new Runnable(){
                    @Override
                    public void run() {
                        primaryStage.show();
                    }
                });

            } else { //if the chat is new, add a new tab to the tabPane
                chatWindowController.addTab(chat.getId().toString(), chat);

                Platform.runLater(new Runnable(){
                    @Override
                    public void run() {
                        primaryStage.show();
                    }
                });

                //Add the chat to the subscriptions
                subscriptionIds.add(chat.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public String getUser() {
        return userName;
    }

    @Override
    public void sendMessage(String messageText, String tabId) {
        try {
            //Create the new message
            ChatMessage message = new ChatMessage(userName, messageText);
            connection.sendMessage(message, tabId);
        } catch (Exception e) {
            handleException(e);
        }

    }

    @Override
    public void stop(){
        //if a user has been created, tell the server to delete that user
        try {
            connection.removeUser(userName);
        } catch (Exception e) {
            handleException(e);
        } finally {
            System.exit(0);
        }
    }

    @Override
    public ArrayList<String> getOnlineUsers() {
        try {
            ArrayList<String> onlineUsers = connection.getOnlineUsers();

            //Remove this user
            onlineUsers.remove(userName);

            return onlineUsers;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void createChat(String chatName, ArrayList<String> chatUsers) {
        try {
            connection.createChat(userName, chatName, chatUsers);
        } catch (Exception e) {
            handleException(e);
        }
    }

    private void handleException(Exception e) {
        //Print the exception in the console
        e.printStackTrace();

        //generate an error alert
        Alert alert = new Alert(Alert.AlertType.ERROR);

        alert.setTitle("Error Dialog");
        alert.setHeaderText("Something went wrong");
        alert.setContentText(e.getLocalizedMessage());

        alert.showAndWait();
    }
}
