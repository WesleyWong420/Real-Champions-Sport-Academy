package SportsCenter;

import java.awt.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class welcomeController {
    
    @FXML
    private Button btnGuest;

    public void initialize() {
    }
    
    @FXML
    private void pressGuest(javafx.event.ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("guest.fxml"));
        Stage window = (Stage) btnGuest.getScene().getWindow(); 
        window.setScene(new Scene(root, 800, 500));
        window.setTitle("Guest Dashboard");
    }
}