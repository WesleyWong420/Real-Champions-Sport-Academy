package SportsCenter;

import java.io.Serializable;
import java.util.ArrayList;
import javafx.collections.ObservableList;

public class Admin extends User implements Serializable {
    
    private String joinedYear;  
    
    public Admin(){
        
    }
    
    public Admin(String userID, String username, String gender, String contact, String email, String address , String joinedYear){
        super(userID, username, gender, contact, email, address);
        this.joinedYear = joinedYear;  
    }
    
    @Override // Override User getSchedule() Method - Dynamic Polymorphism
    public void getSchedule(ArrayList<Schedule> arraySchedule, ArrayList<ArrayList> control_list){
        
    }
    
    //Write, Edit Delete update to Txt file
    public void editStudent(ObservableList<Student> data){
        ArrayList<Student> arrayStudent = new ArrayList<Student>(data);  
        FileIO.writeStudent(arrayStudent, "student.txt");
    }
    
    //delete student
    public void deleteStudent(ObservableList<Student> data,String studentID){
        ArrayList<Student> arrayStudent = new ArrayList<Student>(data);
        // delete student login from login txt
        ArrayList<login> arrayLogin = FileIO.readLoginFile("login.txt");
        for (login tempLogin : arrayLogin){
           if (tempLogin.getUserID().equals(studentID)){
               arrayLogin.remove(tempLogin);
               break;
           }
        }
        
        FileIO.writeStudent(arrayStudent, "student.txt");
        FileIO.writeLogin(arrayLogin, "login.txt");
    }
    
        //search student
    public ArrayList<Student> searchStudent(String studentID){
        ArrayList<Student> searchedStudent = new ArrayList<Student>();
        ArrayList<Student> arrayStudent = FileIO.readStudentFile("student.txt");
        for (Student tempStudent : arrayStudent){
           if (tempStudent.getUserID().equals(studentID)){
               searchedStudent.add(tempStudent);
               break;
           }
        }
        
        return searchedStudent;
//        FileIO.writeStudent(arrayStudent, "student.txt");
//        FileIO.writeLogin(arrayLogin, "login.txt");
    }
    
    
    
}
