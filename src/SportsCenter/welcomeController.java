package SportsCenter;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class welcomeController {
    
    @FXML
    private Button btnGuest, btnLogin;
    @FXML
    private Label loginstatus;
    @FXML
    private TextField userTxt,passTxt;

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
        if ((userTxt.getText() != null)&& (passTxt.getText()!= null)){
            login tempLogin = new login(userTxt.getText(),passTxt.getText());
            Boolean success = tempLogin.validate(userTxt.getText(), passTxt.getText());
            if (success){
                System.out.println(success);
                Parent root = FXMLLoader.load(getClass().getResource("admin.fxml"));
                Stage window = (Stage) btnLogin.getScene().getWindow(); 
                window.setScene(new Scene(root, 800, 480));
                window.setTitle("Admin Dashboard");
            }else{
                loginstatus.setText("*Incorrect Login Details!");
                userTxt.clear();
                passTxt.clear();
            }
        }else{
            System.out.println("login nulll");
        }
    }
    
    @FXML
    private void pressTemp(javafx.event.ActionEvent event) throws Exception { // ** Remove later - For Testing **
        Parent root = FXMLLoader.load(getClass().getResource("coach.fxml"));
        Stage window = (Stage) btnLogin.getScene().getWindow(); 
        window.setScene(new Scene(root, 800, 500));
        window.setTitle("Coach Dashboard");
    }
}
