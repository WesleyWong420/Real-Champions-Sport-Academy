package SportsCenter;

import java.util.ArrayList;
import javafx.scene.control.Label;

public class Guest extends User{
    
    public Guest(){ 
    }
    
    public Guest(String userID, String username, String gender, String contact, String email, String address){ //remove this line later
        super(userID, username, gender, contact, email, address);
    }

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
    
    public String generateUserID(){
        ArrayList<Student> arrayStudent = FileIO.readStudentFile("student.txt");
        String newID = "S001";
        //Checking for last Student UserID
        if (arrayStudent.size() > 0){
            Student lastStudent = arrayStudent.get(arrayStudent.size() - 1);
            String lastStudentID = lastStudent.getUserID();
            int temp = Integer.parseInt(lastStudentID.substring(1));
            newID = "S" + String.format("%03d", temp+1);
        }
        return newID;
    }
    
    public void register(String selectedSportID,String password){
        ArrayList<String> lastFiveFeedbackID = new ArrayList<String>();
        ArrayList<Sport> arraySports = FileIO.readSportsFile("sport.txt");
        ArrayList<Student> arrayStudent = FileIO.readStudentFile("student.txt");
        
        //Initilizing 5 FiveFeedbackID for UI use.
        for (int i = 0; i < 5;i++){
            lastFiveFeedbackID.add("");
        }
             
        for (Sport tempSport : arraySports){
            if (tempSport.getSportID().equals(selectedSportID)){
                System.out.println("Sports found in register");
                Sport enroll =  tempSport;
                login tempLogin = new login(userID,password ,username, gender, contact, email, address,lastFiveFeedbackID , enroll);
                System.out.println(tempLogin.getPassword()+ tempLogin.getUserID());
                Student newStudent = tempLogin.getStudent();
                arrayStudent.add(newStudent);
                tempLogin.createLogin(tempLogin);
                FileIO.writeStudent(arrayStudent,"student.txt");
            }
         }
    }
}
