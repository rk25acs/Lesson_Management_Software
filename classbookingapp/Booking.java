package classbookingapp;
import java.util.*;

public class Booking {
    private int Bookingid;
    private String user;
    private List<Customer> customers = new ArrayList<Customer>();
    String status;
    private static int idCounter = 1;
    private List<Booking> bookings = new ArrayList<Booking>();
    Lessons lesson;

    public Booking(int id, Lessons lesson, Customer customer){
        this.Bookingid = id;
        this.lesson = lesson;
        this.user = customer.getCustomerName();
        this.status = "Booked";
    }

    public void getBookingid(){
        System.out.println(Bookingid);
    }

    public List<Customer> getCustomer(){
        return customers;
    }
    public String getStatus(){
        return this.status;
    }
}
