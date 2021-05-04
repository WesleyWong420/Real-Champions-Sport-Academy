package SportsCenter;

import java.io.Serializable;

public class Sport implements Serializable{
    
    private String name;
    private int duration;
    private int fee;
    private String coach;
    
    public Sport(){}  //parameterless constructor
    
    public Sport(String name, int duration, int fee, String coach){  //constructor overloading
        this.name = name;
        this.duration = duration;
        this.fee = fee;
        this.coach = coach;
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
