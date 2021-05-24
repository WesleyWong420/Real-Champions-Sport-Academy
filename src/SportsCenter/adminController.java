/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SportsCenter;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Hamdhan
 */
public class adminController {

    @FXML 
    private TableView<Student> student_table;
    @FXML
    private TableView<Coach> coach_table;
    
    @FXML 
    private TableColumn studentIDCol,nameSCol,genderSCol,emailSCol,contactSCol,addressSCol,currentSportCol;
    @FXML 
    private TableColumn coachIDCol,nameCCol,genderCCol,emailCCol,contactCCol,addressCCol,ratingCol,hourlyRateCol;
//    @FXML 
//    private TableColumn studentIDCol,nameSCol,genderSCol,emailSCol,contactSCol,addressSCol,currentSportCol;
//    @FXML 
//    private TableColumn studentIDCol,nameSCol,genderSCol,emailSCol,contactSCol,addressSCol,currentSportCol;

        
    @FXML
    private Button deleteSBtn, clearSBtn, searchSBtn,editSBtn;
    @FXML
    private Button addCBtn, deleteCBtn, clearCBtn, searchCBtn,editCBtn;
    @FXML
    private Button addSPBtn, deleteSPBtn, clearSPBtn, searchSPBtn,editSPBtn;
    @FXML
    private Button addSCBtn, deleteSCBtn, clearSCBtn, searchSCBtn,editSCBtn;
    @FXML
    private Button logoutBtn;
    
    @FXML
    private TextField studentIDTxt, nameSTxt, genderSTxt, emailSTxt, contactSTxt, addressSTxt;
    @FXML
    private TextField coachIDTxt, nameCTxt, genderCTxt, emailCTxt, contactCTxt, addressCTxt, ratingCTxt,hourlyCTxt;
//    @FXML
//    private TextField studentIDTxt, nameSTxt, genderSTxt, emailSTxt, contactSTxt, addressSTxt;
//    @FXML
//    private TextField studentIDTxt, nameSTxt, genderSTxt, emailSTxt, contactSTxt, addressSTxt;
    
    private Admin admin = new Admin();
    
    private ArrayList<Student> arrayStudent = FileIO.readStudentFile("student.txt");
    private ArrayList<Coach> arrayCoach = FileIO.readCoachFile("coach.txt");
    
    public void initialize() {
        
        //Adding student data to table
        ObservableList<Student> data = FXCollections.observableArrayList(arrayStudent);
        studentIDCol.setCellValueFactory(new PropertyValueFactory("userID"));
        nameSCol.setCellValueFactory(new PropertyValueFactory("username"));
        genderSCol.setCellValueFactory(new PropertyValueFactory("gender"));
        emailSCol.setCellValueFactory(new PropertyValueFactory("email"));
        contactSCol.setCellValueFactory(new PropertyValueFactory("contact"));
        addressSCol.setCellValueFactory(new PropertyValueFactory("address"));
        student_table.setItems(data);
        
        //Adding coachs to table
        ObservableList<Coach> coachData = FXCollections.observableArrayList(arrayCoach);
        coachIDCol.setCellValueFactory(new PropertyValueFactory("userID"));
        nameCCol.setCellValueFactory(new PropertyValueFactory("username"));
        genderCCol.setCellValueFactory(new PropertyValueFactory("gender"));
        emailCCol.setCellValueFactory(new PropertyValueFactory("email"));
        contactCCol.setCellValueFactory(new PropertyValueFactory("contact"));
        addressCCol.setCellValueFactory(new PropertyValueFactory("address"));
        ratingCol.setCellValueFactory(new PropertyValueFactory("coachRating"));
        hourlyRateCol.setCellValueFactory(new PropertyValueFactory("hourlyRate"));
        coach_table.setItems(coachData);
    }
    
//    @FXML
//    private void addStudent(ActionEvent event) throws Exception {
//        Parent root = FXMLLoader.load(getClass().getResource("welcome_1.fxml"));
//        Stage window2 = new Stage();
//        Scene secondScene = new Scene(root, 400, 400);
//        window2.setScene(secondScene);
//        window2.setTitle("Add Student");
//        window2.show();
//    }
    @FXML
    private void getStudent(MouseEvent event) throws Exception {
        ObservableList<Student> data = student_table.getItems();
        Student selected = student_table.getSelectionModel().getSelectedItem();
        System.out.println(selected);
        if (selected != null){
            studentIDTxt.setText(selected.getUserID());
            nameSTxt.setText(selected.getUsername());
            genderSTxt.setText(selected.getGender());
            emailSTxt.setText(selected.getEmail());
            contactSTxt.setText(String.valueOf(selected.getContact()));
            addressSTxt.setText(selected.getAddress());
        }
    }
    
    @FXML
    private void addStudent(ActionEvent event) throws Exception {
        ObservableList<Student> data = student_table.getItems();
        ArrayList<Student> arrayStudent = new ArrayList<Student>(data);
        FileIO.writeStudent(arrayStudent, "student.txt");
        //data.add(new Student(firstNameSTxt.getText(), lastNameSTxt.getText(), genderSTxt.getText(), emailSTxt.getText(),Integer.valueOf(contactSTxt.getText()), addressSTxt.getText()));
         studentIDTxt.clear();
         nameSTxt.clear();
         genderSTxt.clear();
         emailSTxt.clear();
         contactSTxt.clear();
         addressSTxt.clear();
    }
    
    @FXML
    private void deleteStudent(ActionEvent event) throws Exception {
        Student selected = student_table.getSelectionModel().getSelectedItem();
        if (selected != null){
            student_table.getItems().remove(selected);
            ObservableList<Student> data = student_table.getItems();
            admin.deleteStudent(data,selected.getUserID());
            
            // clear text boxes
            student_table.getSelectionModel().clearSelection();
            studentIDTxt.clear();
            nameSTxt.clear();
            genderSTxt.clear();
            emailSTxt.clear();
            contactSTxt.clear();
            addressSTxt.clear();
        }
    }
    
    @FXML
    private void editStudent(ActionEvent event) throws Exception {
        ObservableList<Student> data = student_table.getItems();
        Student selected = student_table.getSelectionModel().getSelectedItem();
        if (selected != null){
            if((!"".equals(nameSTxt.getText()))&& (!"".equals(genderSTxt.getText())) && (!"".equals(emailSTxt.getText())) && (!"".equals(contactSTxt.getText())) && (!"".equals(addressSTxt.getText()))  ){
                selected.setUsername(nameSTxt.getText());
                selected.setGender(genderSTxt.getText());
                selected.setEmail(emailSTxt.getText());
                selected.setContact(contactSTxt.getText());
                selected.setAddress(addressSTxt.getText());
                int index = student_table.getSelectionModel().getSelectedIndex();
                data.set(index,selected);
                admin.editStudent(data);

                // clear text boxes
                student_table.getSelectionModel().clearSelection();
                studentIDTxt.clear();
                nameSTxt.clear();
                genderSTxt.clear();
                emailSTxt.clear();
                contactSTxt.clear();
                addressSTxt.clear();

                System.out.println(selected.getUserID()+selected.getUsername());
            }
        }
//        }else{
//           for (Student tempStudent : data){
//               if (tempStudent.getUserID().equals(studentIDTxt.getText())){
//                   
//               }
//           }
//            arrayStudent = FileIO.readStudentFile("student.txt");
//            ObservableList<Student> tempdata = FXCollections.observableArrayList(arrayStudent);
//            student_table.setItems(data);
//            
//        }
    }
    
    @FXML
    private void clearStudent(ActionEvent event) throws Exception {
        student_table.getSelectionModel().clearSelection();
        studentIDTxt.clear();
        nameSTxt.clear();
        genderSTxt.clear();
        emailSTxt.clear();
        contactSTxt.clear();
        addressSTxt.clear();
        
    }
    
    
    @FXML
    private void searchStudent(ActionEvent event) throws Exception {
        System.out.println("Serrrchhhhhh");
        if (!"".equals(studentIDTxt.getText())){
            ArrayList searchStudent = admin.searchStudent( studentIDTxt.getText());
            ObservableList<Student> data = FXCollections.observableArrayList(searchStudent);
            student_table.setItems(data);
        }
     
//        nameSTxt.getText();
//        genderSTxt.getText();
//        emailSTxt.getText();
//        contactSTxt.getText();
//        addressSTxt.getText();
        
        studentIDTxt.clear();
        nameSTxt.clear();
        genderSTxt.clear();
        emailSTxt.clear();
        contactSTxt.clear();
        addressSTxt.clear();
        
    }
    @FXML
    private void pressLogout(javafx.event.ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("welcome.fxml"));
        Stage window = (Stage) logoutBtn.getScene().getWindow(); 
        window.setScene(new Scene(root, 800, 480));
        window.setTitle("Login Page");
    }
}

