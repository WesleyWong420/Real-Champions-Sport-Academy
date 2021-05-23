package SportsCenter;

import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.controlsfx.control.Rating;

public class feedbackController {
    
    @FXML
    public Button btnSubmit;
    @FXML
    public TextArea txtFeedback;
    @FXML
    public Label lblTitle, lblRating, lblFeedback, lblCancel;
    @FXML
    public Rating rating;
         
    Student student;
    int history_index = -1;
            
    public void initialize() {
    }
    
    @FXML
    private void pressSubmit() throws Exception {  
        if(!txtFeedback.getText().equals("") && rating.getRating() != 0) // Make sure all fields are filled
        {
           FileIO.pushNotification("Feedback Submitted!", "Thank you for your feedback.");
           btnSubmit.setDisable(true);
           rating.setDisable(true);
           txtFeedback.setDisable(true); 
           
           ArrayList<Feedback> arrayFeedback = FileIO.readFeedbackFile("feedback.txt");
           String historyID;
           int next_id = arrayFeedback.size() + 1;
           if(next_id >= 10) // FeedbackID Generator
           {
               historyID = "F0" + next_id; // FeedbackID in tenth place
           }
           else if(next_id >= 100)
           {
               historyID = "F" + next_id; // FeedbackID in hundredth place
           }
           else
           {
               historyID = "F00" + next_id; // FeedbackID in ones place
           }
            
            ArrayList<Sport> arraySports = FileIO.readSportsFile("sport.txt");
            Coach coach = arraySports.get(history_index).getCoachObject();
            Feedback feedback = new Feedback(coach.getUserID(), coach.getUsername(), historyID, txtFeedback.getText(), (int)rating.getRating());
            arrayFeedback.add(feedback); // append to arraylist
            FileIO.writeFeedback(arrayFeedback, "feedback.txt"); // then write to file

            ArrayList <String> feedback_id_list = student.getLastFiveFeedbackID();
            feedback_id_list.set(history_index, historyID);
            student.setLastFiveFeedbackID(feedback_id_list);
            
            ArrayList<Student> arrayStudent = FileIO.readStudentFile("student.txt");
            for (Student sdt: arrayStudent) // overwrite the Student
            {
                if(student.getUserID().equals(sdt.getUserID()))
                {
                    sdt = student;
                    break;
                }
            }
            FileIO.writeStudent(arrayStudent, "student.txt"); // then write to file
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Empty Fields!");
            alert.setContentText("One or more details is incomplete");
            alert.showAndWait();
        }
    }   
    
    @FXML
    private void pressCancel() throws Exception { // Back to Student Dashboard
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("student.fxml"));
        Parent root = (Parent) loader.load();
        Stage stage = new Stage();
        stage.setTitle("Student Dashboard");
        stage.setScene(new Scene(root, 800, 500));
        stage.show();
        
        Stage current_stage = (Stage) lblCancel.getScene().getWindow();
        current_stage.close();   
    }   
    
    public void pushFeedback(String feedback_id, int index, Student stdnt){ // Pull Feedback ID from studentController.fxml
        if(!feedback_id.equals(""))  // Student has already submitted rating & feedback before
        {
            ArrayList<Feedback> arrayFeedback = FileIO.readFeedbackFile("feedback.txt");
            for(Feedback fdb : arrayFeedback)
            {
                if(fdb.getFeedbackID().equals(feedback_id))
                {
                    rating.setRating(fdb.getClassRating());
                    txtFeedback.setText(fdb.getComment());
                    break;
                }
            }
            
            btnSubmit.setDisable(true);
            rating.setDisable(true);
            txtFeedback.setDisable(true);
        }
        else // No record of feedback submission
        {
            // Do Nothing (FXML is at Submit state by default)
        }
        
        history_index = index; // Overwriting the global variable so that is can be used in submitFeedback()
        student = stdnt; // Overwriting the global variable so that is can be used in submitFeedback()
    }
}