package SportsCenter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import javafx.scene.input.MouseEvent;
import java.util.ArrayList;
import java.util.Optional;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;

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
    
    Student student = new Student();

    public void initialize() {
        groupSport(student);
        groupSchedule(student);
    }
    
    public ArrayList<Sport> readSportsFile(String file){
        
        ArrayList<Sport> arraySports = new ArrayList<Sport>();
        
        try 
        {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("src\\SportsCenter\\txt\\" + file));
            arraySports = (ArrayList<Sport>) input.readObject(); // Reading ArrayList of Sports Object
            input.close();
        }
        catch (FileNotFoundException e){
            System.out.println("File not found!");
        }
        catch (IOException e){
            e.printStackTrace();
        }
        catch (ClassNotFoundException e){
            System.out.println("Class not found");
        }
        
        return arraySports;
    }
    
    public ArrayList<Schedule> readScheduleFile(String file){
        
        ArrayList<Schedule> arraySchedule = new ArrayList<Schedule>();
        
        try 
        {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("src\\SportsCenter\\txt\\" + file));
            arraySchedule = (ArrayList<Schedule>) input.readObject(); // Reading ArrayList of Schedule Object
            input.close();
        }
        catch (FileNotFoundException e){
            System.out.println("File not found!");
        }
        catch (IOException e){
            e.printStackTrace();
        }
        catch (ClassNotFoundException e){
            System.out.println("Class not found");
        }
        
        return arraySchedule;
    }
    
    public void groupSport(Student student){
            
        ArrayList<Sport> arraySports = new ArrayList<Sport>();
        arraySports = readSportsFile("sports1.txt");

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

        student.getSport(arraySports, control_list);
    }
    
    public void groupSchedule(Student student){
        
        ArrayList<Schedule> arraySchedule = new ArrayList<Schedule>();
        arraySchedule = readScheduleFile("schedule1.txt");

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
        control_list.add(name); 
        control_list.add(time); 
        control_list.add(date); 
        control_list.add(location); 
        control_list.add(coach);
        control_list.add(hbox_list);

        student.getSchedule(arraySchedule, control_list);
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
        
        Button btn_pressed = new Button();
        btn_pressed = (Button) event.getSource(); // To know which 1 out of 5 button is clicked
                
        ArrayList<Button> btn_list = new ArrayList<>(); // Grouping all Buttons
        btn_list.add(btnSport1Enroll_SportsTab);
        btn_list.add(btnSport2Enroll_SportsTab);
        btn_list.add(btnSport3Enroll_SportsTab);
        btn_list.add(btnSport4Enroll_SportsTab);
        btn_list.add(btnSport5Enroll_SportsTab);
        int btn_index = btn_list.indexOf(btn_pressed);
        
        ArrayList<Sport> arraySports = new ArrayList<Sport>();
        arraySports = readSportsFile("sports1.txt");
        
        if(student.getCurrentSportID() != null) // Has existing sport enrolled
        {
            if(student.getCurrentSportID().equals(arraySports.get(btn_index).getSportID())) // Choosing same sport as current one
            {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Same sport selected!");
                alert.setContentText("Please select a sport different from the current one.");
                alert.showAndWait();
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

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) // OK option is selected
                {
                    student.setCurrentSportID(arraySports.get(btn_index).getSportID());
                    // write to student object file
                    groupSport(student); // call the groupSport() method again to refresh the sport page
                    groupSchedule(student); // call the groupSport() method again to refresh the schedule page
                } 
                else  // CANCEL is selected or the dialog is closed
                { 
                    // Do nothing
                } 
            }
        }
        else
        {
            student.setCurrentSportID(arraySports.get(btn_index).getSportID());
            // write to student object file
            groupSport(student); // call the groupSport() method again to refresh the sport page
            groupSchedule(student); // call the groupSport() method again to refresh the schedule page
        }
    }
    
    @FXML
    private void pressFeedback(MouseEvent event) throws Exception {
        Label lbl = new Label();
        lbl = (Label) event.getSource(); // To know which 1 out of 5 label is clicked
        
        // Use lbl to query History Object
        // Pass History Object to feedbackController,
        // so that it knows to Submit Feedback or Review Feedback
        // Submit Feedback - Submit Button Enabled | 0 Stars by default
        // Review Feedback - Submit Button Disabled | Stars populated according to record
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("feedback.fxml"));
        Parent root = (Parent) loader.load();
        feedbackController feedback_con = loader.getController();
        //feedback_con.pushHistory(history1);
        Stage stage = new Stage();
        stage.setScene(new Scene(root, 645, 545));
        stage.show();   
    }
    
    @FXML
    private void pressCoachName(MouseEvent event) throws Exception {
    }
    
    @FXML
    private void pressSave() throws Exception {
        btnSave.setDisable(true);
        btnEdit.setDisable(false);
        txtUserID.setDisable(true); // Just for visual, UserID cannot be modified
        txtGender.setDisable(true); // Just for visual, Gender cannot be modified
        txtUsername.setDisable(true);
        txtEmail.setDisable(true);
        txtMobileNo.setDisable(true);
        txtAddress.setDisable(true);
        txtSport.setDisable(true);
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
    private void selectSport() throws Exception { // Student Profile Tabs
        ArrayList<Sport> arraySports = new ArrayList<Sport>();
        arraySports = readSportsFile("sports1.txt");
        lblSport.setVisible(true); // Float the label
        
        ArrayList<String> selection = new ArrayList<>();
        for(int index = 0; index < arraySports.size(); index++)
        {
            selection.add(arraySports.get(index).getName()); // Add choices into the ComboBox inside the pop-up dialog
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
    
    private void getSelfRecord(){
    }
    
    private void setSelfRecord(){
    }
}

        
    
