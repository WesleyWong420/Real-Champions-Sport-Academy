package SportsCenter;

import java.awt.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.image.ImageView;

public class Login_Register_Controller {

    @FXML
    private Button btnHome, btnSchedule, btnSports, btnJoinUs, btnLogin;
    @FXML
    private Label lblSportsCenterName, lblTitle;
    @FXML
    private AnchorPane bgHomePage, bgHeader, bgBody;
    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField txtPassword;

    public void initialize() {
    }

    @FXML
    private void pressHome(javafx.event.ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        Stage window = (Stage) btnJoinUs.getScene().getWindow(); 
        window.setScene(new Scene(root));
    }

    @FXML
    private void pressSchedule(javafx.event.ActionEvent event) {
    }
    
    @FXML
    private void pressSports(javafx.event.ActionEvent event) {
    }
    
    @FXML
    private void pressJoinUs(javafx.event.ActionEvent event) { 
    }
}