package ClientSide.ClientController;

import ClientSide.ClientConnection.ClientConnection;
import ClientSide.GUI.Chat.ChatWindowController;
import ClientSide.GUI.Login.LoginController;
import Objects.Chat;
import Objects.ChatMessage;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
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
        //set the primary stage
        this.primaryStage = primaryStage;

        //initialize the subscriptions
        subscriptionIds = new ArrayList<>();

        //initialize the connection
        connection = new ClientConnection();
        //Pass the ClientMain to the connection for callbacks
        connection.setClientController(this);

        //connect to the chatRoom server
        connectToServer();

        //load the chat and login controller
        loadControllers();

        //show the login screen
        showLogin();
    }
    private void connectToServer() {
        try {
            connection.connectToServer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadControllers() {
        // load the login fxml
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../GUI/Login/login.fxml"));
            loginPane = loader.load();

            //load the controller and pass the chatRoom and listener
            loginController = (LoginController)loader.getController();

            //Set the GUI Controller
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
            //Set the GUI Controller
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
    public int addUser(String userName) {
        this.userName = userName;
        return connection.addUser(userName);
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
    public void sendMessage(String messageText, String tabId) {
        //Create the new message
        ChatMessage message = new ChatMessage(userName, messageText);
        connection.sendMessage(message, tabId);
    }

    @Override
    public void stop(){
        //if a user has been created, tell the server to delete that user
        try {
            connection.removeUser(userName);
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
