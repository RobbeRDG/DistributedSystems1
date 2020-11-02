package ClientSide.GUI.Login;

import ClientSide.ClientController.ClientController;
import ClientSide.ClientController.ClientControllerImpl;
import Objects.ServerLogicException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.io.Serializable;

public class LoginController {
    private ClientController clientController;

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
        try {
            clientController.addUser(userName);
            clientController.showChat();
        } catch (ServerLogicException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Name is already taken");
            alert.show();
            return;
        } catch (Exception e) {
            return;
        }
    }


    public void setGuiController(ClientController clientController) {
        this.clientController = clientController;
    }
}