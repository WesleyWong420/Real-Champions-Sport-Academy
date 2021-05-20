package SportsCenter;

import java.io.*;
import java.util.*;
import javafx.scene.control.Label;
import javafx.scene.image.*;

public abstract class User {
    
    protected String userID;
    
    // No constructor for abstract class
    
    protected void getSport(ArrayList<Sport> arraySports, ArrayList<ArrayList> control_list){
        
        String img_dir = "src\\SportsCenter\\images\\"; // Image directory    
        ArrayList<ArrayList> lbl_list = new ArrayList<>(control_list.subList(0,4)); 
        ArrayList<ArrayList> img_list = new ArrayList<>(control_list.subList(4,5));
        
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
                        lbl.setText(arraySports.get(index2).getCoachObject().getName());
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
    // Not abstract method because implementation is needed for Guest & Student as they share a partial of common codes
    // Will be called by Guest and Student using super.getSport() // Will be implemented separately by Coach
    
    protected abstract void getSchedule(ArrayList<Schedule> arraySchedule, ArrayList<ArrayList> control_list);
    // Will be implemented separately for Guest, Student & Coach
}
