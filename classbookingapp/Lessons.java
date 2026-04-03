package classbookingapp;
import java.util.*;

public class Lessons{
       private String LessonName;
       private Integer week = 1;
       private String[] Slot = {"Saturday Morning", "Saturday Afternoon", "Saturday Evening", "Sunday Morning", "Sunday Afternoon", "Sunday Evening"};
       private ArrayList<Integer> Bookings = new ArrayList<Integer>();
       private float Rating;
       private ArrayList<String> Review = new ArrayList<String>();

       //1.Name, 2. Slot, 3.Attendees, 4. Review, 5. Rating
       public void addLesson(String name,int date,int idx){
         this.LessonName = name;
         this.week = date;
         this.Slot[idx] = Slot[idx];
       }
         public void getLesson(){
            System.out.println(LessonName);
            System.out.println(week);
            System.out.println(Slot);
            System.out.println(Bookings);
         }
         public void addBooking(int id){
            this.Bookings.add(id);
         }
         public void removeBooking(int id){
            this.Bookings.remove(id);
         }
         public boolean checkbookingslots(){
            if (Bookings.size() == 14){
               System.out.println("No more slots available for this lesson");
               return false;
            }
            return true;
         }
         public void addReview(String review){
            this.Review.add(review);
         }
         public void addRating(float rating){
            this.Rating = rating;
         }
         public void getRating(){
            System.out.println(Rating);
         }
         public void getReview(){
            System.out.println(Review);
         }
    }