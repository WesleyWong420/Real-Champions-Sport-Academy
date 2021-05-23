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
    private TableColumn studentIDCol,nameSCol,lastNameSCol,genderSCol,emailSCol,contactSCol,addressSCol,currentSportCol;
    @FXML
    private Button addSBtn, deleteSBtn, clearSBtn, searchSBtn,editSBtn;
    @FXML
    private Button addCBtn, deleteCBtn, clearCBtn, searchCBtn,editCBtn;
    @FXML
    private Button addSPBtn, deleteSPBtn, clearSPBtn, searchSPBtn,editSPBtn;
    @FXML
    private Button addSCBtn, deleteSCBtn, clearSCBtn, searchSCBtn,editSCBtn;
    @FXML
    private Button logoutBtn;
    @FXML
    private TextField studentIDTxt, firstNameSTxt,lastNameSTxt, genderSTxt, emailSTxt, contactSTxt, addressSTxt;
    
//    @FXML
//    private void button1(ActionEvent event){
//        text2.setText("button clciked");
//    }
    
    ArrayList<Student> arrayStudent = FileIO.readStudentFile("student.txt");
    public void initialize() {
        System.out.println(arrayStudent);
        //Adding student data to table
        final ObservableList<Student> data = FXCollections.observableArrayList(arrayStudent);
        studentIDCol.setCellValueFactory(new PropertyValueFactory("userID"));
        nameSCol.setCellValueFactory(new PropertyValueFactory("username"));
        genderSCol.setCellValueFactory(new PropertyValueFactory("gender"));
        emailSCol.setCellValueFactory(new PropertyValueFactory("email"));
        contactSCol.setCellValueFactory(new PropertyValueFactory("contact"));
        addressSCol.setCellValueFactory(new PropertyValueFactory("address"));
        student_table.setItems(data);
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
            firstNameSTxt.setText(selected.getUserID());
            lastNameSTxt.setText(selected.getUsername());
            genderSTxt.setText(selected.getGender());
            emailSTxt.setText(selected.getEmail());
            contactSTxt.setText(String.valueOf(selected.getContact()));
            addressSTxt.setText(selected.getAddress());
        }
    }
    
    @FXML
    private void addStudent(ActionEvent event) throws Exception {
        ObservableList<Student> data = student_table.getItems();
        //data.add(new Student(firstNameSTxt.getText(), lastNameSTxt.getText(), genderSTxt.getText(), emailSTxt.getText(),Integer.valueOf(contactSTxt.getText()), addressSTxt.getText()));
         studentIDTxt.clear();
         firstNameSTxt.clear();
         lastNameSTxt.clear();
         genderSTxt.clear();
         emailSTxt.clear();
         contactSTxt.clear();
         addressSTxt.clear();
    }
    
    @FXML
    private void deleteStudent(ActionEvent event) throws Exception {
        Student selected = student_table.getSelectionModel().getSelectedItem();
        student_table.getItems().remove(selected);
        ObservableList<Student> data = student_table.getItems();
        System.out.println(data);
    }
    
    @FXML
    private void editStudent(ActionEvent event) throws Exception {
        ObservableList<Student> data = student_table.getItems();
        Student selected = student_table.getSelectionModel().getSelectedItem();
        selected.setUserID(firstNameSTxt.getText());
        selected.setUsername(lastNameSTxt.getText());
        selected.setGender(genderSTxt.getText());
        selected.setEmail(emailSTxt.getText());
        //selected.setContact(Integer.valueOf(contactSTxt.getText()));
        selected.setContact(contactSTxt.getText());
        selected.setAddress(addressSTxt.getText());
        int index = student_table.getSelectionModel().getSelectedIndex();
        data.set(index,selected);
        System.out.println(selected.getUserID()+selected.getUsername());
    }
    @FXML
    private void clearStudent(ActionEvent event) throws Exception {
        student_table.getSelectionModel().clearSelection();
        studentIDTxt.clear();
        firstNameSTxt.clear();
        lastNameSTxt.clear();
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

