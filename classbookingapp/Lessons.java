package classbookingapp;
import java.util.*;

public class Lessons{
   private int LessonID;
   private String LessonName;
   private Integer week;
   private String Slot;
   private ArrayList<Integer> Bookings = new ArrayList<Integer>();
   private float Rating;
   private ArrayList<String> Review = new ArrayList<String>();
   private float price;

   //1.Name, 2. Slot, 3.Attendees, 4. Review, 5. Rating
   public void addLesson(int id, String name, int date, String slot, float price){
      this.LessonID = id;
      this.LessonName = name;
      this.week = date;
      this.Slot = slot;
      this.price = price;
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
   public void getPrice(){
      System.out.println(price);
   }
   public void setPrice(float price){
      this.price = price;
   }
   public void getID(){
      System.out.println(LessonID);
   }
   public void getSlot(){
      System.out.println(Slot);
   }
}