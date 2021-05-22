package SportsCenter;

import javafx.scene.input.MouseEvent;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class coachController {
    
    @FXML
    public Button btnLogout, btnSave, btnEdit;
    @FXML
    public TextField txtCoachID, txtUsername, txtGender, txtEmail, txtMobileNo, txtAddress, txtSport, txtNextClass, txtRating, txthourlyRate;
    @FXML
    public Label lblCoachID, lblUsername, lblGender, lblEmail, lblMobileNo, lblAddress, lblSport, lblNextClass, lblRating, lblhourlyRate;
    
    Coach coach = new Coach("C003", "Caitlin", "Female", "0123456789", "caitlin@gmail.com", "Street 3", 5.0, 40);
    ArrayList<Sport> arraySports = new ArrayList<>();
    ArrayList<Schedule> arraySchedule = new ArrayList<>();
    
    public void initialize() {
        arraySports = FileIO.readSportsFile("sport.txt");
        arraySchedule = FileIO.readScheduleFile("schedule.txt");
        
        groupSport(coach);
        groupSchedule(coach);
        groupSelfRecord(coach);
    }
    
    private void groupSport(Coach coach){
        
        ArrayList<ArrayList> control_list = new ArrayList<>(); 
        ArrayList<TextField> txt_list = new ArrayList<>(); 
        txt_list.add(txtSport);
        control_list.add(txt_list);
        
        coach.getSport(arraySports, control_list);
    }
    
    private void groupSchedule(Coach coach){
        
        ArrayList<ArrayList> control_list = new ArrayList<>(); 
        ArrayList<TextField> txt_list = new ArrayList<>(); 
        txt_list.add(txtNextClass);
        control_list.add(txt_list);
        
        coach.getSchedule(arraySchedule, control_list);
    }
    
    private void groupSelfRecord(Coach coach){
        
        ArrayList<TextField> txt_list = new ArrayList<>(); 
        txt_list.add(txtCoachID);
        txt_list.add(txtUsername);
        txt_list.add(txtGender);
        txt_list.add(txtEmail);
        txt_list.add(txtMobileNo);
        txt_list.add(txtAddress);
        txt_list.add(txtRating);
        txt_list.add(txthourlyRate);
        
        coach.getSelfRecord(txt_list);
    }
    
    @FXML
    private void pressLogout() throws Exception { // Back to Home Page
        Parent root = FXMLLoader.load(getClass().getResource("welcome.fxml"));
        Stage window = (Stage) btnLogout.getScene().getWindow(); 
        window.setScene(new Scene(root, 800, 480));
        window.setTitle("Real Champions Sports Academy");
    }
    
    @FXML
    private void pressSave() throws Exception { // setSelfRecord()
        
        if(!txtIsEmpty())
        {
            if(txtMobileNo.getText().matches("[0-9]+")) // Mobile number validation
            {
                if(emailIsValid(txtEmail.getText())) // Email regular expression validation
                {
                    btnSave.setDisable(true);
                    btnEdit.setDisable(false);
                    txtCoachID.setDisable(true); // Just for visual, CoachID cannot be modified
                    txtGender.setDisable(true); // Just for visual, Gender cannot be modified
                    txtUsername.setDisable(true);
                    txtEmail.setDisable(true);
                    txtMobileNo.setDisable(true);
                    txtAddress.setDisable(true);
                    txtSport.setDisable(true); // Just for visual, Coach's Sport cannot be modified
                    txtNextClass.setDisable(true); // Just for visual, next class session cannot be modified
                    txtRating.setDisable(true); // Just for visual, Coach's Rating cannot be modified
                    txthourlyRate.setDisable(true); // Just for visual, Coach's Rating cannot be modified
        
                    coach.setUsername(txtUsername.getText());
                    coach.setEmail(txtEmail.getText());
                    coach.setContact(txtMobileNo.getText());
                    coach.setAddress(txtAddress.getText());
                    
                    //FileIO.writeCoach(coach, "coach.txt");
                    FileIO.pushNotification("Successful!", "Your profile details has been saved successfully.");
                }
                else
                {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Invalid Email Address!");
                    alert.setContentText("Please enter a valid email address.");
                    alert.showAndWait();
                }
            }
            else
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Invalid Mobile Number!");
                alert.setContentText("Please enter a valid mobile number.");
                alert.showAndWait();
            }
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Empty Fields!");
            alert.setContentText("One or more details is incomplete");
            alert.showAndWait();
        }
    }
    
    @FXML
    private void pressEdit() throws Exception {
        btnEdit.setDisable(true);
        btnSave.setDisable(false);
        txtCoachID.setDisable(false); // Just for visual, CoachID cannot be modified
        txtGender.setDisable(false); // Just for visual, Gender cannot be modified
        txtUsername.setDisable(false);
        txtEmail.setDisable(false);
        txtMobileNo.setDisable(false);
        txtAddress.setDisable(false);
        txtSport.setDisable(false); // Just for visual, Coach's Sport cannot be modified
        txtNextClass.setDisable(false); // Just for visual, next class session cannot be modified
        txtRating.setDisable(false); // Just for visual, Coach's Rating cannot be modified
        txthourlyRate.setDisable(false); // Just for visual, Coach's Rating cannot be modified
    }
    
    @FXML
    private void getFocus(MouseEvent event) throws Exception{ // Text Field Get Focus
        ArrayList<TextField> txt_list = new ArrayList<>();
        txt_list.add(txtCoachID);
        txt_list.add(txtUsername);
        txt_list.add(txtGender);
        txt_list.add(txtEmail);
        txt_list.add(txtMobileNo);
        txt_list.add(txtAddress);
        txt_list.add(txtSport);
        txt_list.add(txtNextClass);
        txt_list.add(txtRating);
        txt_list.add(txthourlyRate);
        ArrayList<Label> lbl_list = new ArrayList<>();
        lbl_list.add(lblCoachID);
        lbl_list.add(lblUsername);
        lbl_list.add(lblGender);
        lbl_list.add(lblEmail);
        lbl_list.add(lblMobileNo);
        lbl_list.add(lblAddress);
        lbl_list.add(lblSport);
        lbl_list.add(lblNextClass);
        lbl_list.add(lblRating);
        lbl_list.add(lblhourlyRate);
        
        TextField txt = (TextField) event.getSource(); // Type Casting
        int index = txt_list.indexOf(txt); // Search for the TextField's index 
        lbl_list.get(index).setVisible(true); // Using the index number to access respective Label to float
    }
    
    @FXML
    private void loseFocus(MouseEvent event) throws Exception{ // Text Field Lose Focus
        ArrayList<TextField> txt_list = new ArrayList<>();
        txt_list.add(txtCoachID);
        txt_list.add(txtUsername);
        txt_list.add(txtGender);
        txt_list.add(txtEmail);
        txt_list.add(txtMobileNo);
        txt_list.add(txtAddress);
        txt_list.add(txtSport);
        txt_list.add(txtNextClass);
        txt_list.add(txtRating);
        txt_list.add(txthourlyRate);
        ArrayList<Label> lbl_list = new ArrayList<>();
        lbl_list.add(lblCoachID);
        lbl_list.add(lblUsername);
        lbl_list.add(lblGender);
        lbl_list.add(lblEmail);
        lbl_list.add(lblMobileNo);
        lbl_list.add(lblAddress);
        lbl_list.add(lblSport);
        lbl_list.add(lblNextClass);
        lbl_list.add(lblRating);
        lbl_list.add(lblhourlyRate);
        
        TextField txt = (TextField) event.getSource();  // Type Casting
        int index = txt_list.indexOf(txt); // Search for the TextField's index 
        if(txt.getText().isEmpty()) 
        {
            lbl_list.get(index).setVisible(false); // Using the index number to access respective Label to unfloat
        }
        else
        {
            lbl_list.get(index).setVisible(true); // Using the index number to access respective Label to float
        }
        btnLogout.requestFocus(); // Transfer focus to other control
    }
    
    private boolean emailIsValid(String email) {
      String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
      return email.matches(regex);
   }
    
    private boolean txtIsEmpty(){
        
        ArrayList<TextField> txt_list = new ArrayList<>(); 
        txt_list.add(txtUsername);
        txt_list.add(txtEmail);
        txt_list.add(txtMobileNo);
        txt_list.add(txtAddress);
        
        boolean empty = false;
        for(TextField txt : txt_list)
        {
            if(txt.getText().equals(""))
            {
                empty = true;
            }
        }
        
        return empty;
   }
}
