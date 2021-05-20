package SportsCenter;

import java.io.FileInputStream;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import org.controlsfx.control.Rating;

public class feedbackController {
    
    @FXML
    private Button btnSubmit;
    @FXML
    private TextArea txtFeedback;
    @FXML
    private Label lblTitle, lblRating, lblFeedback, lblCancel;
    @FXML
    private Rating rating;
    
    public void initialize() {
    }
    
    @FXML
    private void pressSubmit() throws Exception {  // Thank you notification after feedback submission
        FileIO.pushNotification("Feedback Submitted!", "Thank you for your feedback.");
    }   
    
    @FXML
    private void pressCancel() throws Exception { // Back to Student Dashboard
        Parent root = FXMLLoader.load(getClass().getResource("student.fxml"));
        Stage window = (Stage) lblCancel.getScene().getWindow(); 
        window.setScene(new Scene(root, 800, 500));
        window.setTitle("Student Dashboard");
    }   
    
    /*
    public void pushHistory(History history){ // Pull History object from studentController.fxml
        if(history.getRating != null)  // Student has already submitted rating & feedback before
        {
            rating.setRating(history.getRating);
            txtFeedback.setText(history.getFeedback);
            btnSubmit.setDisabled(true);
        }
        else // No record of feedback submission
        {
            // Do Nothing (FXML is at Submit state by default)
        }
    }
    */
}