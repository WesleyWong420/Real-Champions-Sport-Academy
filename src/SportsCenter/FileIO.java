package SportsCenter;

import java.io.*;
import java.util.ArrayList;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

public class FileIO {
    
    /*
    File IO Operations:
    1) Add Student - Append Student File (Done by System)
    2) Update Student Details - Overwrite Student File (Done by Student)
    3) Update Coach Details - Overwrite Coach, Sport & Schedule File (Done by Coach and Admin)
    4) Update Sport Details - Overwrite Sport, Schedule & Student File (Done by Admin)
    5) Update Schedule Details - Overwrite Schedule File (Done by Admin)
    */
    
    public static ArrayList<Sport> readSportsFile(String file){
        
        ArrayList<Sport> arraySports = new ArrayList<>();
        
        try 
        {
            //ObjectInputStream input = new ObjectInputStream(new FileInputStream("src\\SportsCenter\\txt\\" + file));
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("C:\\Users\\Hamdhan\\Documents\\NetBeansProjects\\Real-Champions-Sport-Academy\\src\\SportsCenter\\txt\\" + file));
            arraySports = (ArrayList<Sport>) input.readObject(); // Reading ArrayList of Sports Object
            input.close();
        }
        catch (FileNotFoundException e){
            System.out.println("File not found!");
        }
        catch (IOException e){
        }
        catch (ClassNotFoundException e){
            System.out.println("Class not found");
        }
        
        return arraySports;
    }
    
        public static ArrayList<login> readLoginFile(String file){
        
        ArrayList<login> arrayLogins = new ArrayList<>();
        
        try 
        {
            //ObjectInputStream input = new ObjectInputStream(new FileInputStream("src\\SportsCenter\\txt\\" + file));
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("C:\\Users\\Hamdhan\\Documents\\NetBeansProjects\\Real-Champions-Sport-Academy\\src\\SportsCenter\\txt\\" + file));
            arrayLogins = (ArrayList<login>) input.readObject(); // Reading ArrayList of Sports Object
            input.close();
        }
        catch (FileNotFoundException e){
            System.out.println("File not found!");
        }
        catch (IOException e){
        }
        catch (ClassNotFoundException e){
            System.out.println("Class not found");
        }
        
        return arrayLogins;
    }
    
    public static ArrayList<Schedule> readScheduleFile(String file){
        
        ArrayList<Schedule> arraySchedule = new ArrayList<>();
        
        try 
        {
            //ObjectInputStream input = new ObjectInputStream(new FileInputStream("src\\SportsCenter\\txt\\" + file));
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("C:\\Users\\Hamdhan\\Documents\\NetBeansProjects\\Real-Champions-Sport-Academy\\src\\SportsCenter\\txt\\" + file));
            
            arraySchedule = (ArrayList<Schedule>) input.readObject(); // Reading ArrayList of Schedule Object
            input.close();
        }
        catch (FileNotFoundException e){
            System.out.println("File not found!");
        }
        catch (IOException e){
        }
        catch (ClassNotFoundException e){
            System.out.println("Class not found");
        }
        
        return arraySchedule;
    }
    
    public static ArrayList<Feedback> readFeedbackFile(String file){
        
        ArrayList<Feedback> arrayFeedback = new ArrayList<>();
        
        try 
        {
            //ObjectInputStream input = new ObjectInputStream(new FileInputStream("src\\SportsCenter\\txt\\" + file));
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("C:\\Users\\Hamdhan\\Documents\\NetBeansProjects\\Real-Champions-Sport-Academy\\src\\SportsCenter\\txt\\" + file));
            arrayFeedback = (ArrayList<Feedback>) input.readObject(); // Reading ArrayList of Feedback Object
            input.close();
        }
        catch (FileNotFoundException e){
            System.out.println("File not found!");
        }
        catch (IOException e){
        }
        catch (ClassNotFoundException e){
            System.out.println("Class not found");
        }
        
        return arrayFeedback;
    }
    
    public static ArrayList<Student> readStudentFile(String file){
        
        ArrayList<Student> arrayStudent = new ArrayList<>();
        
        try 
        {
            //ObjectInputStream input = new ObjectInputStream(new FileInputStream("src\\SportsCenter\\txt\\" + file));
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("C:\\Users\\Hamdhan\\Documents\\NetBeansProjects\\Real-Champions-Sport-Academy\\src\\SportsCenter\\txt\\" + file));
            arrayStudent = (ArrayList<Student>) input.readObject(); // Reading ArrayList of Student Object
            input.close();
        }
        catch (FileNotFoundException e){
            System.out.println("File not found!");
        }
        catch (IOException e){
        }
        catch (ClassNotFoundException e){
            System.out.println("Class not found");
        }
        
        return arrayStudent;
    }
    
    public static ArrayList<Coach> readCoachFile(String file){
        
        ArrayList<Coach> arrayCoach = new ArrayList<>();
        
        try 
        {
            //ObjectInputStream input = new ObjectInputStream(new FileInputStream("src\\SportsCenter\\txt\\" + file));
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("C:\\Users\\Hamdhan\\Documents\\NetBeansProjects\\Real-Champions-Sport-Academy\\src\\SportsCenter\\txt\\" + file));
            arrayCoach = (ArrayList<Coach>) input.readObject(); // Reading ArrayList of Coach Object
            input.close();
        }
        catch (FileNotFoundException e){
            System.out.println("File not found!");
        }
        catch (IOException e){
        }
        catch (ClassNotFoundException e){
            System.out.println("Class not found");
        }
        
        return arrayCoach;
    }
    
    public void addSport(String file){ // Manual writing of Sport object
        try 
        {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("src\\SportsCenter\\txt\\" + file));
            ArrayList<Sport> arraySports = new ArrayList<>();  // Writing ArrayList of Sports Object
            
            Coach alex = new Coach("C001", "Alex", "Male", "0123456789", "alex@gmail.com", "Street 1", 3.5, 40);
            Coach bob = new Coach("C002", "Bob", "Male", "0123456789", "bob@gmail.com", "Street 2", 2.1, 30);
            Coach caitlin = new Coach("C003", "Caitlin", "Female", "0123456789", "caitlin@gmail.com", "Street 3n", 4.8, 35);
            Coach demetrice = new Coach("C004", "Demetrice", "Female", "0123456789", "demetrice@gmail.com", "Street 4", 4.3, 30);
            Coach evenlyn = new Coach("C005", "Evenlyn", "Female", "0123456789", "evenlyn@gmail.com", "Street 5", 5.0, 50);
            
            Sport sport1 = new Sport("S001", "Archery", 120, 130, alex);
            Sport sport2 = new Sport("S002", "Badminton", 120, 90, bob);
            Sport sport3 = new Sport("S003", "Basketball", 120, 90, caitlin);
            Sport sport4 = new Sport("S004", "Gymnastics", 120, 70, demetrice);
            Sport sport5 = new Sport("S005", "Hockey", 120, 125, evenlyn);
            
            arraySports.add(sport1);
            arraySports.add(sport2);
            arraySports.add(sport3);
            arraySports.add(sport4);
            arraySports.add(sport5);
            
            output.writeObject(arraySports);
            output.close(); 
        } 
        catch (IOException e){
        }
    }
    
    public void addSchedule(String file){ // Manual writing of Schedule object
        try 
        {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("src\\SportsCenter\\txt\\" + file));
            ArrayList<Schedule> arraySchedule = new ArrayList<>();  // Writing ArrayList of Schedule Object
            
            Coach alex = new Coach("C001", "Alex", "Male", "0123456789", "alex@gmail.com", "Street 1", 3.5, 40);
            Coach bob = new Coach("C002", "Bob", "Male", "0123456789", "bob@gmail.com", "Street 2", 2.1, 30);
            Coach caitlin = new Coach("C003", "Caitlin", "Female", "0123456789", "caitlin@gmail.com", "Street 3", 4.8, 35);
            Coach demetrice = new Coach("C004", "Demetrice", "Female", "0123456789", "demetrice@gmail.com", "Street 4", 4.3, 30);
            Coach evenlyn = new Coach("C005", "Evenlyn", "Female", "0123456789", "evenlyn@gmail.com", "Street 5", 5.0, 50);
            
            Schedule schedule1 = new Schedule("S001", "Archery", 120, 130, alex, "08:00 - 10:00", "Mon, 23 May", "Court 1");
            Schedule schedule2 = new Schedule("S002", "Badminton", 120, 90, bob, "10:00 - 12:00", "Tue, 24 May", "Court 2");
            Schedule schedule3 = new Schedule("S003", "Basketball", 120, 90, caitlin, "12:00 - 14:00", "Wed, 25 May", "Court 3");
            Schedule schedule4 = new Schedule("S004", "Gymnastics", 120, 70, demetrice, "14:00 - 16:00", "Thu, 26 May", "Court 4");
            Schedule schedule5 = new Schedule("S005", "Hockey", 120, 125, evenlyn, "16:00 - 18:00", "Fri, 27 May", "Court 5");
            
            arraySchedule.add(schedule1);
            arraySchedule.add(schedule2);
            arraySchedule.add(schedule3);
            arraySchedule.add(schedule4);
            arraySchedule.add(schedule5);
  
            output.writeObject(arraySchedule);
            
            output.close(); 
        } 
        catch (IOException e){
        }
    }
    
    public void addFeedback(String file){ // Manual writing of Feedback object
        try 
        {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("src\\SportsCenter\\txt\\" + file));
            ArrayList<Feedback> arrayFeedback = new ArrayList<>();  // Writing ArrayList of Feedback Object
            
            Feedback feedback1 = new Feedback("C001", "Alex", "F001", "Coach is not friendly.", 1);
            Feedback feedback2 = new Feedback("C002", "Bob", "F002", "Quite decent.", 3);
            Feedback feedback3 = new Feedback("C003", "Caitlin", "F003", "Everything is good, coach is friendly.", 4);
            Feedback feedback4 = new Feedback("C004", "Demetrice", "F004", "Teaching part can be improved.", 2);
            Feedback feedback5 = new Feedback("C005", "Evenlyn", "F005", "Perfect! Friendly coach. Would come again.", 5);
            Feedback feedback6 = new Feedback("C001", "Alex", "F006", "Coach is not teaching closely. Just taking a peek once in a while.", 2);
            Feedback feedback7 = new Feedback("C005", "Evenlyn", "F007", "Coach is great but the court is awful in maintenance.", 3);
            
            arrayFeedback.add(feedback1);
            arrayFeedback.add(feedback2);
            arrayFeedback.add(feedback3);
            arrayFeedback.add(feedback4);
            arrayFeedback.add(feedback5);
            arrayFeedback.add(feedback6);
            arrayFeedback.add(feedback7);
            
            output.writeObject(arrayFeedback);
            output.close(); 
        } 
        catch (IOException e){
        }
    }
    
    public void addStudent(String file){ // Manual writing of Student object
        try 
        {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("src\\SportsCenter\\txt\\" + file));
            ArrayList<Student> arrayStudent = new ArrayList<>();  // Writing ArrayList of Student Object
            
            Coach alex = new Coach("C001", "Alex", "Male", "0123456789", "alex@gmail.com", "Street 1", 3.5, 40);
            Coach bob = new Coach("C002", "Bob", "Male", "0123456789", "bob@gmail.com", "Street 2", 2.1, 30);
            Coach caitlin = new Coach("C003", "Caitlin", "Female", "0123456789", "caitlin@gmail.com", "Street 3n", 4.8, 35);
            Coach demetrice = new Coach("C004", "Demetrice", "Female", "0123456789", "demetrice@gmail.com", "Street 4", 4.3, 30);
            Coach evenlyn = new Coach("C005", "Evenlyn", "Female", "0123456789", "evenlyn@gmail.com", "Street 5", 5.0, 50);
            
            Sport sport1 = new Sport("S001", "Archery", 120, 130, alex);
            Sport sport2 = new Sport("S002", "Badminton", 120, 90, bob);
            Sport sport3 = new Sport("S003", "Basketball", 120, 90, caitlin);
            Sport sport4 = new Sport("S004", "Gymnastics", 120, 70, demetrice);
            Sport sport5 = new Sport("S005", "Hockey", 120, 125, evenlyn);
            
            ArrayList<String> lastFiveFeedbackID = new ArrayList<>();
            lastFiveFeedbackID.add("F001");
            lastFiveFeedbackID.add("");
            lastFiveFeedbackID.add("");
            lastFiveFeedbackID.add("F004");
            lastFiveFeedbackID.add("F005");
            Student student1 = new Student("S001", "Caren", "Female", "0123456789", "caren@gmail.com", "Street 1", lastFiveFeedbackID, sport3);
            ArrayList<String> lastFiveFeedbackID1 = new ArrayList<>();
            lastFiveFeedbackID1.add("");
            lastFiveFeedbackID1.add("F002");
            lastFiveFeedbackID1.add("F003");
            lastFiveFeedbackID1.add("");
            lastFiveFeedbackID1.add("");
            Student student2 = new Student("S002", "Helen", "Female", "0123456789", "helen@gmail.com", "Street 2", lastFiveFeedbackID1, sport1);
            ArrayList<String> lastFiveFeedbackID2 = new ArrayList<>();
            lastFiveFeedbackID2.add("F006");
            lastFiveFeedbackID2.add("");
            lastFiveFeedbackID2.add("");
            lastFiveFeedbackID2.add("");
            lastFiveFeedbackID2.add("F007");
            Student student3 = new Student("S003", "Stella", "Female", "0123456789", "stella@gmail.com", "Street 3", lastFiveFeedbackID2, sport4);
            ArrayList<String> lastFiveFeedbackID3 = new ArrayList<>();
            lastFiveFeedbackID3.add("");
            lastFiveFeedbackID3.add("");
            lastFiveFeedbackID3.add("");
            lastFiveFeedbackID3.add("");
            lastFiveFeedbackID3.add("");
            Student student4 = new Student("S004", "Chris", "Male", "0123456789", "chris@gmail.com", "Street 4", lastFiveFeedbackID3);
            Student student5 = new Student("S005", "Rachel", "Female", "0123456789", "rachel@gmail.com", "Street 5", lastFiveFeedbackID3);
            
            arrayStudent.add(student1);
            arrayStudent.add(student2);
            arrayStudent.add(student3);
            arrayStudent.add(student4);
            arrayStudent.add(student5);
            
            output.writeObject(arrayStudent);
            output.close(); 
        } 
        catch (IOException e){
        }
    }
    
    public void addCoach(String file){ // Manual writing of Coach object
        try 
        {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("src\\SportsCenter\\txt\\" + file));
            ArrayList<Coach> arrayCoach = new ArrayList<>();  // Writing ArrayList of Coach Object
            
            Coach coach1 = new Coach("C001", "Alex", "Male", "0123456789", "alex@gmail.com", "Street 1", 3.5, 40);
            Coach coach2 = new Coach("C002", "Bob", "Male", "0123456789", "bob@gmail.com", "Street 2", 2.1, 30);
            Coach coach3 = new Coach("C003", "Caitlin", "Female", "0123456789", "caitlin@gmail.com", "Street 3n", 4.8, 35);
            Coach coach4 = new Coach("C004", "Demetrice", "Female", "0123456789", "demetrice@gmail.com", "Street 4", 4.3, 30);
            Coach coach5 = new Coach("C005", "Evenlyn", "Female", "0123456789", "evenlyn@gmail.com", "Street 5", 5.0, 50);
            
            arrayCoach.add(coach1);
            arrayCoach.add(coach2);
            arrayCoach.add(coach3);
            arrayCoach.add(coach4);
            arrayCoach.add(coach5);
            
            output.writeObject(arrayCoach);
            output.close(); 
        } 
        catch (IOException e){
        }
    }
    
    public void addlogin(String file){ // Manual writing of Login object
        try 
        {
            //ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("src\\SportsCenter\\txt\\" + file));
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Hamdhan\\Documents\\NetBeansProjects\\Real-Champions-Sport-Academy\\src\\SportsCenter\\txt\\" + file));
            
            ArrayList<login> arrayLogin = new ArrayList<>();  // Writing ArrayList of login Object
            login tempLogin= new login("A001","Welcome123","Simon", "Male", "0123456789", "simon@gmail.com", "Street 2","2007");
            
            login tempLogin2 = new login("C001","Welcome123", "Alex", "Male", "0123456789", "alex@gmail.com", "Street 1", 3.5, 40);
            login tempLogin3 = new login("C002","Welcome123", "Bob", "Male", "0123456789", "bob@gmail.com", "Street 2", 2.1, 30);
            login tempLogin4 = new login("C003", "Welcome123","Caitlin", "Female", "0123456789", "caitlin@gmail.com", "Street 3n", 4.8, 35);
            login tempLogin5 = new login("C004","Welcome123", "Demetrice", "Female", "0123456789", "demetrice@gmail.com", "Street 4", 4.3, 30);
            login tempLogin6 = new login("C005", "Welcome123","Evenlyn", "Female", "0123456789", "evenlyn@gmail.com", "Street 5", 5.0, 50);
            
            arrayLogin.add(tempLogin);
            arrayLogin.add(tempLogin2);
            arrayLogin.add(tempLogin3);
            arrayLogin.add(tempLogin4);
            arrayLogin.add(tempLogin5);
            arrayLogin.add(tempLogin6);
            
            System.out.println(arrayLogin);
            
            output.writeObject(arrayLogin);
            output.close(); 
        } 
        catch (IOException e){
            System.out.println(e);
        }
    }
    
    public static void writeSport(ArrayList<Sport> arraySport, String file){ 
        try 
        {
            //ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("src\\SportsCenter\\txt\\" + file));
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Hamdhan\\Documents\\NetBeansProjects\\Real-Champions-Sport-Academy\\src\\SportsCenter\\txt\\" + file));
            
            output.writeObject(arraySport);
            
            output.close(); 
        } 
        catch (IOException e){
        }
    }
    
        public static void writeLogin(ArrayList<login> arrayLogin, String file){ 
        try 
        {
            //ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("src\\SportsCenter\\txt\\" + file));
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Hamdhan\\Documents\\NetBeansProjects\\Real-Champions-Sport-Academy\\src\\SportsCenter\\txt\\" + file));
            
            output.writeObject(arrayLogin);
            
            output.close(); 
        } 
        catch (IOException e){
        }
    }
    
    public static void writeSchedule(ArrayList<Schedule> arraySchedule, String file){ 
        try
        {
            //ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("src\\SportsCenter\\txt\\" + file));
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Hamdhan\\Documents\\NetBeansProjects\\Real-Champions-Sport-Academy\\src\\SportsCenter\\txt\\" + file));
            
            output.writeObject(arraySchedule);
            
            output.close(); 
        } 
        catch (IOException e){
        }
    }
    
    public static void writeFeedback(ArrayList<Feedback> arrayFeedback, String file){ 
        try 
        {
            //ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("src\\SportsCenter\\txt\\" + file));
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Hamdhan\\Documents\\NetBeansProjects\\Real-Champions-Sport-Academy\\src\\SportsCenter\\txt\\" + file));
            
            output.writeObject(arrayFeedback);
            
            output.close(); 
        } 
        catch (IOException e){
        }
    }
    
    public static void writeStudent(ArrayList<Student> arrayStudent, String file){
        try  
        {
           // ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("src\\SportsCenter\\txt\\" + file));
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Hamdhan\\Documents\\NetBeansProjects\\Real-Champions-Sport-Academy\\src\\SportsCenter\\txt\\" + file));
            
            output.writeObject(arrayStudent);
            
            output.close(); 
        } 
        catch (IOException e){
        }
    }
    
    public static void writeCoach(ArrayList<Coach> arrayCoach, String file){
        try  
        {
           //ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("src\\SportsCenter\\txt\\" + file));
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Hamdhan\\Documents\\NetBeansProjects\\Real-Champions-Sport-Academy\\src\\SportsCenter\\txt\\" + file));
            
            output.writeObject(arrayCoach);
            
            output.close(); 
        } 
        catch (IOException e){
        }
    }
    
    public static void pushNotification(String title, String description) throws FileNotFoundException{
        
        ImageView icon = new ImageView(new Image(new FileInputStream("src\\SportsCenter\\images\\success.png")));
        icon.setFitWidth(32);
        icon.setFitHeight(32);
        Notifications notifier = Notifications.create()
                .title(title)
                .text(description)
                .graphic(icon)
                .hideAfter(Duration.seconds(3))
                .position(Pos.BOTTOM_RIGHT);
        notifier.show();
    }
}
