package Client.GUI;

import Client.ChatRoomListener.Listener;
import Server.ChatRoomServer.Room;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.awt.*;
import java.io.IOException;
import java.rmi.RemoteException;

public class LoginController {
    private GUI guiController;

    @FXML
    TextField nameField;

    @FXML
    Button submitButton;

    @FXML
    public void handleSubmitButton(javafx.event.ActionEvent actionEvent) throws IOException {
        String userName = nameField.getText();

        //if the text input is empty, show a warning
        if(userName.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please write a user name");
            alert.show();
            return;
        }

        //test if the username is still available
        int statusCode = guiController.getChatRoom().addUser(userName, guiController.getListener());

        if (statusCode != 200) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Name is already taken");
            alert.show();
            return;
        } else {
            guiController.showChat();
        }
    }


    public void setGuiController(GUI guiController) {
        this.guiController = guiController;
    }
}