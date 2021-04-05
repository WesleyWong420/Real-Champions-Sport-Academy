package SportsCenter;

import java.awt.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.image.ImageView;

public class HomePage_Controller {

    @FXML
    private Button btnHome, btnSchedule, btnSports, btnJoinUs;
    @FXML
    private Label lblTitle;
    @FXML
    private AnchorPane bgHomePage, bgHeader, bgBody;
    @FXML
    private ImageView imgLogo, imgBodyBackground;

    public void initialize() {
    }

    @FXML
    private void pressHome(javafx.event.ActionEvent event) {
    }

    @FXML
    private void pressSchedule(javafx.event.ActionEvent event) {
    }
    
    @FXML
    private void pressSports(javafx.event.ActionEvent event) {
    }
    
    @FXML
    private void pressJoinUs(javafx.event.ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Login_Register.fxml"));
        Stage window = (Stage) btnJoinUs.getScene().getWindow(); 
        window.setScene(new Scene(root, 900, 700));
        window.setTitle("Login Page");
    }
}