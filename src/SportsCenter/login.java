package SportsCenter;

import java.io.Serializable;
import java.util.ArrayList;

public class login implements Serializable{
    
    private static final long serialVersionUID = -6778737263813827715L;
    private String userID;
    private String password;
    private Student newStudent;
    private Admin newAdmin;
    private Coach newCoach;
    
    //Login creation for student
    //Composition Association
    public login(String userID, String password, String username, String gender, String contact, String email, String address, ArrayList<String> lastFiveFeedbackID, Sport sport) {
        this.userID = userID;
        this.password = password;
        newStudent = new Student(userID,username,gender,contact,email, address,lastFiveFeedbackID, sport);
    }
    
    //Login creation for admin
    //Composition Association
    public login(String userID, String password, String username, String gender, String contact, String email, String address,String year) {
        this.userID = userID;
        this.password = password;
        newAdmin = new Admin(userID,username,gender,contact,email, address,year);
    }
    
    //Login creation for Coach
    //Composition Association
    public login(String userID, String password, String username, String gender, String contact, String email, String address, double coachRating, int hourlyRate,String sportCenterID, String sportCenterName) {
        this.userID = userID;
        this.password = password;
        newCoach = new Coach(userID,username, gender, contact, email, address, coachRating, hourlyRate,sportCenterID,sportCenterName);
    }
    
    //without user for login access only
    public login(String userID, String password) {
        this.userID = userID;
        this.password = password;
    }

    public String getUserID() {
        return userID;
    }
 
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public Student getStudentObject() {
        return newStudent;
    }
    
    public void setStudentObject(Student newStudent){
        this.newStudent = newStudent;
    }
    
    public Admin getAdminObject() {
        return newAdmin;
    }
    
    public void setAdminObject(Admin newAdmin){
        this.newAdmin = newAdmin;
    }
    
    public Coach getCoachObject() {
        return newCoach;
    }
    
    public void setCoachObject(Coach newCoach){
        this.newCoach = newCoach;
    }
    
    //Check if login is valid, If Pass Login Object
    public login validate(String userID ,String password) {
        login validLogin = null;
        ArrayList<login> arrayLogin = FileIO.readLoginFile("login.txt");
        for (login tempLogin : arrayLogin){
            if (tempLogin.getUserID().equals(userID) && tempLogin.getPassword().equals(password) ){
                validLogin = tempLogin;
                break;
            }
        }
        
        return validLogin;
    }
    
    //Identify user type by first character "S" -Student "A" - Admin
    public char getAccess(){
        char accessCode = userID.charAt(0);
        return accessCode;
    }
    
    // creating and writing login to file
    public void createLogin(login newlogin){
        
        ArrayList<login> arrayLogin = FileIO.readLoginFile("login.txt");
        arrayLogin.add(newlogin);
        FileIO.writeLogin(arrayLogin, "login.txt");
    }
}