/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SportsCenter;

/**
 *
 * @author Hamdhan
 */

public class login {

    private String userID;
    private String password;

    public login(String userID, String password) {
        this.userID = userID;
        this.password = password;
    }

    public String getuserID() {
        return userID;
    }
 
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public Boolean validate(String userID ,String password) {
        Boolean success = false;
        if (userID.equals("U1000") && password.equals("test")){
            success = true;
        }
        return success;
    }
    
}