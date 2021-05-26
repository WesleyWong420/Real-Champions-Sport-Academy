package SportsCenter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class Sport implements Serializable{
    
    private static final long serialVersionUID = -2796446601161078838L;
    protected String sportID;
    private String sportName;
    private int duration;
    private int fee;
    private Coach coach;
    private String status;
    private String coachID; //need to populate data for table
    
    public Sport(){}
    
    public Sport(String sportID, String sportName, int duration, int fee, String status, Coach coach){  // Constructor overloading
        this.sportID = sportID;
        this.sportName = sportName;
        this.duration = duration;
        this.fee = fee;
        this.status = status;
        this.coach = coach;
        coachID = coach.getUserID(); //need to populate data for table
    }
    
    public String getSportID() {
        return sportID;
    }
    
    public void setSportID(String sportID){
        this.sportID = sportID;
    }
    
    public String getSportName() {
        return sportName;
    }
    
    public void setSportName(String sportName){
        this.sportName = sportName;
    }
    
    public int getDuration(){
        return duration;
    }
    
    public void setDuration(int duration){
        this.duration = duration;
    }
    
    public int getFee(){
        return fee;
    }
    
    public void setFee(int fee){
        this.fee = fee;
    }
    
    public String getStatus(){
        return status;
    }
    
    public void setStatus(String status){
        this.status = status;
    }
    
    public Coach getCoachObject(){
        return coach;
    }
    
    public void setCoachObject(Coach coach){
        this.coach = coach;
    }
    
    //TO POPULATE TABLE COL
    public String getCoachID(){
        return coach.getUserID();
    }
    
    public String generateSportID(){
        ArrayList<Sport> arraySport = FileIO.readSportsFile("sport.txt");
        ArrayList<String> arraySportID =new ArrayList<String>();
        String newID = "SP001";
        //Checking for last Student UserID
        if (arraySport.size() > 0){
            for (Sport tempSport : arraySport){
                arraySportID.add(tempSport.getSportID());
            }
            Collections.sort(arraySportID); // sort to get last ID
            String lastSportID = arraySportID.get(arraySport.size() - 1);
            int temp = Integer.parseInt(lastSportID.substring(2));
            newID = "SP" + String.format("%03d", temp+1);
        }
        
        return newID;
    }
    
    public Sport validate(String sportID){
        // Validate if sport is in text file
        ArrayList<Sport> arraySport = FileIO.readSportsFile("sport.txt");
        Sport valid = null;
        for (Sport tempSport : arraySport){
            if (tempSport.getSportID().equals(sportID) ){
                    valid = tempSport;
                break;
            }
        }
        
        return valid;
    }
}
