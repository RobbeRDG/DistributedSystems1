package ClientSide.GUI;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

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
        int statusCode = guiController.addUser(userName);

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