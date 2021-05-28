package SportsCenter;

import java.io.IOException;
import java.util.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.input.MouseEvent;

public class studentController {
    
    // Student - Sports Tab
    @FXML
    public ImageView imgSport1Logo_SportsTab, imgSport2Logo_SportsTab, imgSport3Logo_SportsTab, imgSport4Logo_SportsTab, imgSport5Logo_SportsTab;
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
    @FXML
    public VBox vboxSport1_SportsTab, vboxSport2_SportsTab, vboxSport3_SportsTab, vboxSport4_SportsTab, vboxSport5_SportsTab; // used to disable and lower opacity
    @FXML
    public Tooltip tooltipCoach1_SportsTab, tooltipCoach2_SportsTab, tooltipCoach3_SportsTab, tooltipCoach4_SportsTab, tooltipCoach5_SportsTab;
    
    // Student - Schedule Tab
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
    @FXML
    public HBox hboxSport1_ScheduleTab, hboxSport2_ScheduleTab, hboxSport3_ScheduleTab, hboxSport4_ScheduleTab, hboxSport5_ScheduleTab; // used to disable and lower opacity
    @FXML
    public Tooltip tooltipCoach1_ScheduleTab, tooltipCoach2_ScheduleTab, tooltipCoach3_ScheduleTab, tooltipCoach4_ScheduleTab, tooltipCoach5_ScheduleTab;
    
    // Student - History Tab
    @FXML
    public Label lblSport1Name_HistoryTab, lblSport1Date_HistoryTab, lblSport1Coach_HistoryTab, lblSport1Feedback_HistoryTab; 
    @FXML
    public Label lblSport2Name_HistoryTab, lblSport2Date_HistoryTab, lblSport2Coach_HistoryTab, lblSport2Feedback_HistoryTab; 
    @FXML
    public Label lblSport3Name_HistoryTab, lblSport3Date_HistoryTab, lblSport3Coach_HistoryTab, lblSport3Feedback_HistoryTab;  
    @FXML
    public Label lblSport4Name_HistoryTab, lblSport4Date_HistoryTab, lblSport4Coach_HistoryTab, lblSport4Feedback_HistoryTab;  
    @FXML
    public Label lblSport5Name_HistoryTab, lblSport5Date_HistoryTab, lblSport5Coach_HistoryTab, lblSport5Feedback_HistoryTab;  
    @FXML
    public Tooltip tooltipCoach1_HistoryTab, tooltipCoach2_HistoryTab, tooltipCoach3_HistoryTab, tooltipCoach4_HistoryTab, tooltipCoach5_HistoryTab;

    // Student - Account Tab
    @FXML
    public Button btnLogout, btnSave, btnEdit;
    @FXML
    public TextField txtUserID, txtUsername, txtGender, txtEmail, txtMobileNo, txtAddress, txtSport;
    @FXML
    public Label lblUserID, lblUsername, lblGender, lblEmail, lblMobileNo, lblAddress, lblSport;
    
    ArrayList<Sport> arraySports = new ArrayList<>();
    ArrayList<Schedule> arraySchedule = new ArrayList<>();
    ArrayList<Student> arrayStudent = FileIO.readStudentFile("student.txt");
    Student student;
    
    public void initialize(){
        student = arrayStudent.get(welcomeController.index);
        
        arraySports = FileIO.readSportsFile("sport.txt");
        arraySchedule = FileIO.readScheduleFile("schedule.txt");
        
        groupSport(student);
        groupSchedule(student);
        groupSelfRecord(student);
        groupHistory(student);
    }
    
    private void groupSport(Student student){
        
        ArrayList<ArrayList> control_list = new ArrayList<>(); // Outer ArrayList to hold ArrayList of different Controls
        ArrayList<Label> name = new ArrayList<>(); // Inner ArrayList 1 - Label
        name.add(lblSport1Name_SportsTab);
        name.add(lblSport2Name_SportsTab);
        name.add(lblSport3Name_SportsTab);
        name.add(lblSport4Name_SportsTab);
        name.add(lblSport5Name_SportsTab);
        ArrayList<Label> duration = new ArrayList<>(); // Inner ArrayList 2 - Label
        duration.add(lblSport1Duration_SportsTab);
        duration.add(lblSport2Duration_SportsTab);
        duration.add(lblSport3Duration_SportsTab);
        duration.add(lblSport4Duration_SportsTab);
        duration.add(lblSport5Duration_SportsTab);
        ArrayList<Label> fee = new ArrayList<>(); // Inner ArrayList 3 - Label
        fee.add(lblSport1Fee_SportsTab);
        fee.add(lblSport2Fee_SportsTab);
        fee.add(lblSport3Fee_SportsTab);
        fee.add(lblSport4Fee_SportsTab);
        fee.add(lblSport5Fee_SportsTab);
        ArrayList<Label> coach = new ArrayList<>(); // Inner ArrayList 4 - Label
        coach.add(lblSport1Coach_SportsTab);
        coach.add(lblSport2Coach_SportsTab);
        coach.add(lblSport3Coach_SportsTab);
        coach.add(lblSport4Coach_SportsTab);
        coach.add(lblSport5Coach_SportsTab);
        ArrayList<ImageView> img_list = new ArrayList<>(); // Inner ArrayList 5 - ImageView
        img_list.add(imgSport1Logo_SportsTab);
        img_list.add(imgSport2Logo_SportsTab);
        img_list.add(imgSport3Logo_SportsTab);
        img_list.add(imgSport4Logo_SportsTab);
        img_list.add(imgSport5Logo_SportsTab);
        ArrayList<Button> btn_list = new ArrayList<>(); // Inner ArrayList 6 - Button
        btn_list.add(btnSport1Enroll_SportsTab);
        btn_list.add(btnSport2Enroll_SportsTab);
        btn_list.add(btnSport3Enroll_SportsTab);
        btn_list.add(btnSport4Enroll_SportsTab);
        btn_list.add(btnSport5Enroll_SportsTab);
        ArrayList<VBox> vbox_list = new ArrayList<>(); // Inner ArrayList 7 - VBox (Control Opacity)
        vbox_list.add(vboxSport1_SportsTab);
        vbox_list.add(vboxSport2_SportsTab);
        vbox_list.add(vboxSport3_SportsTab);
        vbox_list.add(vboxSport4_SportsTab);
        vbox_list.add(vboxSport5_SportsTab);
        control_list.add(name); 
        control_list.add(duration); 
        control_list.add(fee); 
        control_list.add(coach);
        control_list.add(img_list);
        control_list.add(btn_list);
        control_list.add(vbox_list);

        ArrayList<Tooltip> tooltip_list = new ArrayList<>(); // Tooltip - Display Coach Rating from Student View
        tooltip_list.add(tooltipCoach1_SportsTab);
        tooltip_list.add(tooltipCoach2_SportsTab);
        tooltip_list.add(tooltipCoach3_SportsTab);
        tooltip_list.add(tooltipCoach4_SportsTab);
        tooltip_list.add(tooltipCoach5_SportsTab);

        student.getSport(arraySports, control_list);
        student.getCoach(arraySports, tooltip_list);
    }
    
    private void groupSchedule(Student student){

        ArrayList<ArrayList> control_list = new ArrayList<>(); // Outer ArrayList to hold ArrayList of different Controls
        ArrayList<Label> name = new ArrayList<>(); // Inner ArrayList 1 - Label
        name.add(lblSport1Name_ScheduleTab);
        name.add(lblSport2Name_ScheduleTab);
        name.add(lblSport3Name_ScheduleTab);
        name.add(lblSport4Name_ScheduleTab);
        name.add(lblSport5Name_ScheduleTab);
        ArrayList<Label> time = new ArrayList<>(); // Inner ArrayList 2 - Label
        time.add(lblSport1Time_ScheduleTab);
        time.add(lblSport2Time_ScheduleTab);
        time.add(lblSport3Time_ScheduleTab);
        time.add(lblSport4Time_ScheduleTab);
        time.add(lblSport5Time_ScheduleTab);
        ArrayList<Label> date = new ArrayList<>(); // Inner ArrayList 3 - Label
        date.add(lblSport1Date_ScheduleTab);
        date.add(lblSport2Date_ScheduleTab);
        date.add(lblSport3Date_ScheduleTab);
        date.add(lblSport4Date_ScheduleTab);
        date.add(lblSport5Date_ScheduleTab);
        ArrayList<Label> location = new ArrayList<>(); // Inner ArrayList 4 - Label
        location.add(lblSport1Location_ScheduleTab);
        location.add(lblSport2Location_ScheduleTab);
        location.add(lblSport3Location_ScheduleTab);
        location.add(lblSport4Location_ScheduleTab);
        location.add(lblSport5Location_ScheduleTab);
        ArrayList<Label> coach = new ArrayList<>(); // Inner ArrayList 5 - Label
        coach.add(lblSport1Coach_ScheduleTab);
        coach.add(lblSport2Coach_ScheduleTab);
        coach.add(lblSport3Coach_ScheduleTab);
        coach.add(lblSport4Coach_ScheduleTab);
        coach.add(lblSport5Coach_ScheduleTab);
        ArrayList<HBox> hbox_list = new ArrayList<>(); // Inner ArrayList 6 - HBox (Control Opacity)
        hbox_list.add(hboxSport1_ScheduleTab);
        hbox_list.add(hboxSport2_ScheduleTab);
        hbox_list.add(hboxSport3_ScheduleTab);
        hbox_list.add(hboxSport4_ScheduleTab);
        hbox_list.add(hboxSport5_ScheduleTab);
        ArrayList<Tooltip> tooltip_list = new ArrayList<>(); // Inner ArrayList 7 - Tooltip (Display Coach Rating from Student View)
        tooltip_list.add(tooltipCoach1_ScheduleTab);
        tooltip_list.add(tooltipCoach2_ScheduleTab);
        tooltip_list.add(tooltipCoach3_ScheduleTab);
        tooltip_list.add(tooltipCoach4_ScheduleTab);
        tooltip_list.add(tooltipCoach5_ScheduleTab);
        control_list.add(name); 
        control_list.add(time); 
        control_list.add(date); 
        control_list.add(location); 
        control_list.add(coach);
        control_list.add(hbox_list);
        control_list.add(tooltip_list);
        
        student.getSchedule(arraySchedule, control_list);
    }
    
    private void groupSelfRecord(Student student){
        
        ArrayList<TextField> txt_list = new ArrayList<>(); 
        txt_list.add(txtUserID);
        txt_list.add(txtUsername);
        txt_list.add(txtGender);
        txt_list.add(txtEmail);
        txt_list.add(txtMobileNo);
        txt_list.add(txtAddress);
        txt_list.add(txtSport);
        
        student.getSelfRecord(txt_list);
    }
    
    private void groupHistory(Student student){

        ArrayList<ArrayList> control_list = new ArrayList<>(); // Outer ArrayList to hold ArrayList of different Controls
        ArrayList<Label> name = new ArrayList<>(); // Inner ArrayList 1 - Label
        name.add(lblSport1Name_HistoryTab);
        name.add(lblSport2Name_HistoryTab);
        name.add(lblSport3Name_HistoryTab);
        name.add(lblSport4Name_HistoryTab);
        name.add(lblSport5Name_HistoryTab);
        ArrayList<Label> date = new ArrayList<>(); // Inner ArrayList 2 - Label
        date.add(lblSport1Date_HistoryTab);
        date.add(lblSport2Date_HistoryTab);
        date.add(lblSport3Date_HistoryTab);
        date.add(lblSport4Date_HistoryTab);
        date.add(lblSport5Date_HistoryTab);
        ArrayList<Label> coach = new ArrayList<>();  // Inner ArrayList 3 - Label
        coach.add(lblSport1Coach_HistoryTab);
        coach.add(lblSport2Coach_HistoryTab);
        coach.add(lblSport3Coach_HistoryTab);
        coach.add(lblSport4Coach_HistoryTab);
        coach.add(lblSport5Coach_HistoryTab);
        ArrayList<Label> feedback = new ArrayList<>(); // Inner ArrayList 4 - Label
        feedback.add(lblSport1Feedback_HistoryTab);
        feedback.add(lblSport2Feedback_HistoryTab);
        feedback.add(lblSport3Feedback_HistoryTab);
        feedback.add(lblSport4Feedback_HistoryTab);
        feedback.add(lblSport5Feedback_HistoryTab);
        ArrayList<Tooltip> tooltip_list = new ArrayList<>(); // Inner ArrayList 5 - Tooltip (Display Coach Rating from Student View)
        tooltip_list.add(tooltipCoach1_HistoryTab);
        tooltip_list.add(tooltipCoach2_HistoryTab);
        tooltip_list.add(tooltipCoach3_HistoryTab);
        tooltip_list.add(tooltipCoach4_HistoryTab);
        tooltip_list.add(tooltipCoach5_HistoryTab);
        control_list.add(name); 
        control_list.add(date);  
        control_list.add(coach);
        control_list.add(feedback);
        control_list.add(tooltip_list);
        
        ArrayList<Feedback> arrayFeedback = FileIO.readFeedbackFile("feedback.txt");
        student.getHistory(arraySchedule, arrayFeedback, control_list);
    }
    
    @FXML
    private void pressLogout() throws Exception { // Back to Home Page
        Parent root = FXMLLoader.load(getClass().getResource("welcome.fxml"));
        Stage window = (Stage) btnLogout.getScene().getWindow(); 
        window.setScene(new Scene(root, 800, 480));
        window.setTitle("Real Champions Sports Academy");
    }
    
    @FXML
    private void pressEnrollSport(javafx.event.ActionEvent event) throws Exception {
        
        Button btn_pressed;
        btn_pressed = (Button) event.getSource(); // To know which 1 out of 5 button is clicked
                
        ArrayList<Button> btn_list = new ArrayList<>(); // Grouping all Buttons
        btn_list.add(btnSport1Enroll_SportsTab);
        btn_list.add(btnSport2Enroll_SportsTab);
        btn_list.add(btnSport3Enroll_SportsTab);
        btn_list.add(btnSport4Enroll_SportsTab);
        btn_list.add(btnSport5Enroll_SportsTab);
        int btn_index = btn_list.indexOf(btn_pressed); // Index of which the button is pressed
        Sport sport_to_enroll = arraySports.get(btn_index); // We use the index to determine the Sport that student wish to enroll
        
        student.enrollSport(sport_to_enroll);
        
        groupSport(student); // refresh the sport page
        groupSchedule(student); // refresh the schedule page
        groupSelfRecord(student); // refresh the profile page
        
        for (Student sdt: arrayStudent) // overwrite the student
        {
            if(student.getUserID().equals(sdt.getUserID()))
            {
                sdt = student;
                break;
            }
        }
        FileIO.writeStudent(arrayStudent, "student.txt"); // then write to file
        FileIO.pushNotification("Successful!", "You have been enrolled in a sport.");
    }
    
    @FXML
    private void pressFeedback(MouseEvent event) throws IOException {
        
        Label lbl;
        lbl = (Label) event.getSource(); // To know which 1 out of 5 label is clicked

        ArrayList<Label> lbl_list = new ArrayList<>();
        lbl_list.add(lblSport1Feedback_HistoryTab);
        lbl_list.add(lblSport2Feedback_HistoryTab);
        lbl_list.add(lblSport3Feedback_HistoryTab);
        lbl_list.add(lblSport4Feedback_HistoryTab);
        lbl_list.add(lblSport5Feedback_HistoryTab);
        
        arraySports = FileIO.readSportsFile("sport.txt");
        int index = lbl_list.indexOf(lbl); // Index of which the label is pressed
        
        int sport_index = -1; // Value = -1 by default, since if a student is not enrolled in any Sport, Sport = null, and the returning index would be -1
        if(student.getSportObject() != null)
        {
            for(Sport sprt: arraySports)
            {
                if(sprt.getSportID().equals(student.getSportObject().getSportID()))
                {
                    sport_index = arraySports.indexOf(sprt); // Index of sport which the student is current enrolled in
                    break;
                }
            }
        }
        
        ArrayList<String> feedback_id_list = student.getLastFiveFeedbackID();
        if(index == sport_index || !feedback_id_list.get(index).equals("")) // Condition 1: Student can only submit feedback to Sport they are current enrolled in
        {                                                                   // Condition 2: Student can also view previouly submitted feedback
            student.submitFeedback(index);
            Stage stage = (Stage) btnLogout.getScene().getWindow();
            stage.close(); 
        }
        else // Neither one condition is satisfied
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Access Denied");
            alert.setHeaderText("Permission Insufficient!");
            String msg = "You can only submit feedback to sport classes/coaches that you have enrolled in OR view submitted feedback.";
            alert.setContentText(msg);
            alert.showAndWait(); 
        }
    }
    
    @FXML
    private void pressSave() throws Exception { // equivalent to setSelfRecord()
        
        if(!txtIsEmpty()) // Check if all the text fields are filled
        {
            if(txtMobileNo.getText().matches("[0-9]+")) // Mobile number validation
            {
                if(emailIsValid(txtEmail.getText())) // Email regular expression validation
                {
                    btnSave.setDisable(true);
                    btnEdit.setDisable(false);
                    txtUserID.setDisable(true); // Just for visual, UserID cannot be modified
                    txtGender.setDisable(true); // Just for visual, Gender cannot be modified
                    txtUsername.setDisable(true);
                    txtEmail.setDisable(true);
                    txtMobileNo.setDisable(true);
                    txtAddress.setDisable(true);
                    txtSport.setDisable(true);

                    student.setUsername(txtUsername.getText());
                    student.setEmail(txtEmail.getText());
                    student.setContact(txtMobileNo.getText());
                    student.setAddress(txtAddress.getText());
                    
                    for(Sport sport : arraySports)
                    {
                        String sportID_Name = sport.getSportID() + ": " + sport.getSportName();
                        if(sportID_Name.equals(txtSport.getText())) // Search and found
                        {
                            student.setSportObject(sport);
                            break;
                        }
                        else
                        {   
                            student.setSportObject(null); // Sports not found meaning unenrollment because it is "Withdraw" in TextBox
                        }
                    }

                    groupSport(student); // refresh the Sport page
                    groupSchedule(student); // refresh the Schedule page
                    
                    for (Student sdt: arrayStudent) // overwrite the Student
                    {
                        if(student.getUserID().equals(sdt.getUserID()))
                        {
                            sdt = student;
                            break;
                        }
                    }
                    FileIO.writeStudent(arrayStudent, "student.txt"); // then write to file
                    FileIO.pushNotification("Successful!", "Your profile details has been saved successfully.");
                }
                else
                {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Invalid Email Address!");
                    alert.setContentText("Please enter a valid email address.");
                    alert.showAndWait();
                }
            }
            else
            {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Invalid Mobile Number!");
                alert.setContentText("Please enter a valid mobile number.");
                alert.showAndWait();
            }
        }
        else
        {
            Alert alert = new Alert(AlertType.ERROR);
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
        txtUserID.setDisable(false); // Just for visual, UserID cannot be modified
        txtGender.setDisable(false); // Just for visual, Gender cannot be modified
        txtUsername.setDisable(false);
        txtEmail.setDisable(false);
        txtMobileNo.setDisable(false);
        txtAddress.setDisable(false);
        txtSport.setDisable(false);
    }
    
    @FXML
    private void getFocus(MouseEvent event) throws Exception{ // Account Tab - Text Field Get Focus
        ArrayList<TextField> txt_list = new ArrayList<>();
        txt_list.add(txtUserID);
        txt_list.add(txtUsername);
        txt_list.add(txtGender);
        txt_list.add(txtEmail);
        txt_list.add(txtMobileNo);
        txt_list.add(txtAddress);
        ArrayList<Label> lbl_list = new ArrayList<>();
        lbl_list.add(lblUserID);
        lbl_list.add(lblUsername);
        lbl_list.add(lblGender);
        lbl_list.add(lblEmail);
        lbl_list.add(lblMobileNo);
        lbl_list.add(lblAddress);
        
        TextField txt = (TextField) event.getSource(); // Type Casting
        int index = txt_list.indexOf(txt); // Search for the TextField's index 
        lbl_list.get(index).setVisible(true); // Using the index number to access respective Label to float
    }
    
    @FXML
    private void loseFocus(MouseEvent event) throws Exception{ // Account Tab - Text Field Lose Focus
        ArrayList<TextField> txt_list = new ArrayList<>();
        txt_list.add(txtUserID);
        txt_list.add(txtUsername);
        txt_list.add(txtGender);
        txt_list.add(txtEmail);
        txt_list.add(txtMobileNo);
        txt_list.add(txtAddress);
        ArrayList<Label> lbl_list = new ArrayList<>();
        lbl_list.add(lblUserID);
        lbl_list.add(lblUsername);
        lbl_list.add(lblGender);
        lbl_list.add(lblEmail);
        lbl_list.add(lblMobileNo);
        lbl_list.add(lblAddress);
        
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
    
    @FXML
    private void selectSport() throws Exception { 
        lblSport.setVisible(true); // Float the label
        
        ArrayList<String> selection = new ArrayList<>();
        for(int index = 0; index < 5; index++)
        {
            selection.add(arraySports.get(index).getSportID() + ": " + arraySports.get(index).getSportName()); // Add choices into the ComboBox inside the pop-up dialog
        }
        
        if(!txtSport.getText().isEmpty())
        {
            selection.add("Withdraw"); // If student has existing sport, then offer option to withdraw from enrollment
        }
        
        ChoiceDialog<String> dialog = new ChoiceDialog<>(null, selection);
        dialog.setTitle("Sports Enrollment");
        dialog.setHeaderText(null);
        dialog.setContentText("Please select a sport:");

        Optional<String> result = dialog.showAndWait();
        if(result.isPresent())
        {
            if(!txtSport.getText().isEmpty()) // Has existing sport
            {
                if(!txtSport.getText().equals(result.get())) // Selecting a different sport than current one
                {
                    if(result.get().equals("Withdraw")) // Cancel Subscription (Un-enroll in a sport)
                    {
                        txtSport.setText("");
                    }
                    else
                    {
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("Confirmation");
                        alert.setHeaderText("Are you sure?");
                        String line1 = "You are already enrolled in a sport, do you wish to proceed?";
                        String line2 = "By clicking OK, you will be unregistered from your current sport.";
                        String msg = line1 + "\n" + line2;
                        alert.setContentText(msg); 

                        Optional<ButtonType> result_confirmation = alert.showAndWait();
                        if (result_confirmation.get() == ButtonType.OK) // OK option is selected
                        { 
                            txtSport.setText(result.get());
                        } 
                        else  // CANCEL is selected or the dialog is closed
                        { 
                            // Do nothing
                        }
                    }
                }
                else // Selecting the same sport as the current one
                {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Same sport selected!");
                    alert.setContentText("Please select a sport different from the current one.");
                    alert.showAndWait();
                }
            }
            else // New student, does not has existing sport
            {
                txtSport.setText(result.get());
            }
        }
        else // Cancel Button is clicked
        {
            // Do Nothing  
        }
        
        if(txtSport.getText().isEmpty())
        {
            lblSport.setVisible(false); // Unfloat the label
        }
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