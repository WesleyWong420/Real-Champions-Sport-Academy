package SportsCenter;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class welcomeController {
    
    @FXML
    private Button btnGuest, btnLogin;
    @FXML
    private Label loginstatus;

    public void initialize() {
    }
    
    @FXML
    private void pressGuest(javafx.event.ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("guest.fxml"));
        Stage window = (Stage) btnGuest.getScene().getWindow(); 
        window.setScene(new Scene(root, 800, 500));
        window.setTitle("Guest Dashboard");
    }

    @FXML
    private void pressLogin(javafx.event.ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("student.fxml"));
        Stage window = (Stage) btnLogin.getScene().getWindow(); 
        window.setScene(new Scene(root, 800, 500));
        window.setTitle("Student Dashboard");
    }
    
    @FXML
    private void pressTemp(javafx.event.ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("coach.fxml"));
        Stage window = (Stage) btnLogin.getScene().getWindow(); 
        window.setScene(new Scene(root, 800, 500));
        window.setTitle("Coach Dashboard");
    }
}
