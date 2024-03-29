package SportsCenter;

import java.io.Serializable;
import java.util.ArrayList;
import javafx.scene.control.TextField;

public class Coach extends User implements Serializable{
    
    private double coachRating;
    private int hourlyRate;
    
    public Coach(String userID, String username){ // Constructor overloading - Will be called by Feedback class
        this.userID = userID;
        this.username = username;
    }
    
    public Coach(String userID, String username, String gender, String contact, String email, String address, double coachRating, int hourlyRate){
        super(userID, username, gender, contact, email, address);
        this.coachRating = coachRating;
        this.hourlyRate = hourlyRate;
    }
    
    public double getCoachRating() {
        return coachRating;
    }
    
    public void setCoachRating(double coachRating){
        this.coachRating = coachRating;
    }
    
    public int getHourlyRate() {
        return hourlyRate;
    }
    
    public void setHourlyRate(int hourlyRate){
        this.hourlyRate = hourlyRate;
    }
    
    @Override // Override User getSport() Method - Dynamic Polymorphism
    public void getSport(ArrayList<Sport> arraySports, ArrayList<ArrayList> control_list){
        
        TextField txt = (TextField) control_list.get(0).get(0); // Extract out from inner and outer ArrayList and cast as TextField
        
        for(Sport sport : arraySports)
        {
            if(sport.getCoachObject().getUserID().equals(userID)) // Sport HAS-A Coach Relationship (Aggregation)
            {                                                     // Make sure that the coachID of the Coach object stored inside Sport object
                txt.setText(sport.getSportName());                // equals to the coachID of the current Coach object.
            }
        }
    }
    
    @Override // Override User getSchedule() Method - Dynamic Polymorphism
    public void getSchedule(ArrayList<Schedule> arraySchedule, ArrayList<ArrayList> control_list){
        
        TextField txt = (TextField) control_list.get(0).get(0); // Extract out from inner and outer ArrayList and cast as TextField
        
        for(Schedule session : arraySchedule)
        {
            if(session.getCoachObject().getUserID().equals(userID)) // Schedule extends Sport (Inheritance)
            {                                                       // Make sure that the coachID of the Coach Object stored inside Schedule object
                txt.setText(session.getTime() + " " + session.getDate());// equals to the coachID of the current Coach object.
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
                    txt.setText(Double.toString(coachRating) + "/5.0");
                    break;
                case 7:
                    txt.setText("$" + Integer.toString(hourlyRate));
                    break;
            }
            index++;
        }
    }
}