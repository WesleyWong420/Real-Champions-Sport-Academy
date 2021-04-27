package SportsCenter;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;

public class studentController {
    
    // Student - Sports Tab
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
    @FXML
    private VBox vboxSport1_SportsTab, vboxSport2_SportsTab, vboxSport3_SportsTab, vboxSport4_SportsTab, vboxSport5_SportsTab; // used to disable and lower opacity
    
    // Student - Schedule Tab
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
    @FXML
    private HBox hboxSport1_ScheduleTab, hboxSport2_ScheduleTab, hboxSport3_ScheduleTab, hboxSport4_ScheduleTab, hboxSport5_ScheduleTab; // used to disable and lower opacity
    
    // Student - History Tab
    @FXML
    private Label lblSport1Name_HistoryTab, lblSport1Date_HistoryTab, lblSport1Coach_HistoryTab, lblSport1Feedback_HistoryTab; 
    @FXML
    private Label lblSport2Name_HistoryTab, lblSport2Date_HistoryTab, lblSport2Coach_HistoryTab, lblSport2Feedback_HistoryTab; 
    @FXML
    private Label lblSport3Name_HistoryTab, lblSport3Date_HistoryTab, lblSport3Coach_HistoryTab, lblSport3Feedback_HistoryTab;  
    @FXML
    private Label lblSport4Name_HistoryTab, lblSport4Date_HistoryTab, lblSport4Coach_HistoryTab, lblSport4Feedback_HistoryTab;  
    @FXML
    private Label lblSport5Name_HistoryTab, lblSport5Date_HistoryTab, lblSport5Coach_HistoryTab, lblSport5Feedback_HistoryTab;  

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
    private void pressEnrollSport(javafx.event.ActionEvent event) throws Exception {
    }
    
    @FXML
    private void pressFeedback() throws Exception {
    }
    
    @FXML
    private void pressCoachName() throws Exception {
    }
}