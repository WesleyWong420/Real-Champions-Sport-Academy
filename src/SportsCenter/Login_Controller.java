package SportsCenter;

import java.awt.event.ActionEvent;
import java.io.IOException;
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
import javafx.scene.input.MouseEvent;

public class Login_Controller {

    @FXML
    private Button btnLogin, btnForgotPassword, btnRegister;
    @FXML
    private Label lblTitle, lblNoAccount;
    @FXML
    private AnchorPane bgHomePage, bgLeft, bgRight;
    @FXML
    private ImageView imgLogo, imgHome, imgSchedule, imgSports;
    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField txtPassword;

    public void initialize() {
    }

    @FXML
    private void pressHome() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Stage window = (Stage) imgHome.getScene().getWindow(); 
        window.setScene(new Scene(root, 900, 700)); 
        window.setTitle("Home Page");
    }
    
    @FXML
    private void pressSchedule(javafx.event.ActionEvent event) {
    }
    
    @FXML
    private void pressSports(javafx.event.ActionEvent event) {
    }
    
    @FXML
    private void pressRegister(javafx.event.ActionEvent event) {
    }
    
    @FXML
    private void pressLogin(javafx.event.ActionEvent event) {
    }
    
    @FXML
    private void pressForgotPassword(javafx.event.ActionEvent event) {
    }
}