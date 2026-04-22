package classbookingapp;

import java.util.ArrayList;

public class Customer{
    private String customerName;
    private int CustomerID;
    private ArrayList<Booking> BookedLessons = new ArrayList<Booking>();

    public Customer(int id, String name){
        this.customerName = name;
        this.CustomerID = id;
    }
    public int getCustomerID(){
        return CustomerID;
    }
    public String getCustomerName(){
        return customerName;
    }
    public void setCname(String name){
        this.customerName = name;
    }
    public ArrayList<Booking> getBookedLessons(){
        return BookedLessons;
    }
    public void addLesson(Booking lesson){
        this.BookedLessons.add(lesson);
    }
    public void removeLesson(Booking lesson){
        this.BookedLessons.remove(lesson);
    }
}