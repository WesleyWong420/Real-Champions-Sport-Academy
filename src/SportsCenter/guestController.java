package SportsCenter;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.util.ArrayList;

public class guestController {
    
    // Guest - Sports Tab
    @FXML
    public ImageView imgLogout, imgSport1Logo_SportsTab, imgSport2Logo_SportsTab, imgSport3Logo_SportsTab, imgSport4Logo_SportsTab, imgSport5Logo_SportsTab;
    @FXML
    public Button btnSport1Enroll_SportsTab, btnSport2Enroll_SportsTab, btnSport3Enroll_SportsTab, btnSport4Enroll_SportsTab, btnSport5Enroll_SportsTab;
    @FXML
    public Label lblSport1Name_SportsTab, lblSport1Duration_SportsTab, lblSport1Fee_SportsTab, lblSport1Coach_SportsTab; 
    @FXML
    public Label lblSport2Name_SportsTab, lblSport2Duration_SportsTab, lblSport2Fee_SportsTab, lblSport2Coach_SportsTab;
    @FXML
    public Label lblSport3Name_SportsTab, lblSport3Duration_SportsTab, lblSport3Fee_SportsTab, lblSport3Coach_SportsTab;
    @FXML
    public Label lblSport4Name_SportsTab, lblSport4Duration_SportsTab, lblSport4Fee_SportsTab, lblSport4Coach_SportsTab;
    @FXML
    public Label lblSport5Name_SportsTab, lblSport5Duration_SportsTab, lblSport5Fee_SportsTab, lblSport5Coach_SportsTab;
    
    // Guest - Schedule Tab
    @FXML
    public Label lblSport1Name_ScheduleTab, lblSport1Time_ScheduleTab, lblSport1Date_ScheduleTab, lblSport1Location_ScheduleTab, lblSport1Coach_ScheduleTab; 
    @FXML
    public Label lblSport2Name_ScheduleTab, lblSport2Time_ScheduleTab, lblSport2Date_ScheduleTab, lblSport2Location_ScheduleTab, lblSport2Coach_ScheduleTab; 
    @FXML
    public Label lblSport3Name_ScheduleTab, lblSport3Time_ScheduleTab, lblSport3Date_ScheduleTab, lblSport3Location_ScheduleTab, lblSport3Coach_ScheduleTab; 
    @FXML
    public Label lblSport4Name_ScheduleTab, lblSport4Time_ScheduleTab, lblSport4Date_ScheduleTab, lblSport4Location_ScheduleTab, lblSport4Coach_ScheduleTab; 
    @FXML
    public Label lblSport5Name_ScheduleTab, lblSport5Time_ScheduleTab, lblSport5Date_ScheduleTab, lblSport5Location_ScheduleTab, lblSport5Coach_ScheduleTab; 

    Guest guest = new Guest();
    ArrayList<Sport> arraySports = new ArrayList<>();
    ArrayList<Schedule> arraySchedule = new ArrayList<>();
    
    public void initialize(){
        arraySports = FileIO.readSportsFile("sport.txt");
        arraySchedule = FileIO.readScheduleFile("schedule.txt");
        
        groupSport(guest);
        groupSchedule(guest);
        
        //FileIO temp = new FileIO();
        //temp.addSport("sport.txt");
        //temp.addSchedule("schedule.txt");
        //temp.addFeedback("feedback.txt");
        //temp.addStudent("student.txt");
    }
    
    private void groupSport(Guest guest){
        
        ArrayList<ArrayList> control_list = new ArrayList<>(); // Outer ArrayList 
        ArrayList<Label> name = new ArrayList<>(); // Inner ArrayList 1
        name.add(lblSport1Name_SportsTab);
        name.add(lblSport2Name_SportsTab);
        name.add(lblSport3Name_SportsTab);
        name.add(lblSport4Name_SportsTab);
        name.add(lblSport5Name_SportsTab);
        ArrayList<Label> duration = new ArrayList<>(); // Inner ArrayList 2
        duration.add(lblSport1Duration_SportsTab);
        duration.add(lblSport2Duration_SportsTab);
        duration.add(lblSport3Duration_SportsTab);
        duration.add(lblSport4Duration_SportsTab);
        duration.add(lblSport5Duration_SportsTab);
        ArrayList<Label> fee = new ArrayList<>(); // Inner ArrayList 3
        fee.add(lblSport1Fee_SportsTab);
        fee.add(lblSport2Fee_SportsTab);
        fee.add(lblSport3Fee_SportsTab);
        fee.add(lblSport4Fee_SportsTab);
        fee.add(lblSport5Fee_SportsTab);
        ArrayList<Label> coach = new ArrayList<>(); // Inner ArrayList 4
        coach.add(lblSport1Coach_SportsTab);
        coach.add(lblSport2Coach_SportsTab);
        coach.add(lblSport3Coach_SportsTab);
        coach.add(lblSport4Coach_SportsTab);
        coach.add(lblSport5Coach_SportsTab);
        ArrayList<ImageView> img_list = new ArrayList<>(); // Inner ArrayList 5
        img_list.add(imgSport1Logo_SportsTab);
        img_list.add(imgSport2Logo_SportsTab);
        img_list.add(imgSport3Logo_SportsTab);
        img_list.add(imgSport4Logo_SportsTab);
        img_list.add(imgSport5Logo_SportsTab);
        control_list.add(name); 
        control_list.add(duration); 
        control_list.add(fee); 
        control_list.add(coach);
        control_list.add(img_list);

        guest.getSport(arraySports, control_list);
    }
    
    private void groupSchedule(Guest guest){

        ArrayList<ArrayList> control_list = new ArrayList<>(); // Outer ArrayList 
        ArrayList<Label> name = new ArrayList<>(); // Inner ArrayList 1
        name.add(lblSport1Name_ScheduleTab);
        name.add(lblSport2Name_ScheduleTab);
        name.add(lblSport3Name_ScheduleTab);
        name.add(lblSport4Name_ScheduleTab);
        name.add(lblSport5Name_ScheduleTab);
        ArrayList<Label> time = new ArrayList<>(); // Inner ArrayList 2
        time.add(lblSport1Time_ScheduleTab);
        time.add(lblSport2Time_ScheduleTab);
        time.add(lblSport3Time_ScheduleTab);
        time.add(lblSport4Time_ScheduleTab);
        time.add(lblSport5Time_ScheduleTab);
        ArrayList<Label> date = new ArrayList<>(); // Inner ArrayList 3
        date.add(lblSport1Date_ScheduleTab);
        date.add(lblSport2Date_ScheduleTab);
        date.add(lblSport3Date_ScheduleTab);
        date.add(lblSport4Date_ScheduleTab);
        date.add(lblSport5Date_ScheduleTab);
        ArrayList<Label> location = new ArrayList<>(); // Inner ArrayList 4
        location.add(lblSport1Location_ScheduleTab);
        location.add(lblSport2Location_ScheduleTab);
        location.add(lblSport3Location_ScheduleTab);
        location.add(lblSport4Location_ScheduleTab);
        location.add(lblSport5Location_ScheduleTab);
        ArrayList<Label> coach = new ArrayList<>(); // Inner ArrayList 5
        coach.add(lblSport1Coach_ScheduleTab);
        coach.add(lblSport2Coach_ScheduleTab);
        coach.add(lblSport3Coach_ScheduleTab);
        coach.add(lblSport4Coach_ScheduleTab);
        coach.add(lblSport5Coach_ScheduleTab);
        control_list.add(name); 
        control_list.add(time); 
        control_list.add(date); 
        control_list.add(location); 
        control_list.add(coach);

        guest.getSchedule(arraySchedule, control_list);
    }
    
    @FXML
    private void pressLogout() throws Exception { // Back to Home Page
        Parent root = FXMLLoader.load(getClass().getResource("welcome.fxml"));
        Stage window = (Stage) imgLogout.getScene().getWindow(); 
        window.setScene(new Scene(root, 800, 480));
        window.setTitle("Real Champions Sports Academy");
    }
    
    @FXML
    private void pressEnrollSport() throws Exception { // Cannot enroll in sports as Guest
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Access Denied");
        alert.setHeaderText("Permission Insufficient!");
        String msg = "Please login to enroll in a sport.";
        alert.setContentText(msg);
        alert.showAndWait(); 
    }
}