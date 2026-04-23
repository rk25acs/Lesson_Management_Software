package src.classbookingapp;

public class Booking {
    private int Bookingid;
    private Customer customer;
    String status;
    Lessons lesson;

    public Booking(int id, Lessons lesson, Customer customer){
        this.Bookingid = id;
        this.lesson = lesson;
        this.customer = customer;
        this.status = "Booked";
    }

    public void getBookingid(){
        System.out.println(Bookingid);
    }
    public Lessons getLesson(){
        return lesson;
    }
    public Customer getCustomer(){
        return customer;
    }
    public String getStatus(){
        return this.status;
    }
    public void setStatus(String status){
        this.status = status;
    }
}
