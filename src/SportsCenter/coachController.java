package SportsCenter;

import javafx.scene.input.MouseEvent;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class coachController {
    
    @FXML
    private Button btnLogout, btnSave, btnEdit;
    @FXML
    private TextField txtCoachID, txtUsername, txtGender, txtEmail, txtMobileNo, txtAddress, txtSport, txtNextClass, txtRating;
    @FXML
    private Label lblCoachID, lblUsername, lblGender, lblEmail, lblMobileNo, lblAddress, lblSport, lblNextClass, lblRating;
    
    public void initialize() {
    }
    
    @FXML
    private void pressLogout() throws Exception { // Back to Home Page
        Parent root = FXMLLoader.load(getClass().getResource("welcome.fxml"));
        Stage window = (Stage) btnLogout.getScene().getWindow(); 
        window.setScene(new Scene(root, 800, 480));
        window.setTitle("Real Champions Sports Academy");
    }
    
    @FXML
    private void pressSave() throws Exception {
        btnSave.setDisable(true);
        btnEdit.setDisable(false);
        txtCoachID.setDisable(true); // Just for visual, CoachID cannot be modified
        txtGender.setDisable(true); // Just for visual, Gender cannot be modified
        txtUsername.setDisable(true);
        txtEmail.setDisable(true);
        txtMobileNo.setDisable(true);
        txtAddress.setDisable(true);
        txtSport.setDisable(true); // Just for visual, Coach's Sport cannot be modified
        txtNextClass.setDisable(true); // Just for visual, next class session cannot be modified
        txtRating.setDisable(true); // Just for visual, Coach's Rating cannot be modified
    }
    
    @FXML
    private void pressEdit() throws Exception {
        btnEdit.setDisable(true);
        btnSave.setDisable(false);
        txtCoachID.setDisable(false); // Just for visual, CoachID cannot be modified
        txtGender.setDisable(false); // Just for visual, Gender cannot be modified
        txtUsername.setDisable(false);
        txtEmail.setDisable(false);
        txtMobileNo.setDisable(false);
        txtAddress.setDisable(false);
        txtSport.setDisable(false); // Just for visual, Coach's Sport cannot be modified
        txtNextClass.setDisable(false); // Just for visual, next class session cannot be modified
        txtRating.setDisable(false); // Just for visual, Coach's Rating cannot be modified
    }
    
    @FXML
    private void getFocus(MouseEvent event) throws Exception{ // Text Field Get Focus
        ArrayList<TextField> txt_list = new ArrayList<>();
        txt_list.add(txtCoachID);
        txt_list.add(txtUsername);
        txt_list.add(txtGender);
        txt_list.add(txtEmail);
        txt_list.add(txtMobileNo);
        txt_list.add(txtAddress);
        txt_list.add(txtSport);
        txt_list.add(txtNextClass);
        txt_list.add(txtRating);
        ArrayList<Label> lbl_list = new ArrayList<>();
        lbl_list.add(lblCoachID);
        lbl_list.add(lblUsername);
        lbl_list.add(lblGender);
        lbl_list.add(lblEmail);
        lbl_list.add(lblMobileNo);
        lbl_list.add(lblAddress);
        lbl_list.add(lblSport);
        lbl_list.add(lblNextClass);
        lbl_list.add(lblRating);
        
        TextField txt = (TextField) event.getSource(); // Type Casting
        int index = txt_list.indexOf(txt); // Search for the TextField's index 
        lbl_list.get(index).setVisible(true); // Using the index number to access respective Label to float
    }
    
    @FXML
    private void loseFocus(MouseEvent event) throws Exception{ // Text Field Lose Focus
        ArrayList<TextField> txt_list = new ArrayList<>();
        txt_list.add(txtCoachID);
        txt_list.add(txtUsername);
        txt_list.add(txtGender);
        txt_list.add(txtEmail);
        txt_list.add(txtMobileNo);
        txt_list.add(txtAddress);
        txt_list.add(txtSport);
        txt_list.add(txtNextClass);
        txt_list.add(txtRating);
        ArrayList<Label> lbl_list = new ArrayList<>();
        lbl_list.add(lblCoachID);
        lbl_list.add(lblUsername);
        lbl_list.add(lblGender);
        lbl_list.add(lblEmail);
        lbl_list.add(lblMobileNo);
        lbl_list.add(lblAddress);
        lbl_list.add(lblSport);
        lbl_list.add(lblNextClass);
        lbl_list.add(lblRating);
        
        TextField txt = (TextField) event.getSource();  // Type Casting
        int index = txt_list.indexOf(txt); // Search for the TextField's index 
        if(txt.getText().isEmpty()) 
        {
            lbl_list.get(index).setVisible(false); // Using the index number to access respective Label to unfloat
        }
        else
        {
            lbl_list.get(index).setVisible(true); // Using the index number to access respective Label to float
        }
        btnLogout.requestFocus(); // Transfer focus to other control
    }
    
    private void getSelfRecord(){
    }
    
    private void setSelfRecord(){
    }
}

        
    
