package SportsCenter;

import java.io.IOException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class adminController {

    @FXML 
    private TableView<Student> student_table;
    @FXML
    private TableView<Coach> coach_table;
    @FXML
    private TableView<Sport> sport_table;
    @FXML
    private TableView<Schedule> schedule_table;
    
    @FXML 
    private TableColumn studentIDCol,nameSCol,genderSCol,emailSCol,contactSCol,addressSCol,currentSportCol;
    @FXML 
    private TableColumn coachIDCol,nameCCol,genderCCol,emailCCol,contactCCol,addressCCol,ratingCol,hourlyRateCol,spcIDCol,spcNameCol;
    @FXML 
    private TableColumn sportIDCol,nameSPCol,durationSPCol,feeSPCol,contactSPCol,coachIDSPCol;
    @FXML 
    private TableColumn sportIDSCCol,sportNameSCCol,timeSCCol,dateSCCol,locationSCCol,statusSPCol;
    
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
    private TextField coachIDTxt, nameCTxt, genderCTxt, emailCTxt, contactCTxt, addressCTxt, ratingCTxt,hourlyCTxt,spcIDTxt,spcNameTxt;
    @FXML
    private TextField sportIDTxt, nameSPTxt, durationSPTxt, feeSPTxt, coachIDSPTxt, statusSPTxt;
    @FXML
    private TextField sportIDSCTxt, dateSCTxt, timeSCTxt, locationSCTxt;
    
    private Admin admin = new Admin();
    
    private ArrayList<Student> arrayStudent = FileIO.readStudentFile("student.txt");
    private ArrayList<Coach> arrayCoach = FileIO.readCoachFile("coach.txt");
    private ArrayList<Sport> arraySport = FileIO.readSportsFile("sport.txt");
    private ArrayList<Schedule> arraySchedule = FileIO.readScheduleFile("schedule.txt");
    
    public void initialize() throws IOException {
        //Adding student data to table
        ObservableList<Student> data = FXCollections.observableArrayList(arrayStudent);
        studentIDCol.setCellValueFactory(new PropertyValueFactory("userID"));
        nameSCol.setCellValueFactory(new PropertyValueFactory("username"));
        genderSCol.setCellValueFactory(new PropertyValueFactory("gender"));
        emailSCol.setCellValueFactory(new PropertyValueFactory("email"));
        contactSCol.setCellValueFactory(new PropertyValueFactory("contact"));
        addressSCol.setCellValueFactory(new PropertyValueFactory("address"));
        currentSportCol.setCellValueFactory(new PropertyValueFactory("SportName"));
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
        spcIDCol.setCellValueFactory(new PropertyValueFactory("sportCenterID"));
        spcNameCol.setCellValueFactory(new PropertyValueFactory("sportCenterName"));
        coach_table.setItems(coachData);
        
        //Adding sport to table
        ObservableList<Sport> sportData = FXCollections.observableArrayList(arraySport);
        sportIDCol.setCellValueFactory(new PropertyValueFactory("sportID"));
        nameSPCol.setCellValueFactory(new PropertyValueFactory("sportName"));
        durationSPCol.setCellValueFactory(new PropertyValueFactory("duration"));
        feeSPCol.setCellValueFactory(new PropertyValueFactory("fee"));
        coachIDSPCol.setCellValueFactory(new PropertyValueFactory("CoachID"));
        statusSPCol.setCellValueFactory(new PropertyValueFactory("status"));
        sport_table.setItems(sportData);
        
        //Adding schedule to table
        ObservableList<Schedule> scheduleData = FXCollections.observableArrayList(arraySchedule);
        sportIDSCCol.setCellValueFactory(new PropertyValueFactory("sportID"));
        sportNameSCCol.setCellValueFactory(new PropertyValueFactory("sportName"));
        timeSCCol.setCellValueFactory(new PropertyValueFactory("time"));
        dateSCCol.setCellValueFactory(new PropertyValueFactory("date"));
        locationSCCol.setCellValueFactory(new PropertyValueFactory("location"));
        schedule_table.setItems(scheduleData);
    }
    
    
    @FXML
    private void getStudent(MouseEvent event) throws Exception {
        
        //get selected student from table
        
        ObservableList<Student> data = student_table.getItems();
        Student selected = student_table.getSelectionModel().getSelectedItem();
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
    private void deleteStudent(ActionEvent event) throws Exception {
        Student selected = student_table.getSelectionModel().getSelectedItem();
        if (selected != null){
            student_table.getItems().remove(selected);
            ObservableList<Student> data = student_table.getItems();
            
            //use admin class to update student
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
                
                // use admin class to update student
                admin.editStudent(data);

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
        
        //updating table after search
        arrayStudent = FileIO.readStudentFile("student.txt");
        ObservableList<Student> studentData = FXCollections.observableArrayList(arrayStudent);
        student_table.setItems(studentData);
        
        editSBtn.setDisable(false); 
        deleteSBtn.setDisable(false);
    }
    
    @FXML
    private void searchStudent(ActionEvent event) throws Exception {
        
        //add searched student to table
        
        if (!"".equals(studentIDTxt.getText())){
            ArrayList searchStudent = admin.searchStudent( studentIDTxt.getText());
            ObservableList<Student> data = FXCollections.observableArrayList(searchStudent);
            student_table.setItems(data);
        }
        
        editSBtn.setDisable(true); 
        deleteSBtn.setDisable(true);
        studentIDTxt.clear();
        nameSTxt.clear();
        genderSTxt.clear();
        emailSTxt.clear();
        contactSTxt.clear();
        addressSTxt.clear();
    }
    
    //Coach Tab
    
    @FXML
    private void getCoach(MouseEvent event) throws Exception {
        
        //Get selected coach from table
        
        ObservableList<Coach> coachData = coach_table.getItems();
        Coach selected = coach_table.getSelectionModel().getSelectedItem();
        if (selected != null){
            coachIDTxt.setText(selected.getUserID());
            nameCTxt.setText(selected.getUsername());
            genderCTxt.setText(selected.getGender());
            emailCTxt.setText(selected.getEmail());
            contactCTxt.setText(String.valueOf(selected.getContact()));
            addressCTxt.setText(selected.getAddress());
            ratingCTxt.setText(String.valueOf(selected.getCoachRating()));
            hourlyCTxt.setText(String.valueOf(selected.getHourlyRate()));
            spcIDTxt.setText(selected.getSportCenterID());
            spcNameTxt.setText(selected.getSportCenterName());
        }
    }
    
    @FXML
    private void addCoach(ActionEvent event) throws Exception {
        ObservableList<Coach> coachData = coach_table.getItems();
        if((!"".equals(nameCTxt.getText()))&& (!"".equals(genderCTxt.getText())) && (!"".equals(emailCTxt.getText())) && (!"".equals(contactCTxt.getText())) && (!"".equals(addressCTxt.getText())) && (!"".equals(hourlyCTxt.getText())) && (!"".equals(spcIDTxt.getText()))  && (!"".equals(spcNameTxt.getText()))  ){
            if(coachData != null){
                Coach newCoachID = new Coach();
                
                //Generate Coach ID and add Coach
                coachData.add(new Coach(newCoachID.generateUserID(), nameCTxt.getText(), genderCTxt.getText(),contactCTxt.getText(), emailCTxt.getText(), addressCTxt.getText(),0.0,Integer.valueOf(hourlyCTxt.getText()),spcIDTxt.getText(),spcNameTxt.getText()));
                ArrayList<Coach> arrayCoach = new ArrayList<Coach>(coachData);
                FileIO.writeCoach(arrayCoach, "coach.txt");
                admin.addCoach(coachData);

                coachIDTxt.clear();
                nameCTxt.clear();
                genderCTxt.clear();
                emailCTxt.clear();
                contactCTxt.clear();
                addressCTxt.clear();
                ratingCTxt.clear();
                hourlyCTxt.clear();
                spcIDTxt.clear();
                spcNameTxt.clear();
            }
        }
    }
    
    @FXML
    private void deleteCoach(ActionEvent event) throws Exception {
        Coach selected = coach_table.getSelectionModel().getSelectedItem();
        if (selected != null){
            coach_table.getItems().remove(selected);
            ObservableList<Coach> coachData = coach_table.getItems();
            
            //update coach using addmin class
            admin.deleteCoach(coachData,selected.getUserID());
            
            // clear text boxes
            coach_table.getSelectionModel().clearSelection();
            coachIDTxt.clear();
            nameCTxt.clear();
            genderCTxt.clear();
            emailCTxt.clear();
            contactCTxt.clear();
            addressCTxt.clear();
            ratingCTxt.clear();
            hourlyCTxt.clear();
            spcIDTxt.clear();
            spcNameTxt.clear();
            
        }
    }
    
    @FXML
    private void editCoach(ActionEvent event) throws Exception {
        ObservableList<Coach> coachData = coach_table.getItems();
        Coach selected = coach_table.getSelectionModel().getSelectedItem();
        if (selected != null){
            if((!"".equals(nameCTxt.getText()))&& (!"".equals(genderCTxt.getText())) && (!"".equals(emailCTxt.getText())) && (!"".equals(contactCTxt.getText())) && (!"".equals(addressCTxt.getText())) && (!"".equals(hourlyCTxt.getText())) && (!"".equals(spcIDTxt.getText()))  && (!"".equals(spcNameTxt.getText())) ){
                selected.setUsername(nameCTxt.getText());
                selected.setGender(genderCTxt.getText());
                selected.setEmail(emailCTxt.getText());
                selected.setContact(contactCTxt.getText());
                selected.setAddress(addressCTxt.getText());
                selected.setHourlyRate(Integer.parseInt(hourlyCTxt.getText()));
                selected.setSportCenterID(spcIDTxt.getText());
                selected.setSportCenterName(spcNameTxt.getText());
                int index = coach_table.getSelectionModel().getSelectedIndex();
                coachData.set(index,selected);
                
                //use admin class to update coach
                admin.editCoach(coachData);

                // clear text boxes
                coach_table.getSelectionModel().clearSelection();
                coachIDTxt.clear();
                nameCTxt.clear();
                genderCTxt.clear();
                emailCTxt.clear();
                contactCTxt.clear();
                addressCTxt.clear();
                ratingCTxt.clear();
                hourlyCTxt.clear();
                spcIDTxt.clear();
                spcNameTxt.clear();

            }
        }
    }
    
    @FXML
    private void clearCoach(ActionEvent event) throws Exception {
        // clear text boxes
        coach_table.getSelectionModel().clearSelection();
        coachIDTxt.clear();
        nameCTxt.clear();
        genderCTxt.clear();
        emailCTxt.clear();
        contactCTxt.clear();
        addressCTxt.clear();
        ratingCTxt.clear();
        hourlyCTxt.clear();
        spcIDTxt.clear();
        spcNameTxt.clear();
        
        //updating table after search
        arrayCoach = FileIO.readCoachFile("coach.txt");
        ObservableList<Coach> coachData = FXCollections.observableArrayList(arrayCoach);
        coach_table.setItems(coachData);
        
        addCBtn.setDisable(false);
        editCBtn.setDisable(false); 
        deleteCBtn.setDisable(false);
    }
    
    @FXML
    private void searchCoach(ActionEvent event) throws Exception {
        
        //add searched coach to table
        if (!"".equals(coachIDTxt.getText())){
            ArrayList searchCoach = admin.searchCoach(coachIDTxt.getText(),"coachID");
            ObservableList<Coach> coachData = FXCollections.observableArrayList(searchCoach);
            coach_table.setItems(coachData);
        }else if(!"".equals(ratingCTxt.getText())){
            ArrayList searchCoach = admin.searchCoach(ratingCTxt.getText(),"rating");
            ObservableList<Coach> coachData = FXCollections.observableArrayList(searchCoach);
            coach_table.setItems(coachData);
        }
        
        //disable buttons and clear text fields
        addCBtn.setDisable(true);
        editCBtn.setDisable(true);
        deleteCBtn.setDisable(true);
        coachIDTxt.clear();
        nameCTxt.clear();
        genderCTxt.clear();
        emailCTxt.clear();
        contactCTxt.clear();
        addressCTxt.clear();
        ratingCTxt.clear();
        hourlyCTxt.clear();
        spcIDTxt.clear();
        spcNameTxt.clear();
    }
    
    //Sports Tab
    
    @FXML
    private void getSport(MouseEvent event) throws Exception {
        
        // Get Selected sport from table
        ObservableList<Sport> sportData = sport_table.getItems();
        Sport selected = sport_table.getSelectionModel().getSelectedItem();
 
        if (selected != null){
            sportIDTxt.setText(selected.getSportID());
            nameSPTxt.setText(selected.getSportName());
            durationSPTxt.setText(String.valueOf(selected.getDuration()));
            feeSPTxt.setText(String.valueOf(selected.getFee()));
            statusSPTxt.setText(selected.getStatus());
            Coach tempCoach1 = selected.getCoachObject();
            coachIDSPTxt.setText(tempCoach1.getUserID());
        }
    }
    
    @FXML
    private void addSport(ActionEvent event) throws Exception {
        ObservableList<Sport> sportData = sport_table.getItems();
        if((!"".equals(nameSPTxt.getText()))&& (!"".equals(durationSPTxt.getText())) && (!"".equals(feeSPTxt.getText())) && (!"".equals(coachIDSPTxt.getText())) && (!"".equals(statusSPTxt.getText()))  ){
            if(sportData != null){
                
                //validate if coach exist,for adding to add sport.
                
                Sport newSportID = new Sport();
                Coach setCoach = new Coach();
                setCoach = setCoach.validate(coachIDSPTxt.getText());
                if (setCoach != null){
                    sportData.add(new Sport(newSportID.generateSportID(), nameSPTxt.getText(), Integer.parseInt(durationSPTxt.getText()), Integer.parseInt(feeSPTxt.getText()),statusSPTxt.getText(),setCoach));
                    admin.addSport(sportData);

                    sportIDTxt.clear();
                    nameSPTxt.clear();
                    statusSPTxt.clear();
                    durationSPTxt.clear();
                    feeSPTxt.clear();
                    coachIDSPTxt.clear();
                } else{
                    coachIDSPTxt.setText("Enter Correct ID!");
                }
           }
        }
    }
    
    @FXML
    private void deleteSport(ActionEvent event) throws Exception {
        Sport selected = sport_table.getSelectionModel().getSelectedItem();
        if (selected != null){
            sport_table.getItems().remove(selected);
            ObservableList<Sport> sportData = sport_table.getItems();
            
            //Use admin class to delete sport
            admin.deleteSport(sportData,selected.getSportID());
            
            // clear text boxes
            sport_table.getSelectionModel().clearSelection();
            sportIDTxt.clear();
            nameSPTxt.clear();
            statusSPTxt.clear();
            durationSPTxt.clear();
            feeSPTxt.clear();
            coachIDSPTxt.clear();
        }
    }
    
    @FXML
    private void editSport(ActionEvent event) throws Exception {
        ObservableList<Sport> sportData = sport_table.getItems();
        Sport selected = sport_table.getSelectionModel().getSelectedItem();
        if (selected != null){
            if((!"".equals(nameSPTxt.getText()))&& (!"".equals(durationSPTxt.getText())) && (!"".equals(feeSPTxt.getText())) && (!"".equals(coachIDSPTxt.getText())) && (!"".equals(statusSPTxt.getText())) ){
                
                //validate if coach exist,for adding to add sport.
                
                Sport newSportID = new Sport();
                Coach setCoach = new Coach();
                setCoach = setCoach.validate(coachIDSPTxt.getText());
                
                if (setCoach != null){
                    selected.setSportName(nameSPTxt.getText());
                    selected.setDuration(Integer.parseInt(durationSPTxt.getText()));
                    selected.setStatus(statusSPTxt.getText());
                    selected.setFee(Integer.parseInt(feeSPTxt.getText()));
                    selected.setCoachObject(setCoach);
                    
                    int index = sport_table.getSelectionModel().getSelectedIndex();
                    sportData.set(index,selected);
                    
                    // use admin class to update sport
                    admin.editSport(sportData);

                    // clear text boxes
                    sport_table.getSelectionModel().clearSelection();
                    sportIDTxt.clear();
                    statusSPTxt.clear();
                    nameSPTxt.clear();
                    durationSPTxt.clear();
                    feeSPTxt.clear();
                    coachIDSPTxt.clear();
                
                }else{
                    coachIDSPTxt.setText("Enter Correct ID!");
                }
            }
        }
    }
    
    @FXML
    private void clearSport(ActionEvent event) throws Exception {
        // clear text boxes
        coach_table.getSelectionModel().clearSelection();
        sportIDTxt.clear();
        statusSPTxt.clear();
        nameSPTxt.clear();
        durationSPTxt.clear();
        feeSPTxt.clear();
        coachIDSPTxt.clear();
        
        //updating table after search
        arraySport = FileIO.readSportsFile("sport.txt");
        ObservableList<Sport> sportData = FXCollections.observableArrayList(arraySport);
        sport_table.setItems(sportData);
        
        addSCBtn.setDisable(false);
        editSCBtn.setDisable(false); 
        deleteSPBtn.setDisable(false);
    }
    
    @FXML
    private void searchSport(ActionEvent event) throws Exception {
        // get searched sport and add to table
        if (!"".equals(sportIDTxt.getText())){
            ArrayList searchSport = admin.searchSport( sportIDTxt.getText());
            ObservableList<Sport> sportdata = FXCollections.observableArrayList(searchSport);
            sport_table.setItems(sportdata);
        }
        
        //disable button and clear text boxes
        addSPBtn.setDisable(true);
        editSPBtn.setDisable(true);
        deleteSPBtn.setDisable(true);
        sportIDTxt.clear();
        nameSPTxt.clear();
        durationSPTxt.clear();
        feeSPTxt.clear();
        coachIDSPTxt.clear();
    }
    
    //Schedule Tab
    
    @FXML
    private void getSchedule(MouseEvent event) throws Exception {
        
        //Get selected schedule from table
        
        ObservableList<Schedule> scheduleData = schedule_table.getItems();
        Schedule selected = schedule_table.getSelectionModel().getSelectedItem();
        if (selected != null){
            sportIDSCTxt.setText(selected.getSportID());
            dateSCTxt.setText(selected.getDate());
            timeSCTxt.setText(selected.getTime());
            locationSCTxt.setText(selected.getLocation());
        }
    }
    
    @FXML
    private void addSchedule(ActionEvent event) throws Exception {
        ObservableList<Schedule> scheduleData = schedule_table.getItems();
        if((!"".equals(sportIDSCTxt.getText()))&& (!"".equals(dateSCTxt.getText())) && (!"".equals(timeSCTxt.getText())) && (!"".equals(locationSCTxt.getText()))  ){
            if(scheduleData != null){
                Sport setSportID = new Sport();
                setSportID = setSportID.validate(sportIDSCTxt.getText());
                if (setSportID != null){
                    scheduleData.add(new Schedule(setSportID.getSportID(), setSportID.getSportName(), setSportID.getDuration(), setSportID.getFee(),setSportID.getStatus(),setSportID.getCoachObject(),timeSCTxt.getText(),dateSCTxt.getText(),locationSCTxt.getText()));
                    
                    //use admin class to update schedule
                    admin.addSchedule(scheduleData);

                    sportIDSCTxt.clear();
                    dateSCTxt.clear();
                    timeSCTxt.clear();
                    locationSCTxt.clear();
                } else{
                    sportIDSCTxt.setText("Enter Correct Sport ID!");
                }
           }
        }
    }
    
    @FXML
    private void deleteSchedule(ActionEvent event) throws Exception {
        Schedule selected = schedule_table.getSelectionModel().getSelectedItem();
        if (selected != null){
            schedule_table.getItems().remove(selected);
            ObservableList<Schedule> scheduleData = schedule_table.getItems();
            admin.deleteSchedule(scheduleData);
            
            // clear text boxes
            schedule_table.getSelectionModel().clearSelection();
            sportIDSCTxt.clear();
            dateSCTxt.clear();
            timeSCTxt.clear();
            locationSCTxt.clear();
        }
    }
    
    @FXML
    private void clearSchedule(ActionEvent event) throws Exception {
        // clear text boxes
        schedule_table.getSelectionModel().clearSelection();
        sportIDSCTxt.clear();
        dateSCTxt.clear();
        timeSCTxt.clear();
        locationSCTxt.clear();
        
        //updating table after search
        arraySchedule = FileIO.readScheduleFile("schedule.txt");
        ObservableList<Schedule> scheduleData = FXCollections.observableArrayList(arraySchedule);
        schedule_table.setItems(scheduleData);
         
        //enable the buttons that got disable during search
        addSCBtn.setDisable(false);
        deleteSCBtn.setDisable(false); 
    }
    
    @FXML
    private void searchSchedule(ActionEvent event) throws Exception {
        
        // Get searched Schedule and add to table
        if (!"".equals(sportIDSCTxt.getText())){
            ArrayList searchSchedule = admin.searchSchedule( sportIDSCTxt.getText());
            ObservableList<Schedule> scheduleData = FXCollections.observableArrayList(searchSchedule);
            schedule_table.setItems(scheduleData);
        }
        //clear text fields and disable buttons
        addSCBtn.setDisable(true);
        deleteSCBtn.setDisable(true);
        sportIDTxt.clear();
        dateSCTxt.clear();
        feeSPTxt.clear();
        locationSCTxt.clear();
    }
    
    @FXML
    private void pressLogout(javafx.event.ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("welcome.fxml"));
        Stage window = (Stage) logoutBtn.getScene().getWindow(); 
        window.setScene(new Scene(root, 800, 480));
        window.setTitle("Login Page");
    }
}

