
package SportsCenter;

import java.io.Serializable;

public class Feedback extends Coach implements Serializable{
    
    protected String feedbackID;
    private String comment;
    private int classRating;
    
    public Feedback(String userID, String username, String feedbackID, String comment, int classRating){  // Constructor overloading
        super(userID, username);
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
}
