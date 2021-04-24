package SportsCenter;

import java.awt.event.ActionEvent;
import java.util.HashSet;
import java.util.Set;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;


public class guestController {
    
    // Guest - Sports Tab
    @FXML
    private ImageView imgLogout, imgSport1Logo_SportsTab, imgSport2Logo_SportsTab, imgSport3Logo_SportsTab, imgSport4Logo_SportsTab, imgSport5Logo_SportsTab;
    @FXML
    private Button btnSport1Enroll_SportsTab, btnSport2Enroll_SportsTab, btnSport3Enroll_SportsTab, btnSport4Enroll_SportsTab, btnSport5Enroll_SportsTab;
    @FXML
    private Label lblSport1Name_SportsTab, lblSport1Duration_SportsTab, lblSport1Fee_SportsTab, lblSport1Coach_SportsTab; 
    @FXML
    private Label lblSport2Name_SportsTab, lblSport2Duration_SportsTab, lblSport2Fee_SportsTab, lblSport2Coach_SportsTab;
    @FXML
    private Label lblSport3Name_SportsTab, lblSport3Duration_SportsTab, lblSport3Fee_SportsTab, lblSport3Coach_SportsTab;
    @FXML
    private Label lblSport4Name_SportsTab, lblSport4Duration_SportsTab, lblSport4Fee_SportsTab, lblSport4Coach_SportsTab;
    @FXML
    private Label lblSport5Name_SportsTab, lblSport5Duration_SportsTab, lblSport5Fee_SportsTab, lblSport5Coach_SportsTab;
    
    // Guest - Schedule Tab
    @FXML
    private Label lblSport1Name_ScheduleTab, lblSport1Time_ScheduleTab, lblSport1Date_ScheduleTab, lblSport1Location_ScheduleTab, lblSport1Coach_ScheduleTab; 
    @FXML
    private Label lblSport2Name_ScheduleTab, lblSport2Time_ScheduleTab, lblSport2Date_ScheduleTab, lblSport2Location_ScheduleTab, lblSport2Coach_ScheduleTab; 
    @FXML
    private Label lblSport3Name_ScheduleTab, lblSport3Time_ScheduleTab, lblSport3Date_ScheduleTab, lblSport3Location_ScheduleTab, lblSport3Coach_ScheduleTab; 
    @FXML
    private Label lblSport4Name_ScheduleTab, lblSport4Time_ScheduleTab, lblSport4Date_ScheduleTab, lblSport4Location_ScheduleTab, lblSport4Coach_ScheduleTab; 
    @FXML
    private Label lblSport5Name_ScheduleTab, lblSport5Time_ScheduleTab, lblSport5Date_ScheduleTab, lblSport5Location_ScheduleTab, lblSport5Coach_ScheduleTab; 

    public void initialize() {
    }
    
    @FXML
    private void pressLogout() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("welcome.fxml"));
        Stage window = (Stage) imgLogout.getScene().getWindow(); 
        window.setScene(new Scene(root, 800, 480));
        window.setTitle("Real Champions Sports Academy");
    }
    
    @FXML
    private void pressEnrollSport() throws Exception {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Access Denied!");
        String s = "Please login to enroll in a sport.";
        alert.setContentText(s);
        alert.showAndWait(); 
    }
}