package SportsCenter;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Student extends User implements Serializable{
    
    private static final long serialVersionUID = -5159246549876579356L;
    private ArrayList<String> lastFiveFeedbackID;
    private Sport sport;
    
    // No sport
    public Student(String userID, String username, String gender, String contact, String email, String address, ArrayList<String> lastFiveFeedbackID){
        super(userID, username, gender, contact, email, address);
        this.lastFiveFeedbackID = lastFiveFeedbackID;
    }
    
    // Has sport
    public Student(String userID, String username, String gender, String contact, String email, String address, ArrayList<String> lastFiveFeedbackID, Sport sport){
        super(userID, username, gender, contact, email, address);
        this.lastFiveFeedbackID = lastFiveFeedbackID;
        this.sport = sport;
    }
    
    public ArrayList<String> getLastFiveFeedbackID() {
        return lastFiveFeedbackID;
    }
    
    public void setLastFiveFeedbackID(ArrayList<String> lastFiveFeedbackID){
        this.lastFiveFeedbackID = lastFiveFeedbackID;
    }
    
    public Sport getSportObject() {
        return sport;
    }
    
    public void setSportObject(Sport sport){
        this.sport = sport;
    }
    
    //TO POPULATE TABLE COL
    public String getSportName(){
        String sportName = "";
        if (sport != null){
         sportName = sport.getSportName();
        }
        return sportName;
    }
    
    @Override // Override User getSport() Method - Dynamic Polymorphism
    public void getSport(ArrayList<Sport> arraySports, ArrayList<ArrayList> control_list){
        
        super.getSport(arraySports, control_list);
        
        ArrayList<ArrayList> btn_list = new ArrayList<>(control_list.subList(5,6)); // Extract the subset of all Buttons ArrayList
        ArrayList<ArrayList> vbox_list = new ArrayList<>(control_list.subList(6,7)); // Extract the subset of all VBoxes ArrayList
        
        int index = 0;
        ArrayList<String> sportID_list = new ArrayList<>();
        for (Sport sport : arraySports)
        {
            sportID_list.add(sport.getSportID()); // Add all SportID into a new ArrayList
            index++;
        }
        
        int sport_index;
        if(sport != null) // Student has an enrolled sport
        {
            sport_index = sportID_list.indexOf(sport.getSportID()); // Get the index of the student's current sportID from the ArrayList
        }
        else
        {
            sport_index = -1; // Student does not have an enrolled sport
        }
        
        if(sport_index >= 0 && sport_index <= 4) // Student's enrolled sport is in the active sport list
        {
            ArrayList<Button> btn_inner_list = new ArrayList<>(btn_list.get(0)); // the outer layer is an ArrayList of many Button ArrayList
            for(Button btn : btn_inner_list) // extract the Button ArrayList
            {
                btn.setText("ENROLL"); // All the remaining Buttons that hold the sports that are not enrolled by student
            }
            btn_inner_list.get(sport_index).setText("ENROLLED"); // The respective Button that hold the student's enrolled sport

            ArrayList<VBox> vbox_inner_list = new ArrayList<>(vbox_list.get(0)); // the outer layer is an ArrayList of many VBox ArrayList
            for(VBox vbox : vbox_inner_list) // extract the VBox ArrayList
            {
                vbox.setOpacity(1); // All the remaining VBoxes that hold the sports that are not enrolled by student
            }
            vbox_inner_list.get(sport_index).setOpacity(0.5); // The respective VBoxes that hold the student's enrolled sport
        } 
        else if(sport_index <= -1 || sport_index >= 5)// Student does not has an enrolled sport or active sport
        {
            ArrayList<Button> btn_inner_list = new ArrayList<>(btn_list.get(0)); // the outer layer is an ArrayList of many Button ArrayList
            for(Button btn : btn_inner_list) // extract the Button ArrayList
            {
                btn.setText("ENROLL"); // Set all Buttons text because student is not enrolled in any Sport
            }

            ArrayList<VBox> vbox_inner_list = new ArrayList<>(vbox_list.get(0)); // the outer layer is an ArrayList of many VBox ArrayList
            for(VBox vbox : vbox_inner_list) // extract the VBox ArrayList
            {
                vbox.setOpacity(1); // Set all VBoxes opacity because student is not enrolled in any Sport
            }
        }
    }
    
    @Override // Implementation of the Abstract Method getSchedule() from parent clsss User - Same Parameter
    public void getSchedule(ArrayList<Schedule> arraySchedule, ArrayList<ArrayList> control_list){
        
        ArrayList<ArrayList> lbl_list = new ArrayList<>(control_list.subList(0,5)); // Extract the subset of all Labels ArrayList
        ArrayList<ArrayList> hbox_list = new ArrayList<>(control_list.subList(5,6)); // Extract the subset of all HBoxes ArrayList
        ArrayList<ArrayList> tooltip_list = new ArrayList<>(control_list.subList(6,7)); // Extract the subset of all Tooltips ArrayList
        
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
            sportID_list.add(schedule.getSportID());  // Add all SportID into a new ArrayList
            index++;
        }
        
        int sport_index;
        if(sport != null) // Student has an enrolled sport
        {
            sport_index = sportID_list.indexOf(sport.getSportID()); // Get the index of the student's current sportID from the ArrayList
        }
        else
        {
            sport_index = -1; // Student does not have an enrolled sport
        }
        
        if(sport_index >= 0 && sport_index <= 4) // Student's enrolled sport is in the active sport list
        {
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
                            lbl.setText(arraySchedule.get(sport_index).getSportName());
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
                            lbl.setText("🎓 " + arraySchedule.get(sport_index).getCoachObject().getUsername());
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
                hbox.setOpacity(0.5); // All the remaining HBoxes that hold the sports that are not enrolled by student
            }
            hbox_inner_list.get(sport_index).setOpacity(1); // The respective HBoxes that hold the student's enrolled sport

            ArrayList<Tooltip> tooltip_inner_list = new ArrayList<>(tooltip_list.get(0)); // the outer layer is an ArrayList of many Tooltip ArrayList
            String coach_id = arraySchedule.get(sport_index).getCoachObject().getUserID();
            double rating = arraySchedule.get(sport_index).getCoachObject().getCoachRating();
            getCoach(tooltip_inner_list, sport_index, coach_id, rating);
        }
        else if(sport_index <= -1 || sport_index >= 5)// Student does not has an enrolled sport or active sport
        {
            ArrayList<HBox> hbox_inner_list = new ArrayList<>(hbox_list.get(0)); // the outer layer is an ArrayList of many Hbox ArrayList
            for(HBox hbox : hbox_inner_list) // extract the HBox ArrayList
            {
                hbox.setOpacity(0.5); // Set all HBoxes opacity because student is not enrolled in any Sport
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
                    txt.setText(username);
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
                        txt.setText(sport.getSportID() + ": " + sport.getSportName());
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
            else // Ask for confirmation
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
    
    public void getCoach(ArrayList<Sport> arraySports, ArrayList<Tooltip> tooltip_list){ // Method overloading - Static Polymorphism
        // Get Coach Rating for tooltip under Sports tab - We pass the whole Tooltip ArrayList because all Coaches' rating will be populated 
        int index = 0;
        for(Tooltip tooltip : tooltip_list)
        {
            String coach_id = arraySports.get(index).getCoachObject().getUserID();
            double rating = arraySports.get(index).getCoachObject().getCoachRating();
            String txt = "Coach ID: " + coach_id + "\n" + "Rating: " + rating + "/5.0";
            tooltip.setText(txt);
            index++;
        }
    }
    
    public void getCoach(ArrayList<Tooltip> tooltip_list, int sport_index, String coach_id, double rating){ // Method overloading - Static Polymorphism
        // Get Coach Rating for tooltip under Schedule Tab - We only pass the Sport index of which the student is enrolled in
        String txt = "Coach ID: " + coach_id + "\n" + "Rating: " + rating + "/5.0";
        tooltip_list.get(sport_index).setText(txt); // We use the Sport index to populate only one Coach's rating 
    }                                               // who is teaching the Sport of the student currently enrolled in
    
    public void getCoach_History(ArrayList<Schedule> arraySchedule, ArrayList<Tooltip> tooltip_list){ 
        // Get Coach Rating for tooltip under History tab
        int index = 0;
        for(Tooltip tooltip : tooltip_list)
        {
            String coach_id = arraySchedule.get(index).getCoachObject().getUserID();
            double rating = arraySchedule.get(index).getCoachObject().getCoachRating();
            String txt = "Coach ID: " + coach_id + "\n" + "Rating: " + rating + "/5.0";
            tooltip.setText(txt);
            index++;
        }
    }
    
    public void getHistory(ArrayList<Schedule> arraySchedule, ArrayList<Feedback> arrayFeedback, ArrayList<ArrayList> control_list){
        
        ArrayList<ArrayList> lbl_list = new ArrayList<>(control_list.subList(0,4)); // Extract the subset of all Labels ArrayList
        ArrayList<ArrayList> tooltip_list = new ArrayList<>(control_list.subList(4,5)); // Extract the subset of all Tooltips ArrayList
        
        int index = 0;
        ArrayList<String> sportID_list = new ArrayList<>();
        for (Schedule schedule : arraySchedule)
        {
            sportID_list.add(schedule.getSportID());  // Add all 5 SportID into a new ArrayList
            index++;
        }
        
        if(sport != null) // If student has an enrolled sport
        {
            int sport_index = sportID_list.indexOf(sport.getSportID()); // Get the index of the student's current sportID from the ArrayList
        }
        
        int index1 = 0; 
        for (ArrayList<Label> controls : lbl_list) // Accessing outer ArrayList (ArrayList of different labels)
        {
            int index2 = 0;
            for(Label lbl : controls) // Accessing inner ArrayList (Actual labels holding attributes of History)
            {
                switch(index1){
                    case 0: // History Attribute 1 - Sport Name
                        lbl.setText(arraySchedule.get(index2).getSportName());
                        break;
                    case 1: // History Attribute 2 - Date
                        lbl.setText(arraySchedule.get(index2).getDate());
                        break;
                    case 2: // History Attribute 3 - Coach Name
                        lbl.setText(arraySchedule.get(index2).getCoachObject().getUsername());
                        break;
                    case 3: // History Attribute 4 - Class Rating
                        if(!lastFiveFeedbackID.get(index2).equals("")) // Check if the student has already provided a feedback
                        {
                            for(Feedback fdb: arrayFeedback)
                            {
                                if(fdb.getFeedbackID().equals(lastFiveFeedbackID.get(index2)))
                                {   
                                    lbl.setText(fdb.getClassRating() + ".0/5.0");
                                    break;
                                }
                            }
                        }
                        else
                        {
                            lbl.setText("-/5.0"); // No feedback submitted yet
                        }
                        break;
                }
                index2++;
            }  
            index1++;
        }
        
        getCoach_History(arraySchedule, tooltip_list.get(0));
    }
   
    public void submitFeedback(int index) throws IOException{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("feedback.fxml"));
        Parent root = (Parent) loader.load();
        feedbackController feedback_con = loader.getController();
        feedback_con.pushFeedback(lastFiveFeedbackID.get(index), index, this);
        Stage stage = new Stage();
        stage.setTitle("Feedback Form Submission");
        stage.setScene(new Scene(root, 645, 490));
        stage.show();  

        // Pass Feedback ID to feedbackController,
        // so that it knows to Submit Feedback or Review Feedback
        // Submit Feedback - Submit Button Enabled | 0 Stars by default
        // Review Feedback - Submit Button Disabled | Stars populated according to record
    }
}
