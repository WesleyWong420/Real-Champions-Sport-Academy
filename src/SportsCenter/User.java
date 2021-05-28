package SportsCenter;

import java.io.*;
import java.util.*;
import javafx.scene.control.Label;
import javafx.scene.image.*;
import java.io.Serializable;

public abstract class User implements Serializable{
    
    protected String userID;
    protected String username;
    protected String gender;
    protected String contact;
    protected String email;
    protected String address;
    
    public User(){}  // first non-serializable class (must have no-args empty constructor)
    
    public User(String userID, String username, String gender, String contact, String email, String address){ // Abstract class constructor for constructor chaining
        this.userID = userID;
        this.username = username;
        this.gender = gender;
        this.contact = contact;
        this.email = email;
        this.address = address;
    }
    
    public String getUserID() {
        return userID;
    }
    
    public void setUserID(String userID){
        this.userID = userID;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username){
        this.username = username;
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
    
    protected void getSport(ArrayList<Sport> arraySports, ArrayList<ArrayList> control_list){
        // Not abstract method because implementation is needed for Guest & Student as they share a partial of common codes
        // Will be called by Guest and Student using super.getSport()

        String img_dir = "src\\SportsCenter\\images\\"; // Image directory    
        ArrayList<ArrayList> lbl_list = new ArrayList<>(control_list.subList(0,4)); // Extract the subset of all Labels ArrayList
        ArrayList<ArrayList> img_list = new ArrayList<>(control_list.subList(4,5)); // Extract the subset of all ImageViews ArrayList
        
        int index1 = 0; 
        for (ArrayList<Label> controls : lbl_list) // Accessing outer ArrayList (ArrayList of different labels)
        {
            int index2 = 0;
            for(Label lbl : controls) // Accessing inner ArrayList (Actual labels holding attributes of Sports)
            {
                switch(index1){
                    case 0: // Sport Attribute 1 - Name
                        lbl.setText(arraySports.get(index2).getSportName());
                        break;
                    case 1: // Sport Attribute 2 - Duration
                        lbl.setText(Integer.toString(arraySports.get(index2).getDuration()) + " Minutes");
                        break;
                    case 2: // Sport Attribute 3 - Fee
                        lbl.setText("MYR " + Integer.toString(arraySports.get(index2).getFee()));
                        break;
                    case 3: // Sport Attribute 4 - Coach Name
                        lbl.setText(arraySports.get(index2).getCoachObject().getUsername());
                        break; 
                }
                index2++;
            }  
            index1++;
        }
        
        int index3 = 0;
        for (ArrayList<ImageView> controls  : img_list) // Accessing outer ArrayList (ArrayList of different ImageViews)
        {
            int index4 = 0;
            for (ImageView img : controls) // Accessing inner ArrayList (Actual ImageView components)
            {
                String img_src =  img_dir + arraySports.get(index4).getSportName() + ".png";
                try
                {
                    Image image = new Image(new FileInputStream(img_src));
                    img.setImage(image); // Set Sports Logo
                }
                catch (FileNotFoundException e){
                    System.out.println("Image not found!");
                }
                index4++;
            }
            index3++;
        }
    }
    
    protected abstract void getSchedule(ArrayList<Schedule> arraySchedule, ArrayList<ArrayList> control_list);
    // Will be implemented separately for Guest, Student & Coach
}
