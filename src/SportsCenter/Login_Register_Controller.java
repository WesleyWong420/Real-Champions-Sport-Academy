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

public class Login_Register_Controller {

    @FXML
    private Button btnLogin;
    @FXML
    private Label lblTitle;
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
        Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        Stage window = (Stage) imgHome.getScene().getWindow(); 
        window.setScene(new Scene(root, 900, 700)); 
        window.setTitle("Home Page");
    }
}