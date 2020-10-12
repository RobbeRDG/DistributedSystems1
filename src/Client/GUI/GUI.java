package Client.GUI;

import Client.ChatRoomListener.ChatRoomListener;
import Client.ChatRoomListener.Listener;
import Server.ChatRoomServer.ChatRoomServer;
import Server.ChatRoomServer.Room;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class GUI extends Application {
    private ChatRoomListener chatRoomListener;
    private ChatController chatController;
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;

        //initialize a ChatListener
        chatRoomListener = new ChatRoomListener();

        //start the ChatRoomListener
        chatRoomListener.startListener();

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
        chatController = (ChatController)loader.getController();
        //Set the GUI Controller
        chatController.setGuiController(this);

        //Display the fxml file
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

        //pass the GUI controller to the Listener
        chatRoomListener.getListener().setGuiController(this);
    }

    public Room getChatRoom() {
        return chatRoomListener.getChatRoom();
    }

    public Listener getListener() {
        return chatRoomListener.getListener();
    }

    public void addMessage(String sender, String message) {
        chatController.addMessage(String sender, String message);
    }

    // main method to support non-JavaFX-aware environments:

    public static void main(String[] args) {
        // starts the FX toolkit, instantiates this class,
        // and calls start(...) on the FX Application thread:
        launch(args);
    }
}
