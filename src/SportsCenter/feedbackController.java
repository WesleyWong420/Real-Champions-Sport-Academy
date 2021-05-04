package SportsCenter;

import java.io.FileInputStream;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
        ImageView icon = new ImageView(new Image(new FileInputStream("src\\SportsCenter\\images\\success.png")));
        icon.setFitWidth(32);
	icon.setFitHeight(32);
        Notifications notifier = Notifications.create()
                .title("Feedback Submitted!")
                .text("Thank you for your feedback.")
                .graphic(icon)
                .hideAfter(Duration.seconds(3))
                .position(Pos.BOTTOM_RIGHT);
        notifier.show();
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