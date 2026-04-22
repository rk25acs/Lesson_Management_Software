package classbookingapp;
import java.util.*;

public class Booking {
    private int Bookingid;
    private List<Customer> customers = new ArrayList<Customer>();
    String status;
    Lessons lesson;

    public Booking(int id, Lessons lesson, Customer customer){
        this.Bookingid = id;
        this.lesson = lesson;
        customer.getCustomerName();
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
