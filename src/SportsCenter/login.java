/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SportsCenter;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Hamdhan
 */

public class login implements Serializable{

    private String userID;
    private String password;
    private Student newStudent;
    private Admin newAdmin;
    
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
    
    public Student getStudent() {
        return newStudent;
    }
    
    public Admin getAdmin() {
        return newAdmin;
    }
        
    public void setPassword(String password) {
        this.password = password;
    }
    
    public Boolean validate(String userID ,String password) {
        Boolean success = false;
        ArrayList<login> arrayLogin = FileIO.readLoginFile("login.txt");
        for (login tempLogin : arrayLogin){
            if (tempLogin.getUserID().equals(userID) && tempLogin.getPassword().equals(password) ){
                success = true;
                break;
            }
        }
        
        return success;
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