package classbookingapp;

import java.util.ArrayList;

public class Customer{
    private String customerName;
    private ArrayList<Booking> BookedLessons = new ArrayList<Booking>();

    public void getCname(){
        System.out.println(customerName);
    }
    public void setCname(String name){
        this.customerName = name;
    }
    public void getBookedLessons(){
        System.out.println(BookedLessons);
    }
    public void addLesson(Booking lesson){
        this.BookedLessons.add(lesson);
    }
    public void removeLesson(Booking lesson){
        this.BookedLessons.remove(lesson);
    }
}