package SportsCenter;

import java.util.ArrayList;

public class Guest extends User{

    @Override // Override User getSport() Method - Dynamic Polymorphism
    public void getSport(ArrayList<Sport> arraySports, ArrayList<ArrayList> control_list){
        super.getSport(arraySports, control_list);
    }
    
    @Override // Override User getSport() Method - Dynamic Polymorphism
    public void getSchedule(ArrayList<Schedule> arraySchedule, ArrayList<ArrayList> control_list){
        super.getSchedule(arraySchedule, control_list); 
    }
}
