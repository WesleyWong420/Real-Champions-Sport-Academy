package SportsCenter;

import java.io.Serializable;

public class Sport implements Serializable{
    
    protected String sportID;
    private String name;
    private int duration;
    private int fee;
    private String coach;
    
    public Sport(){}  // Parameterless constructor
    
    public Sport(String sportID, String name, int duration, int fee, String coach){  // Constructor overloading
        this.sportID = sportID;
        this.name = name;
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
    
    public String getName() {
        return name;
    }
    
    public void setName(String name){
        this.name = name;
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
    
    public String getCoach(){
        return coach;
    }
    
    public void setCoach(String coach){
        this.coach = coach;
    }
}
