package SportsCenter;

import java.util.ArrayList;
import javafx.scene.control.Label;

public class Guest extends User{

    @Override // Override User getSport() Method - Dynamic Polymorphism
    public void getSport(ArrayList<Sport> arraySports, ArrayList<ArrayList> control_list){
        super.getSport(arraySports, control_list);
    }
    
    @Override // Override User getSport() Method - Dynamic Polymorphism
    public void getSchedule(ArrayList<Schedule> arraySchedule, ArrayList<ArrayList> control_list){
        ArrayList<ArrayList> lbl_list = new ArrayList<>(control_list.subList(0,5));
        
        int index1 = 0; 
        for (ArrayList<Label> controls : lbl_list) // Accessing outer ArrayList (ArrayList of different labels)
        {
            int index2 = 0;
            for(Label lbl : controls) // Accessing inner ArrayList (Actual labels holding attributes of Schedules)
            {
                switch(index1){
                    case 0: // Schedule Attribute 1 - Name
                        lbl.setText(arraySchedule.get(index2).getSportName());
                        break;
                    case 1: // Schedule Attribute 2 - Time
                        lbl.setText("🕒 " + arraySchedule.get(index2).getTime());
                        break;
                    case 2: // Schedule Attribute 3 - Date
                        lbl.setText("📅 " + arraySchedule.get(index2).getDate());
                        break;
                    case 3: // Schedule Attribute 4 - Location
                        lbl.setText("📍 " + arraySchedule.get(index2).getLocation());
                        break;
                    case 4: // Schedule Attribute 5 - Coach Name
                        lbl.setText("🎓 " + arraySchedule.get(index2).getCoachObject().getUsername());
                        break;
                }
                index2++;
            }  
            index1++;
        }
    }
}
