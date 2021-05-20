package SportsCenter;

import java.util.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class Student extends User{
    
    private Sport sport;
    private String name;
    private String gender;
    private String contact;
    private String email;
    private String address;
    private ArrayList<String> lastFiveClassesID;
    
    // No sport
    public Student(String userID, String name, String gender, String contact, String email, String address, ArrayList<String> lastFiveClassesID){
        this.userID = userID;
        this.name = name;
        this.gender = gender;
        this.contact = contact;
        this.email = email;
        this.address = address;
        this.lastFiveClassesID = lastFiveClassesID;
    }
    
    // Has sport
    public Student(Sport sport, String userID, String name, String gender, String contact, String email, String address, ArrayList<String> lastFiveClassesID){
        this.sport = sport;
        this.userID = userID;
        this.name = name;
        this.gender = gender;
        this.contact = contact;
        this.email = email;
        this.address = address;
        this.lastFiveClassesID = lastFiveClassesID;
    }
    
    public Sport getSportObject() {
        return sport;
    }
    
    public void setSportObject(Sport sport){
        this.sport = sport;
    }
    
    public String getUserID() {
        return userID;
    }
    
    public void setUserID(String userID){
        this.userID = userID;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getGender() {
        return gender;
    }
    
    public void setGender(String gender){
        this.gender = gender;
    }
    
    public String getContact() {
        return contact;
    }
    
    public void setContact(String contact){
        this.contact = contact;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address){
        this.address = address;
    }
    
    public ArrayList<String> getLastFiveClassesID() {
        return lastFiveClassesID;
    }
    
    public void setLastFiveClassesID(ArrayList<String> lastFiveClassesID){
        this.lastFiveClassesID = lastFiveClassesID;
    }
    
    @Override // Override User getSport() Method - Dynamic Polymorphism
    public void getSport(ArrayList<Sport> arraySports, ArrayList<ArrayList> control_list){
        
        super.getSport(arraySports, control_list);
        
        ArrayList<ArrayList> btn_list = new ArrayList<>(control_list.subList(5,6));
        ArrayList<ArrayList> vbox_list = new ArrayList<>(control_list.subList(6,7));
        
        int index = 0;
        ArrayList<String> sportID_list = new ArrayList<>();
        for (Sport sport : arraySports)
        {
            sportID_list.add(sport.getSportID()); // Add all 5 SportID into a new ArrayList
            index++;
        }

        if(sport != null)
        {
            int sport_index = sportID_list.indexOf(sport.getSportID()); // Get the index of the student's current sportID from the ArrayList
            
            ArrayList<Button> btn_inner_list = new ArrayList<>(btn_list.get(0)); // the outer layer is an ArrayList of many Button ArrayList
            for(Button btn : btn_inner_list) // extract the Button ArrayList
            {
                btn.setText("ENROLL");
            }
            btn_inner_list.get(sport_index).setText("ENROLLED");
            
            ArrayList<VBox> vbox_inner_list = new ArrayList<>(vbox_list.get(0)); // the outer layer is an ArrayList of many VBox ArrayList
            for(VBox vbox : vbox_inner_list) // extract the VBox ArrayList
            {
                vbox.setOpacity(1);
            }
            vbox_inner_list.get(sport_index).setOpacity(0.5);
        } 
        else
        {
            ArrayList<Button> btn_inner_list = new ArrayList<>(btn_list.get(0)); // the outer layer is an ArrayList of many Button ArrayList
            for(Button btn : btn_inner_list) // extract the Button ArrayList
            {
                btn.setText("ENROLL");
            }
            
            ArrayList<VBox> vbox_inner_list = new ArrayList<>(vbox_list.get(0)); // the outer layer is an ArrayList of many VBox ArrayList
            for(VBox vbox : vbox_inner_list) // extract the VBox ArrayList
            {
                vbox.setOpacity(1);
            }
        }
    }
    
    @Override // Override User getSchedule() Method - Dynamic Polymorphism
    public void getSchedule(ArrayList<Schedule> arraySchedule, ArrayList<ArrayList> control_list){
        
        ArrayList<ArrayList> lbl_list = new ArrayList<>(control_list.subList(0,5));
        ArrayList<ArrayList> hbox_list = new ArrayList<>(control_list.subList(5,6));
        
        for (ArrayList<Label> controls : lbl_list) // Accessing outer ArrayList (ArrayList of different labels)
        {
            for(Label lbl : controls) // Accessing inner ArrayList (Actual labels holding attributes of Schedules)
            {
                lbl.setText(""); // Clear text for all labels
            }  
        }
        
        int index = 0;
        ArrayList<String> sportID_list = new ArrayList<>();
        for (Schedule schedule : arraySchedule)
        {
            sportID_list.add(schedule.getSportID());  // Add all 5 SportID into a new ArrayList
            index++;
        }
        
        if(sport != null)
        {
            int sport_index = sportID_list.indexOf(sport.getSportID()); // Get the index of the student's current sportID from the ArrayList
            
            int index2 = 0; 
            for (ArrayList<Label> controls : lbl_list) // Accessing outer ArrayList (ArrayList of different labels)
            {
                int index3 = 0;
                for(Label lbl : controls) // Accessing inner ArrayList (Actual labels holding attributes of Schedules)
                {
                    if(index3 == sport_index) // We only want to set text for the sport schedule that the student is currently enrolled in
                    {                         // Student are not allowed to see schedule outside of their enrolled sport
                        switch(index2){
                        case 0: // Schedule Attribute 1 - Name
                            lbl.setText(arraySchedule.get(sport_index).getName());
                            break;
                        case 1: // Schedule Attribute 2 - Time
                            lbl.setText("🕒 " + arraySchedule.get(sport_index).getTime());
                            break;
                        case 2: // Schedule Attribute 3 - Date
                            lbl.setText("📅 " + arraySchedule.get(sport_index).getDate());
                            break;
                        case 3: // Schedule Attribute 4 - Location
                            lbl.setText("📍 " + arraySchedule.get(sport_index).getLocation());
                            break;
                        case 4: // Schedule Attribute 5 - Coach Name
                            lbl.setText("🎓 " + arraySchedule.get(sport_index).getCoachObject().getName());
                            break;
                        }
                    }
                    index3++;
                }  
                index2++;
            }
            
            ArrayList<HBox> hbox_inner_list = new ArrayList<>(hbox_list.get(0)); // the outer layer is an ArrayList of many Hbox ArrayList
            for(HBox hbox : hbox_inner_list) // extract the HBox ArrayList
            {
                hbox.setOpacity(0.5);
            }
            hbox_inner_list.get(sport_index).setOpacity(1);
        }
        else
        {
            ArrayList<HBox> hbox_inner_list = new ArrayList<>(hbox_list.get(0)); // the outer layer is an ArrayList of many Hbox ArrayList
            for(HBox hbox : hbox_inner_list) // extract the HBox ArrayList
            {
                hbox.setOpacity(0.5);
            }
        }
    }
    
    public void getSelfRecord(ArrayList<TextField> txt_list){
        
        int index = 0;
        for(TextField txt : txt_list)
        {
            switch(index){
                case 0:
                    txt.setText(userID);
                    break;
                case 1:
                    txt.setText(name);
                    break;
                case 2:
                    txt.setText(gender);
                    break;
                case 3:
                    txt.setText(email);
                    break;
                case 4:
                    txt.setText(contact);
                    break;
                case 5:
                    txt.setText(address);
                    break;
                case 6:
                    if(sport != null)
                    {
                        txt.setText(sport.getName());
                    }
                    else
                    {
                        txt.setText("");
                    }
                    break;
            }
            index++;
        }
    }
    
    public void enrollSport(Sport sport_to_enroll){
        
        if(sport != null) // Has existing sport enrolled
        {
            if(sport.equals(sport_to_enroll)) // Choosing same sport as current one
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
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
                    sport = sport_to_enroll;
                } 
                else  // CANCEL is selected or the dialog is closed
                { 
                    // Do nothing
                } 
            }
        }
        else
        {
            sport = sport_to_enroll;
        }
    }
    
    /*
    public void getCoach(){}
    public void getHistory(){}
    public void submitFeedback(){}
    public void setSelfRecord(){}
    */
}
