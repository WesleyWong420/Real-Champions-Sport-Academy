package SportsCenter;

import java.io.Serializable;
import java.util.ArrayList;
import javafx.scene.control.TextField;

public class Coach extends User implements Serializable{
    
    private static final long serialVersionUID = 1069953104396136378L;
    private double coachRating;
    private int hourlyRate;
    private String sportCenterID;
    private String sportCenterName;
    
    public Coach(){} // for calling id gen
    
    public Coach(String userID, String username){ // Constructor overloading - Will be called by Feedback class
        this.userID = userID;
        this.username = username;
    }
    
    public Coach(String userID, String username, String gender, String contact, String email, String address, double coachRating, int hourlyRate, String sportCenterID, String sportCenterName){
        super(userID, username, gender, contact, email, address);
        this.coachRating = coachRating;
        this.hourlyRate = hourlyRate;
        this.sportCenterID = sportCenterID;
        this.sportCenterName = sportCenterName;
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
    
    public String getSportCenterID() {
        return sportCenterID;
    }
    
    public void setSportCenterID(String sportCenterID){
        this.sportCenterID = sportCenterID;
    }
    
    public String getSportCenterName() {
        return sportCenterName;
    }
    
    public void setSportCenterName(String sportCenterName){
        this.sportCenterName = sportCenterName;
    }
    
    @Override // Override User getSport() Method - Dynamic Polymorphism
    public void getSport(ArrayList<Sport> arraySports, ArrayList<ArrayList> control_list){
        
        TextField txt = (TextField) control_list.get(0).get(0); // Extract out from inner and outer ArrayList and cast as TextField
        
        for(Sport sport : arraySports)
        {
            if(sport.getCoachObject().getUserID().equals(userID)) // Sport HAS-A Coach Relationship (Aggregation)
            {                                                     // Make sure that the coachID of the Coach object stored inside Sport object
                txt.setText(sport.getSportID() + ": " + sport.getSportName()); // equals to the coachID of the current Coach object.
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
                    txt.setText(contact);
                    break;
                case 4:
                    txt.setText(email);
                    break;
                case 5:
                    txt.setText(address);
                    break;
                case 6:
                    txt.setText(Double.toString(coachRating) + "/5.0");
                    break;
                case 7:
                    txt.setText("MYR" + Integer.toString(hourlyRate));
                    break;
                case 8:
                    txt.setText(sportCenterID + ": " + sportCenterName);
            }
            index++;
        }
    }
    
    public String generateUserID(){
        ArrayList<Coach> arrayCoach = FileIO.readCoachFile("coach.txt");
        String newID = "C001";
        //Checking for last Student UserID
        if (arrayCoach.size() > 0){
            Coach lastCoach = arrayCoach.get(arrayCoach.size() - 1);
            String lastCoachID = lastCoach.getUserID();
            int temp = Integer.parseInt(lastCoachID.substring(1));
            newID = "C" + String.format("%03d", temp+1);
        }
        return newID;
    }
    
    public Coach validate(String coachID){
        ArrayList<Coach> arrayCoach = FileIO.readCoachFile("coach.txt");
        Coach valid = null;
        for (Coach tempCoach : arrayCoach){
            if (tempCoach.getUserID().equals(coachID) ){
                    valid = tempCoach;
                break;
            }
        }
        return valid;
    }
}