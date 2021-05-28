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
        ArrayList<Sport> sortedArraySport = new ArrayList<>();
        
        try 
        {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("src\\SportsCenter\\txt\\" + file));
            //ObjectInputStream input = new ObjectInputStream(new FileInputStream("C:\\Users\\Hamdhan\\Documents\\NetBeansProjects\\Real-Champions-Sport-Academy\\src\\SportsCenter\\txt\\" + file));
            arraySports = (ArrayList<Sport>) input.readObject(); // Reading ArrayList of Sports Object

            for(Sport sprt : arraySports) // Sort all 5 active sports to be at the top
            {
                if(sprt.getStatus().equals("Active"))
                {
                    sortedArraySport.add(sprt);
                }
            }
            for(Sport sprt : arraySports)
            {
                if(sprt.getStatus().equals("Inactive"))
                {
                    sortedArraySport.add(sprt);
                }
            }
            
            input.close();
        }
        catch (FileNotFoundException e){
            System.out.println("File not found!");
        }
        catch (IOException e){
            System.out.println(e);
        }
        catch (ClassNotFoundException e){
            System.out.println("Class not found");
        }
        
        return sortedArraySport;
    }
    
    public static ArrayList<Schedule> readScheduleFile(String file){
        
        ArrayList<Schedule> arraySchedule = new ArrayList<>();
        ArrayList<Schedule> sortedArraySchedule = new ArrayList<>();
        ArrayList<Sport> arraySport = readSportsFile("sport.txt");
        
        try 
        {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("src\\SportsCenter\\txt\\" + file));
            //ObjectInputStream input = new ObjectInputStream(new FileInputStream("C:\\Users\\Hamdhan\\Documents\\NetBeansProjects\\Real-Champions-Sport-Academy\\src\\SportsCenter\\txt\\" + file));
            arraySchedule = (ArrayList<Schedule>) input.readObject(); // Reading ArrayList of Schedule Object

            for(Sport sprt : arraySport) // Sort the schedule based on active sport order
            {
                for(Schedule classes : arraySchedule)
                {
                    if(sprt.getSportID().equals(classes.getSportID()))
                    {
                        sortedArraySchedule.add(classes);
                        break;
                    }
                }
            }
            
            input.close();
        }
        catch (FileNotFoundException e){
            System.out.println("File not found!");
        }
        catch (IOException e){
            System.out.println(e);
        }
        catch (ClassNotFoundException e){
            System.out.println("Class not found");
        }
        
        return sortedArraySchedule;
    }
    
    public static ArrayList<Feedback> readFeedbackFile(String file){
        
        ArrayList<Feedback> arrayFeedback = new ArrayList<>();
        
        try 
        {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("src\\SportsCenter\\txt\\" + file));
            //ObjectInputStream input = new ObjectInputStream(new FileInputStream("C:\\Users\\Hamdhan\\Documents\\NetBeansProjects\\Real-Champions-Sport-Academy\\src\\SportsCenter\\txt\\" + file));
            arrayFeedback = (ArrayList<Feedback>) input.readObject(); // Reading ArrayList of Feedback Object
            input.close();
        }
        catch (FileNotFoundException e){
            System.out.println("File not found!");
        }
        catch (IOException e){
            System.out.println(e);
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
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("src\\SportsCenter\\txt\\" + file));
            //ObjectInputStream input = new ObjectInputStream(new FileInputStream("C:\\Users\\Hamdhan\\Documents\\NetBeansProjects\\Real-Champions-Sport-Academy\\src\\SportsCenter\\txt\\" + file));
            arrayStudent = (ArrayList<Student>) input.readObject(); // Reading ArrayList of Student Object
            input.close();
        }
        catch (FileNotFoundException e){
            System.out.println("File not found!");
        }
        catch (IOException e){
            System.out.println(e);
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
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("src\\SportsCenter\\txt\\" + file));
            //ObjectInputStream input = new ObjectInputStream(new FileInputStream("C:\\Users\\Hamdhan\\Documents\\NetBeansProjects\\Real-Champions-Sport-Academy\\src\\SportsCenter\\txt\\" + file));
            arrayCoach = (ArrayList<Coach>) input.readObject(); // Reading ArrayList of Coach Object
            input.close();
        }
        catch (FileNotFoundException e){
            System.out.println("File not found!");
        }
        catch (IOException e){
            System.out.println(e);
        }
        catch (ClassNotFoundException e){
            System.out.println("Class not found");
        }
        
        return arrayCoach;
    }
    
    public static ArrayList<login> readLoginFile(String file){
        
        ArrayList<login> arrayLogins = new ArrayList<>();
        
        try 
        {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("src\\SportsCenter\\txt\\" + file));
            //ObjectInputStream input = new ObjectInputStream(new FileInputStream("C:\\Users\\Hamdhan\\Documents\\NetBeansProjects\\Real-Champions-Sport-Academy\\src\\SportsCenter\\txt\\" + file));
            arrayLogins = (ArrayList<login>) input.readObject(); // Reading ArrayList of Sports Object
            input.close();
        }
        catch (FileNotFoundException e){
            System.out.println("File not found!");
        }
        catch (IOException e){
            System.out.println(e);
        }
        catch (ClassNotFoundException e){
            System.out.println("Class not found");
        }
        
        return arrayLogins;
    }
    
    public static void writeSport(ArrayList<Sport> arraySport, String file){ 
        try 
        {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("src\\SportsCenter\\txt\\" + file));
            //ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Hamdhan\\Documents\\NetBeansProjects\\Real-Champions-Sport-Academy\\src\\SportsCenter\\txt\\" + file));

            output.writeObject(arraySport);
            
            output.close(); 
        } 
        catch (IOException e){
            System.out.println(e);
        }
    }
    
    public static void writeSchedule(ArrayList<Schedule> arraySchedule, String file){ 
        try
        {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("src\\SportsCenter\\txt\\" + file));
            //ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Hamdhan\\Documents\\NetBeansProjects\\Real-Champions-Sport-Academy\\src\\SportsCenter\\txt\\" + file));
            
            output.writeObject(arraySchedule);
            
            output.close(); 
        } 
        catch (IOException e){
            System.out.println(e);
        }
    }
    
    public static void writeFeedback(ArrayList<Feedback> arrayFeedback, String file){ 
        try 
        {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("src\\SportsCenter\\txt\\" + file));
            //ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Hamdhan\\Documents\\NetBeansProjects\\Real-Champions-Sport-Academy\\src\\SportsCenter\\txt\\" + file));
            
            output.writeObject(arrayFeedback);
            
            output.close(); 
        } 
        catch (IOException e){
            System.out.println(e);
        }
    }
    
    public static void writeStudent(ArrayList<Student> arrayStudent, String file){
        try  
        {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("src\\SportsCenter\\txt\\" + file));
            //ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Hamdhan\\Documents\\NetBeansProjects\\Real-Champions-Sport-Academy\\src\\SportsCenter\\txt\\" + file));
            
            output.writeObject(arrayStudent);
            
            output.close(); 
        } 
        catch (IOException e){
            System.out.println(e);
        }
    }
    
    public static void writeCoach(ArrayList<Coach> arrayCoach, String file){
        try  
        {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("src\\SportsCenter\\txt\\" + file));
            //ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Hamdhan\\Documents\\NetBeansProjects\\Real-Champions-Sport-Academy\\src\\SportsCenter\\txt\\" + file));
            
            output.writeObject(arrayCoach);
            
            output.close(); 
        } 
        catch (IOException e){
            System.out.println(e);
        }
    }
    
    public static void writeLogin(ArrayList<login> arrayLogin, String file){ 
        try 
        {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("src\\SportsCenter\\txt\\" + file));
            //ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Hamdhan\\Documents\\NetBeansProjects\\Real-Champions-Sport-Academy\\src\\SportsCenter\\txt\\" + file));
            
            output.writeObject(arrayLogin);
            
            output.close(); 
        } 
        catch (IOException e){
            System.out.println(e);
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
    
    /*
    public void addlogin(String file){ // Manual writing of Admin account incase it is lost
        try 
        {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("src\\SportsCenter\\txt\\" + file));
            //ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Hamdhan\\Documents\\NetBeansProjects\\Real-Champions-Sport-Academy\\src\\SportsCenter\\txt\\" + file));
            
            ArrayList<login> arrayLogin = new ArrayList<>();  // Writing ArrayList of login Object
            login tempLogin= new login("A001","Welcome123","Simon", "Male", "0123456789", "simon@gmail.com", "Street 2","2007");
            
            arrayLogin.add(tempLogin);
            System.out.println(arrayLogin);
            
            output.writeObject(arrayLogin);
            output.close(); 
        } 
        catch (IOException e){
            System.out.println(e);
        }
    }
    */
}
