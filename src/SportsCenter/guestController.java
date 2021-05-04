package SportsCenter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.ArrayList;

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
        getSport("sports1.txt");
        //addSport("sports3.txt");
    }
    
    public void getSport(String file){
        try 
        {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("src\\SportsCenter\\txt\\" + file));
            ArrayList<Sport> arraySports = (ArrayList<Sport>) input.readObject(); // Reading ArrayList of Sports Object
               
            String img_dir = "src\\SportsCenter\\images\\"; // Image directory
            ArrayList<ImageView> img_list = new ArrayList<>(); // Grouping all ImageViews
            img_list.add(imgSport1Logo_SportsTab);
            img_list.add(imgSport2Logo_SportsTab);
            img_list.add(imgSport3Logo_SportsTab);
            img_list.add(imgSport4Logo_SportsTab);
            img_list.add(imgSport5Logo_SportsTab);
            
            ArrayList<ArrayList> sport_list = new ArrayList<>(); // Outer ArrayList 
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
            sport_list.add(name); 
            sport_list.add(duration); 
            sport_list.add(fee); 
            sport_list.add(coach); 
            
            int index1 = 0; 
            for (ArrayList<Label> sport : sport_list) // Accessing outer ArrayList (Attributes of Sports)
            {
                int index2 = 0;
                for(Label lbl : sport) // Accessing inner ArrayList (Number of Sports)
                {
                    switch(index1){
                        case 0: // Sport Attribute 1 - Name & Logo
                            lbl.setText(arraySports.get(index2).getName());
                            String img_src =  img_dir + arraySports.get(index2).getName() + ".png";
                            Image image = new Image(new FileInputStream(img_src));
                            for(ImageView img : img_list)
                            {
                                img_list.get(index2).setImage(image);
                            }
                            break;
                        case 1: // Sport Attribute 2 - Duration
                            lbl.setText(Integer.toString(arraySports.get(index2).getDuration()) + " Minutes");
                            break;
                        case 2: // Sport Attribute 3 - Fee
                            lbl.setText("MYR " + Integer.toString(arraySports.get(index2).getFee()));
                            break;
                        case 3: // Sport Attribute 4 - Coach Name
                            lbl.setText(arraySports.get(index2).getCoach());
                            break;
                    }
                    index2++;
                }  
                index1++;
            }
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
    }
    
    public void addSport(String file){
        try 
        {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("src\\SportsCenter\\txt\\" + file));
            ArrayList<Sport> arraySports = new ArrayList<>();  // Writing ArrayList of Sports Object
            /*
            Sport sport1 = new Sport("Archery", 120, 130, "Alex");
            Sport sport2 = new Sport("Badminton", 120, 90, "Bob");
            Sport sport3 = new Sport("Basketball", 120, 90, "Caitlin");
            Sport sport4 = new Sport("Gymnastics", 120, 70, "Demetrice");
            Sport sport5 = new Sport("Hockey", 120, 125, "Evenlyn");
            */
            Sport sport1 = new Sport("PingPong", 120, 100, "Fiona");
            Sport sport2 = new Sport("Soccer", 150, 100, "George");
            Sport sport3 = new Sport("Swimming", 150, 120, "Harry");
            Sport sport4 = new Sport("Tennis", 120, 130, "Iris");
            Sport sport5 = new Sport("Volleyball", 120, 90, "Julia");
            
            arraySports.add(sport1);
            arraySports.add(sport2);
            arraySports.add(sport3);
            arraySports.add(sport4);
            arraySports.add(sport5);
            
            output.writeObject(arraySports);
            output.close(); 
        } 
        catch (IOException e){
            e.printStackTrace();
        }
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
        String s = "Please login to enroll in a sport.";
        alert.setContentText(s);
        alert.showAndWait(); 
    }
}