package SportsCenter;

import java.awt.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.scene.control.Dialog;


public class guestController {
    
    @FXML
    private ImageView imgLogout, imgSport1Logo, imgSport2Logo, imgSport3Logo, imgSport4Logo, imgSport5Logo;
    @FXML
    private Button btnSport1Enroll, btnSport2Enroll, btnSport3Enroll, btnSport4Enroll, btnSport5Enroll;
    @FXML
    private Label lblSport1Name, lblSport1Duration, lblSport1Fee, lblSport1Coach; 
    @FXML
    private Label lblSport2Name, lblSport2Duration, lblSport2Fee, lblSport2Coach;
    @FXML
    private Label lblSport3Name, lblSport3Duration, lblSport3Fee, lblSport3Coach;
    @FXML
    private Label lblSport4Name, lblSport4Duration, lblSport4Fee, lblSport4Coach;
    @FXML
    private Label lblSport5Name, lblSport5Duration, lblSport5Fee, lblSport5Coach;
    
    @FXML
    private Label lblSport1Name2, lblSport1Time, lblSport1Date, lblSport1Location, lblSport1Coach2; 
    @FXML
    private Label lblSport2Name2, lblSport2Time, lblSport2Date, lblSport2Location, lblSport2Coach2; 
    @FXML
    private Label lblSport3Name2, lblSport3Time, lblSport3Date, lblSport3Location, lblSport3Coach2; 
    @FXML
    private Label lblSport4Name2, lblSport4Time, lblSport4Date, lblSport4Location, lblSport4Coach2; 
    @FXML
    private Label lblSport5Name2, lblSport5Time, lblSport5Date, lblSport5Location, lblSport5Coach2; 

    public void initialize() {
    }
    
    @FXML
    private void pressLogout() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("welcome.fxml"));
        Stage window = (Stage) imgLogout.getScene().getWindow(); 
        window.setScene(new Scene(root, 800, 480));
        window.setTitle("Real Champions Sports Academy");
    }
    
    static void showDialog(Button button){
        Dialog<String> dialog = new Dialog<String>();
        dialog.setTitle("Error");
        ButtonType type = new ButtonType("Ok", ButtonData.OK_DONE);
        dialog.setContentText("Please login to enroll in a sport.");
        dialog.getDialogPane().getButtonTypes().add(type);
        button.setOnAction(e -> {
         dialog.showAndWait();
        });
    }
    
    @FXML
    private void pressEnrollSport1(javafx.event.ActionEvent event) throws Exception {
        showDialog(btnSport1Enroll);
    }
    
    @FXML
    private void pressEnrollSport2(javafx.event.ActionEvent event) throws Exception {
        showDialog(btnSport2Enroll);
    }
    
    @FXML
    private void pressEnrollSport3(javafx.event.ActionEvent event) throws Exception {
        showDialog(btnSport3Enroll);
    }
    
    @FXML
    private void pressEnrollSport4(javafx.event.ActionEvent event) throws Exception {
        showDialog(btnSport4Enroll);
    }
    
    @FXML
    private void pressEnrollSport5(javafx.event.ActionEvent event) throws Exception {
        showDialog(btnSport5Enroll);
    }
}