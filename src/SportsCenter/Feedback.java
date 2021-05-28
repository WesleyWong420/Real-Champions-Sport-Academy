
package SportsCenter;

import java.io.Serializable;
import java.util.ArrayList;

public class Feedback extends Coach implements Serializable{
    
    protected String feedbackID;
    private String comment;
    private int classRating;
    
    public Feedback(String userID, String username, String feedbackID, String comment, int classRating){ 
        super(userID, username); // Call the overloaded constructor of Coach
        this.feedbackID = feedbackID;
        this.comment = comment;
        this.classRating = classRating;
    }
    
    public String getFeedbackID() {
        return feedbackID;
    }
    
    public void setFeedbackID(String feedbackID){
        this.feedbackID = feedbackID;
    }
    
    public String getComment() {
        return comment;
    }
    
    public void setComment(String comment){
        this.comment = comment;
    }
    
    public int getClassRating() {
        return classRating;
    }
    
    public void setClassRating(int classRating){
        this.classRating = classRating;
    }
    
    public Coach calculateRating(Coach coach){
        
        ArrayList<Feedback> arrayFeedback = FileIO.readFeedbackFile("feedback.txt");
        double count = 0;
        double rate = 0;
        for(Feedback fdb : arrayFeedback)
        {
            if(fdb.getUsername().equals(coach.getUsername()))
            {
                rate = rate + fdb.getClassRating();
                count++;
            }
        }
        
        if(count == 0)
        {
            coach.setCoachRating(0);
        }
        else
        {
            double tempRating = rate / count;
            coach.setCoachRating(round(tempRating, 2));
        }
        
        return coach;
    }
    
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}
