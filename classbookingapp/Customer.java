package classbookingapp;

import java.util.ArrayList;

public class Customer{
    private String customerName;
    private ArrayList<String> BookedLessons = new ArrayList<String>();

    public void getCname(){
        System.out.println(customerName);
    }
    public void setCname(String name){
        this.customerName = name;
    }
    public void getBookedLessons(){
        System.out.println(BookedLessons);
    }
    public void addLesson(String lesson){
        this.BookedLessons.add(lesson);
    }
    public void removeLesson(String lesson){
        this.BookedLessons.remove(lesson);
    }
}