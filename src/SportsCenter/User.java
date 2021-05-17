package SportsCenter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class User {
    
    protected String userID;
    
    // No constructor for abstract class
    
    public void getSport(){}
    // Method overloading (Coach)
    public void getSchedule(){}
    // Method overloading (Coach)
    
    public void getSport(ArrayList<Sport> arraySports, ArrayList<ArrayList> control_list){
        String img_dir = "src\\SportsCenter\\images\\"; // Image directory    
        ArrayList<ArrayList> lbl_list = new ArrayList<ArrayList>(control_list.subList(0,4)); 
        ArrayList<ArrayList> img_list = new ArrayList<ArrayList>(control_list.subList(4,5));
        
        int index1 = 0; 
        for (ArrayList<Label> controls : lbl_list) // Accessing outer ArrayList (ArrayList of different labels)
        {
            int index2 = 0;
            for(Label lbl : controls) // Accessing inner ArrayList (Actual labels holding attributes of Sports)
            {
                switch(index1){
                    case 0: // Sport Attribute 1 - Name
                        lbl.setText(arraySports.get(index2).getName());
                        break;
                    case 1: // Sport Attribute 2 - Duration
                        lbl.setText(Integer.toString(arraySports.get(index2).getDuration()) + " Minutes");
                        break;
                    case 2: // Sport Attribute 3 - Fee
                        lbl.setText("MYR " + Integer.toString(arraySports.get(index2).getFee()));
                        break;
                    case 3: // Sport Attribute 4 - Coach Name
                        lbl.setText(arraySports.get(index2).getCoach());
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
                String img_src =  img_dir + arraySports.get(index4).getName() + ".png";
                try
                {
                    Image image = new Image(new FileInputStream(img_src));
                    img.setImage(image); // Set Sports Logo
                }
                catch (FileNotFoundException e){
                    System.out.println("File not found!");
                }
                index4++;
            }
            index3++;
        }
    }
    
    public void getSchedule(ArrayList<Schedule> arraySchedule, ArrayList<ArrayList> control_list){
        ArrayList<ArrayList> lbl_list = new ArrayList<ArrayList>(control_list.subList(0,5));
        
        int index1 = 0; 
        for (ArrayList<Label> controls : lbl_list) // Accessing outer ArrayList (ArrayList of different labels)
        {
            int index2 = 0;
            for(Label lbl : controls) // Accessing inner ArrayList (Actual labels holding attributes of Schedules)
            {
                switch(index1){
                    case 0: // Schedule Attribute 1 - Name
                        lbl.setText(arraySchedule.get(index2).getName());
                        break;
                    case 1: // Schedule Attribute 2 - Time
                        lbl.setText(lbl.getText().substring(0,3) + arraySchedule.get(index2).getTime());
                        break;
                    case 2: // Schedule Attribute 3 - Date
                        lbl.setText(lbl.getText().substring(0,3) + arraySchedule.get(index2).getDate());
                        break;
                    case 3: // Schedule Attribute 4 - Location
                        lbl.setText(lbl.getText().substring(0,3) + arraySchedule.get(index2).getLocation());
                        break;
                    case 4: // Schedule Attribute 5 - Coach Name
                        lbl.setText(lbl.getText().substring(0,3) + arraySchedule.get(index2).getCoach());
                        break;
                }
                index2++;
            }  
            index1++;
        }
    }
}
