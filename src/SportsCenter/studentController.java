package SportsCenter;

import java.awt.event.ActionEvent;
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
    private VBox vboxSport1, vboxSport2, vboxSport3, vboxSport4, vboxSport5; // used to disable and lower opacity
    
    // Student - Schedule Tab
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
    @FXML
    private HBox hboxSport1, hboxSport2, hboxSport3, hboxSport4, hboxSport5; // used to disable and lower opacity

    public void initialize() {
    }
    
    @FXML
    private void pressLogout() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("welcome.fxml"));
        Stage window = (Stage) imgLogout.getScene().getWindow(); 
        window.setScene(new Scene(root, 800, 480));
        window.setTitle("Real Champions Sports Academy");
    }
}