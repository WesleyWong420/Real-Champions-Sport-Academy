package SportsCenter;

import java.io.Serializable;

public class Schedule extends Sport implements Serializable{
    
    private String time;
    private String date;
    private String location;
    
    public Schedule(){}  // Parameterless constructor
    
    public Schedule(String sportID, String name, int duration, int fee, String coach, String time, String date, String location){  // Constructor overloading
        super(sportID, name, duration, fee, coach);
        this.time = time;
        this.date = date;
        this.location = location;
    }
    
    public String getTime() {
        return time;
    }
    
    public void setTime(String time){
        this.time = time;
    }
    
    public String getDate(){
        return date;
    }
    
    public void setDate(String date){
        this.date = date;
    }

    
    public String getLocation(){
        return location;
    }
    
    public void setLocation(String location){
        this.location = location;
    }
}
