package SportsCenter;

import java.io.Serializable;
import java.util.ArrayList;
import javafx.collections.ObservableList;

public class Admin extends User implements Serializable {
    
    private static final long serialVersionUID = 6195250771242558945L;
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
        //FileIO.writeStudent(arrayStudent, "student.txt");
        //FileIO.writeLogin(arrayLogin, "login.txt");
    }
    
    public void addCoach(ObservableList<Coach> data){
        ArrayList<Coach> arrayCoach = new ArrayList<Coach>(data);  
        ArrayList<login> arrayLogin = FileIO.readLoginFile("login.txt");
        Coach newCoach = arrayCoach.get(arrayCoach.size() - 1);
        login tempLogin2 = new login(newCoach.getUserID(),"ctest", newCoach.getUsername(), newCoach.getGender(), newCoach.getContact(), newCoach.getEmail(), newCoach.getAddress(), newCoach.getCoachRating(), newCoach.getHourlyRate(),newCoach.getSportCenterID(),newCoach.getSportCenterName());
        arrayLogin.add(tempLogin2);
        FileIO.writeCoach(arrayCoach, "coach.txt");
        FileIO.writeLogin(arrayLogin, "login.txt");
    }
    
    //Write, Edit Delete update to coach txt file
    public void editCoach(ObservableList<Coach> data){
        ArrayList<Coach> arrayCoach = new ArrayList<Coach>(data);  
        FileIO.writeCoach(arrayCoach, "coach.txt");
    }
    
    //delete coach
    public void deleteCoach(ObservableList<Coach> data,String coachID){
        ArrayList<Coach> arrayCoach = new ArrayList<Coach>(data);
        // delete Coach login from login txt
        ArrayList<login> arrayLogin = FileIO.readLoginFile("login.txt");
        for (login tempLogin : arrayLogin){
           if (tempLogin.getUserID().equals(coachID)){
               arrayLogin.remove(tempLogin);
               break;
           }
        }
        FileIO.writeCoach(arrayCoach, "coach.txt");
        FileIO.writeLogin(arrayLogin, "login.txt");
    }
    
    //search student
    public ArrayList<Coach> searchCoach(String searchString,String searchCol){
        ArrayList<Coach> searchedCoach = new ArrayList<Coach>();
        ArrayList<Coach> arrayCoach = FileIO.readCoachFile("coach.txt");
        if (searchCol.equals("coachID")){
            for (Coach tempCoach : arrayCoach){
               if (tempCoach.getUserID().equals(searchString)){
                   searchedCoach.add(tempCoach);
                   break;
               }
            }
        }else if(searchCol.equals("rating")){
            for (Coach tempCoach : arrayCoach){
               if (tempCoach.getCoachRating() == Double.parseDouble(searchString)){
                   searchedCoach.add(tempCoach);
            }
        }
        }
        
        return searchedCoach;
    }
    
    public void addSport(ObservableList<Sport> data){
        ArrayList<Sport> arraySport = new ArrayList<Sport>(data);  
        FileIO.writeSport(arraySport, "Sport.txt");
    }
    
    public void deleteSport(ObservableList<Sport> data,String sportID){
        ArrayList<Sport> arraySport = new ArrayList<Sport>(data);
        ArrayList<Schedule> arraySchedule = FileIO.readScheduleFile("schedule.txt");
        for (Schedule tempSchedule : arraySchedule){
        
            if (tempSchedule.getSportID().equals(sportID)){
                arraySchedule.remove(tempSchedule);
            }
        
        }
        FileIO.writeSchedule(arraySchedule,"Schedule.txt");
        FileIO.writeSport(arraySport, "Sport.txt");
    }
    
    public void editSport(ObservableList<Sport> data){
        ArrayList<Sport> arraySport = new ArrayList<Sport>(data);  
        FileIO.writeSport(arraySport, "Sport.txt");
    }
    
    //search sport
    public ArrayList<Sport> searchSport(String sportID){
        ArrayList<Sport> searchedSport = new ArrayList<Sport>();
        ArrayList<Sport> arraySport = FileIO.readSportsFile("sport.txt");
        for (Sport tempSport : arraySport){
           if (tempSport.getSportID().equals(sportID)){
               searchedSport.add(tempSport);
               break;
           }
        }
        
        return searchedSport;
    }

    
    public void addSchedule(ObservableList<Schedule> data){
        ArrayList<Schedule> arraySchedule = new ArrayList<Schedule>(data);  
        FileIO.writeSchedule(arraySchedule, "Schedule.txt");
    }
    
    public void deleteSchedule(ObservableList<Schedule> data){
        ArrayList<Schedule> arraySchedule = new ArrayList<Schedule>(data);  
        FileIO.writeSchedule(arraySchedule , "Schedule.txt");
    }
    
    public void editSchedule(ObservableList<Schedule> data){
        ArrayList<Schedule> arraySchedule = new ArrayList<Schedule>(data);  
        FileIO.writeSchedule(arraySchedule , "Schedule.txt");
    }
    
    //search schedule
    public ArrayList<Schedule> searchSchedule(String sportID){
        ArrayList<Schedule> searchedSchedule = new ArrayList<Schedule>();
        ArrayList<Schedule> arraySchedule = FileIO.readScheduleFile("schedule.txt");
        for (Schedule tempSchedule : arraySchedule){
           if (tempSchedule.getSportID().equals(sportID)){
               searchedSchedule.add(tempSchedule);
           }
        }
        
        return searchedSchedule;
        //FileIO.writeStudent(arrayStudent, "student.txt");
        //FileIO.writeLogin(arrayLogin, "login.txt");
    }    
}
