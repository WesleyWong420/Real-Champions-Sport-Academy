package SportsCenter;

import java.io.Serializable;
import java.util.ArrayList;

public class Admin extends User implements Serializable {
    
    private String joinedYear;  
    
    public Admin(String userID, String username, String gender, String contact, String email, String address , String joinedYear){
        super(userID, username, gender, contact, email, address);
        this.joinedYear = joinedYear;  
    }
    
    @Override // Override User getSchedule() Method - Dynamic Polymorphism
    public void getSchedule(ArrayList<Schedule> arraySchedule, ArrayList<ArrayList> control_list){
    }
}
