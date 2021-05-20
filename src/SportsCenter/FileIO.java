package SportsCenter;

import java.io.*;
import java.util.ArrayList;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

public class FileIO {
    
    public static ArrayList<Sport> readSportsFile(String file){
        
        ArrayList<Sport> arraySports = new ArrayList<>();
        
        try 
        {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("src\\SportsCenter\\txt\\" + file));
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
    
    public static ArrayList<Schedule> readScheduleFile(String file){
        
        ArrayList<Schedule> arraySchedule = new ArrayList<>();
        
        try 
        {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("src\\SportsCenter\\txt\\" + file));
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
    
    public void addSport(String file){
        try 
        {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("src\\SportsCenter\\txt\\" + file));
            ArrayList<Sport> arraySports = new ArrayList<>();  // Writing ArrayList of Sports Object
            
            Coach alex = new Coach("Alex");
            Coach bob = new Coach("Bob");
            Coach caitlin = new Coach("Caitlin");
            Coach demetrice = new Coach("Demetrice");
            Coach evenlyn = new Coach("Evenlyn");
            
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
        
        System.out.println("Sports write operation completed");
    }
    
    public void addSchedule(String file){
        try 
        {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("src\\SportsCenter\\txt\\" + file));
            ArrayList<Schedule> arraySchedule = new ArrayList<>();  // Writing ArrayList of Schedule Object
            
            Coach alex = new Coach("Alex");
            Coach bob = new Coach("Bob");
            Coach caitlin = new Coach("Caitlin");
            Coach demetrice = new Coach("Demetrice");
            Coach evenlyn = new Coach("Evenlyn");
            
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
        
        System.out.println("Schedule write operation completed");
    }
    
    public static void writeStudent(Student student, String file){
        try 
        {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("src\\SportsCenter\\txt\\" + file));
            ArrayList<Student> arrayStudent = new ArrayList<>();  // Writing ArrayList of Schedule Object

            arrayStudent.add(student);
  
            output.writeObject(arrayStudent);
            
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
