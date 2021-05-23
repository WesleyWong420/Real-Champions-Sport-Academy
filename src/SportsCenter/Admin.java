/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SportsCenter;

import java.io.Serializable;
import java.util.ArrayList;
import javafx.scene.control.TextField;

/**
 *
 * @author Hamdhan
 */
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
