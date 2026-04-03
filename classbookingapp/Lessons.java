package classbookingapp;
import java.util.*;
import java.io.*;
public class Lessons{
       private String LessonName;
       private String Slot;
       private ArrayList<String> Attendees = new ArrayList<String>();
       private float Rating;
       private ArrayList<String> Review = new ArrayList<String>();
       private LinkedList<String> Lesson = new LinkedList<String>();

       File myObj = new File("Data.csv");
       FileWriter myWriter = new FileWriter("Data.txt");

       //1.Name, 2. Slot, 3.Attendees, 4. Review, 5. Rating
       
       public void getName(){}
    }