package ClientSide.GUI;

import ClientSide.Connection.Connection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GUI extends Application {
    private Connection connection;
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;

        //initialize the connection
        connection = new Connection();

        //connect to the chatRoom server
        connectToChatRoom();

        //show the login screen
        showLogin();
    }
    public void connectToChatRoom() {
        try {
            connection.connectToChatRoom();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void showLogin() throws IOException {
        // load the login fxml
        FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
        Parent root = loader.load();

        //load the controller and pass the chatRoom and listener
        LoginController controller = (LoginController)loader.getController();
        //Set the GUI Controller
        controller.setGuiController(this);

        //Display the fxml file
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void showChat() throws IOException {
        // load the chat fxml
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Chat.fxml"));
        Parent root = loader.load();

        //load the controller and pass the chatRoom and listener
        ChatController chatController = (ChatController)loader.getController();
        //Set the GUI Controller
        chatController.setGuiController(this);

        //Display the fxml file
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public void broadcastMessage(String sender, String message) {
        connection.addMessage(String sender, String message);
    }

    // main method to support non-JavaFX-aware environments:

    public static void main(String[] args) {
        // starts the FX toolkit, instantiates this class,
        // and calls start(...) on the FX Application thread:
        launch(args);
    }

    public int addUser(String userName) {
        return connection.addUser(userName);
    }
}
