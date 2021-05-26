package SportsCenter;

import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class welcomeController {
    
    @FXML
    private Button btnGuest, btnLogin, submitBtn;
    @FXML
    private Label loginstatus, registerstatus;
    @FXML
    private TextField userTxt, studentIDRTxt, SportRCBox, nameRTxt, emailRTxt, contactRTxt, genderRTxt;
    
    @FXML
    private PasswordField passTxt, passRTxt;
    
    @FXML
    private TextArea addressRTxt;
    
    @FXML
    private ChoiceBox sportRCBox; 
    
    private Guest guest = new Guest();
    
    public static int index = -1;
    
    private ArrayList<Sport> arraySports;
    private ArrayList<Student> arrayStudent;
    private ArrayList<Coach> arrayCoach;

    public void initialize() {
    //FileIO temp = new FileIO(); //initiating admin login for first use 
    //temp.addlogin("login.txt");
    
    //Generating UserID for Registration Tab
       studentIDRTxt.setText(guest.generateUserID());
       
    //Adding sports to choicebox 
       arraySports = FileIO.readSportsFile("sport.txt");
       for (Sport tempSport : arraySports){
           sportRCBox.getItems().add(tempSport.getSportID()+" "+tempSport.getSportName());
       }
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
        String resource = "welcome.fxml", title = "Welcome";
        login tempLogin;
        login validLogin = null;
        
        //Checking if login details are valid
        
        if ((userTxt.getText() != null)&& (passTxt.getText()!= null)){
            tempLogin = new login(userTxt.getText(),passTxt.getText());
            validLogin = tempLogin.validate(userTxt.getText(), passTxt.getText());
            if (validLogin != null){
 
               switch(tempLogin.getAccess()){
                case 'A':
                    resource ="admin.fxml";
                    title = "Admin Dashboard";
                    break;
                case 'S':
                    resource ="student.fxml";
                    title = "Student Dashboard";
                    
                    arrayStudent = FileIO.readStudentFile("student.txt");
                    for(Student sdt : arrayStudent)
                    {
                        if(sdt.getUserID().equals(validLogin.getStudent().getUserID()))
                        {
                            index = arrayStudent.indexOf(sdt);
                            break;
                        }
                    }
                    break;
                case 'C':
                    resource ="coach.fxml";
                    title = "Coach Dashboard";
                    
                    arrayCoach = FileIO.readCoachFile("coach.txt");
                    for(Coach ch : arrayCoach)
                    {
                        if(ch.getUserID().equals(validLogin.getCoach().getUserID()))
                        {
                            index = arrayCoach.indexOf(ch);
                            break;
                        }
                    }
                    break;
                }
                
                FXMLLoader loader = new FXMLLoader(getClass().getResource(resource));
                Parent root = loader.load();
                Stage window = (Stage) btnLogin.getScene().getWindow(); 
                window.setScene(new Scene(root, 800, 480));
                window.setTitle(title);
            }else{
                loginstatus.setText("*Incorrect Login Details!");
                userTxt.clear();
                passTxt.clear();
            }
        }else{
            System.out.println("Error in Login!");
        }
    }
    
    @FXML
    private void pressSubmit(javafx.event.ActionEvent event) throws Exception {
        String selectedSportID = null;
        String value = (String) sportRCBox.getValue();
        if(value != null){
            String [] selectedSportText = value.split(" ", 2);
            selectedSportID = selectedSportText[0];
        }

        if ((studentIDRTxt.getText()!= null) && (passRTxt.getText() != null)&& (nameRTxt.getText() != null) && (emailRTxt.getText() != null) && (contactRTxt.getText() != null) && (selectedSportID != null)){

            //making guest user a student
            
            Guest newGuest = new Guest(studentIDRTxt.getText(),nameRTxt.getText(),genderRTxt.getText(),contactRTxt.getText(),emailRTxt.getText(),addressRTxt.getText());
            newGuest.register(selectedSportID,passRTxt.getText());
            
            Parent root = FXMLLoader.load(getClass().getResource("welcome.fxml"));
            Stage window = (Stage) submitBtn.getScene().getWindow(); 
            window.setScene(new Scene(root, 800, 480));
            window.setTitle("Welcome");
        }else{
            registerstatus.setText("Please enter all details!");
        }
    }
}
