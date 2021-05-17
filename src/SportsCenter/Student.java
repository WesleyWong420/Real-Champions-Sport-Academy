package SportsCenter;

import java.util.ArrayList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Student extends User{
    
    private String name;
    private String gender;
    private int contact;
    private String email;
    private String address;
    private ArrayList lastFiveClassesID;
    private String currentSportID;
    
    public Student(){}
    
    public Student(String userID, String name, String gender, int contact, String email, String address, ArrayList lastFiveClassesID, String currentSportID){
        this.userID = userID;
        this.name = name;
        this.gender = gender;
        this.contact = contact;
        this.email = email;
        this.address = address;
        this.lastFiveClassesID = lastFiveClassesID;
        this.currentSportID = currentSportID;
    }
    
    public String getUserID() {
        return userID;
    }
    
    public void setUserID(String userID){
        this.userID = userID;
    }
    
    public String getGender() {
        return gender;
    }
    
    public void setGender(String gender){
        this.gender = gender;
    }
    
    public int getContact() {
        return contact;
    }
    
    public void setContact(int contact){
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
    
    public ArrayList getLastFiveClassesID() {
        return lastFiveClassesID;
    }
    
    public void setLastFiveClassesID(ArrayList lastFiveClassesID){
        this.lastFiveClassesID = lastFiveClassesID;
    }
    
    public String getCurrentSportID() {
        return currentSportID;
    }
    
    public void setCurrentSportID(String currentSportID){
        this.currentSportID = currentSportID;
    }
    
    @Override // Override User getSport() Method - Dynamic Polymorphism
    public void getSport(ArrayList<Sport> arraySports, ArrayList<ArrayList> control_list){
        
        super.getSport(arraySports, control_list);
        
        ArrayList<ArrayList> btn_list = new ArrayList<ArrayList>(control_list.subList(5,6));
        ArrayList<ArrayList> vbox_list = new ArrayList<ArrayList>(control_list.subList(6,7));
        
        int index = 0;
        ArrayList<String> sportID_list = new ArrayList<String>();
        for (Sport sport : arraySports)
        {
            sportID_list.add(sport.getSportID()); // Add all 5 SportID into a new ArrayList
            index++;
        }
        
        if(currentSportID != null)
        {
            int sport_index = sportID_list.indexOf(currentSportID); // Get the index of the student's current sportID from the ArrayList
            
            ArrayList<Button> btn_inner_list = new ArrayList<Button>(btn_list.get(0)); // the outer layer is an ArrayList of many Button ArrayList
            for(Button btn : btn_inner_list) // extract the Button ArrayList
            {
                btn.setText("ENROLL");
            }
            btn_inner_list.get(sport_index).setText("ENROLLED");
            
            ArrayList<VBox> vbox_inner_list = new ArrayList<VBox>(vbox_list.get(0)); // the outer layer is an ArrayList of many VBox ArrayList
            for(VBox vbox : vbox_inner_list) // extract the VBox ArrayList
            {
                vbox.setOpacity(1);
            }
            vbox_inner_list.get(sport_index).setOpacity(0.5);
        } 
    }
    
    @Override // Override User getSchedule() Method - Dynamic Polymorphism
    public void getSchedule(ArrayList<Schedule> arraySchedule, ArrayList<ArrayList> control_list){
        ArrayList<ArrayList> lbl_list = new ArrayList<ArrayList>(control_list.subList(0,5));
        ArrayList<ArrayList> hbox_list = new ArrayList<ArrayList>(control_list.subList(5,6));
        
        for (ArrayList<Label> controls : lbl_list) // Accessing outer ArrayList (ArrayList of different labels)
        {
            for(Label lbl : controls) // Accessing inner ArrayList (Actual labels holding attributes of Schedules)
            {
                lbl.setText(""); // Clear text for all labels
            }  
        }
        
        int index = 0;
        ArrayList<String> sportID_list = new ArrayList<String>();
        for (Schedule schedule : arraySchedule)
        {
            sportID_list.add(schedule.getSportID());  // Add all 5 SportID into a new ArrayList
            index++;
        }
        
        if(currentSportID != null)
        {
            int sport_index = sportID_list.indexOf(currentSportID); // Get the index of the student's current sportID from the ArrayList
            
            int index2 = 0; 
            for (ArrayList<Label> controls : lbl_list) // Accessing outer ArrayList (ArrayList of different labels)
            {
                int index3 = 0;
                for(Label lbl : controls) // Accessing inner ArrayList (Actual labels holding attributes of Schedules)
                {
                    if(index3 == sport_index) // We only want to set text for the sport schedule that the student is currently enrolled in
                    {
                        switch(index2){
                        case 0: // Schedule Attribute 1 - Name
                            lbl.setText(arraySchedule.get(sport_index).getName());
                            break;
                        case 1: // Schedule Attribute 2 - Time
                            lbl.setText(arraySchedule.get(sport_index).getTime());
                            break;
                        case 2: // Schedule Attribute 3 - Date
                            lbl.setText(arraySchedule.get(sport_index).getDate());
                            break;
                        case 3: // Schedule Attribute 4 - Location
                            lbl.setText(arraySchedule.get(sport_index).getLocation());
                            break;
                        case 4: // Schedule Attribute 5 - Coach Name
                            lbl.setText(arraySchedule.get(sport_index).getCoach());
                            break;
                        }
                    }
                    index3++;
                }  
                index2++;
            }
            
            ArrayList<HBox> hbox_inner_list = new ArrayList<HBox>(hbox_list.get(0)); // the outer layer is an ArrayList of many Hbox ArrayList
            for(HBox hbox : hbox_inner_list) // extract the HBox ArrayList
            {
                hbox.setOpacity(0.5);
            }
            hbox_inner_list.get(sport_index).setOpacity(1);
        } 
    }
}
