package SportsCenter;

import java.io.Serializable;
import java.util.ArrayList;
import javafx.scene.control.TextField;

public class Coach extends User implements Serializable{
    
    private double coachRating;
    private int hourlyRate;
    
    public Coach(String userID, String username){ // For Feedback class
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
    
    @Override
    public void getSport(ArrayList<Sport> arraySports, ArrayList<ArrayList> control_list){
        
        TextField txt = (TextField) control_list.get(0).get(0);
        
        for(Sport sport : arraySports)
        {
            if(sport.getCoachObject().getUserID().equals(userID))
            {
                txt.setText(sport.getSportName());
            }
        }
    }
    
    @Override 
    public void getSchedule(ArrayList<Schedule> arraySchedule, ArrayList<ArrayList> control_list){
        
        TextField txt = (TextField) control_list.get(0).get(0);
        
        for(Schedule session : arraySchedule)
        {
            if(session.getCoachObject().getUserID().equals(userID))
            {
                txt.setText(session.getTime() + " " + session.getDate());
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
    
    /*
    public void getFeedback
    */
}