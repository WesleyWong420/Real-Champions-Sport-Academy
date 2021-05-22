package SportsCenter;

import java.io.Serializable;

public class Sport implements Serializable{
    
    protected String sportID;
    private String sportName;
    private int duration;
    private int fee;
    private Coach coach;
    
    public Sport(String sportID, String sportName, int duration, int fee, Coach coach){  // Constructor overloading
        this.sportID = sportID;
        this.sportName = sportName;
        this.duration = duration;
        this.fee = fee;
        this.coach = coach;
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
    
    public Coach getCoachObject(){
        return coach;
    }
    
    public void setCoachObject(Coach coach){
        this.coach = coach;
    }
}
