package SportsCenter;

import java.io.Serializable;
import java.util.ArrayList;
import javafx.scene.control.TextField;

public class Coach extends User implements Serializable{
    
    private String name;
    private String gender;
    private String contact;
    private String email;
    private String address;
    private float rating;
    private int hourlyRate;
    
    public Coach(String name){ // Temporarily
        this.name = name;
    }
    
    public Coach(String userID, String name, String gender, String contact, String email, String address, float rating, int hourlyRate){
        this.userID = userID;
        this.name = name;
        this.gender = gender;
        this.contact = contact;
        this.email = email;
        this.address = address;
        this.rating = rating;
        this.hourlyRate = hourlyRate;
    }
    
    public String getUserID() {
        return userID;
    }
    
    public void setUserID(String userID){
        this.userID = userID;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getGender() {
        return gender;
    }
    
    public void setGender(String gender){
        this.gender = gender;
    }
    
    public String getContact() {
        return contact;
    }
    
    public void setContact(String contact){
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
    
    public float getRating() {
        return rating;
    }
    
    public void setRating(float rating){
        this.rating = rating;
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
            if(sport.getCoachObject().getName().equals(name))
            {
                txt.setText(sport.getName());
            }
        }
    }
    
    @Override 
    public void getSchedule(ArrayList<Schedule> arraySchedule, ArrayList<ArrayList> control_list){
        
        TextField txt = (TextField) control_list.get(0).get(0);
        
        for(Schedule session : arraySchedule)
        {
            if(session.getCoachObject().getName().equals(name))
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
                    txt.setText(name);
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
                    txt.setText(Float.toString(rating) + "/5.0");
                    break;
            }
            index++;
        }
    }
    
    /*
    public void getFeedback
    public void setSelfRecord(){}
    */
}