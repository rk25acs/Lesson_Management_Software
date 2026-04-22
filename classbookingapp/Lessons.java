package classbookingapp;
import java.util.*;

public class Lessons{
   private int LessonID;
   private String LessonName;
   private String Day;
   private int Week;
   private String Slot;
   private ArrayList<Booking> Bookings = new ArrayList<Booking>();
   private float Rating;
   private ArrayList<String> Review = new ArrayList<String>();
   private float price;

   //1.Name, 2. Slot, 3.Attendees, 4. Review, 5. Rating
   public Lessons(int id, String name, String day, int week, String slot, float price){
      this.LessonID = id;
      this.LessonName = name;
      this.Day = day;
      this.Week = week;
      this.Slot = slot;
      this.price = price;
      this.Bookings = new ArrayList<Booking>();
   }
   
   public void addBooking(Booking booking){
      this.Bookings.add(booking);
   }
   public int getId(){
      return LessonID;
   }
   public String getDay(){
      return Day;
   }
   public String getName(){
      return LessonName;
   }
   public String getSlot(){
      return Slot;
   }
   public void removeBooking(Booking booking){
      this.Bookings.remove(booking);
   }
   public boolean checkbookingslots(){
      if (Bookings.size() == 4){
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
   public float getRating(){
      return Rating;
   }
   public ArrayList<String> getReview(){
      return Review;
   }
   public float getPrice(){
      return price;
   }
   public void setPrice(float price){
      this.price = price;
   }
   public int getweek(){
      return Week;
   }
}