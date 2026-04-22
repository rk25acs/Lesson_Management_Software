package classbookingapp;
import java.util.*;

public class Booking {
    private int Bookingid;
    private List<Customer> customers = new ArrayList<Customer>();
    private String status;
    private static int idCounter = 1;

    public Booking(int id, Lessons lesson, Customer customer){
        this.Bookingid = id;
        this.status = "Booked";
    }

    public List<Customer> getCustomers() {
        return customers;
    }
    public void addCustomers(Customer customer) {
        customers.add(customer);
    }

    public void AddedCustomers(){

        addCustomers(new Customer(idCounter++, "Ash"));
        addCustomers(new Customer(idCounter++, "Yui"));
        addCustomers(new Customer(idCounter++, "Naruto"));
        addCustomers(new Customer(idCounter++, "Deku"));
        addCustomers(new Customer(idCounter++, "Monica"));
        addCustomers(new Customer(idCounter++, "Rimuru"));
        addCustomers(new Customer(idCounter++, "Fran"));
        addCustomers(new Customer(idCounter++, "Miyamura"));
        addCustomers(new Customer(idCounter++, "Tomoe"));
        addCustomers(new Customer(idCounter++, "Rys"));
        addCustomers(new Customer(idCounter++, "Shoyo"));
        addCustomers(new Customer(idCounter++, "Shoko"));
    }

    public List<Customer> getCustomerList() {
        return customers;
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

    //booking a lesson
    public void bookLesson(int cid, int lid){
        if (lesson.checkbookingslots()){           

            Booking booking = new Booking(idCounter++, lesson, customer);

            customer.addLesson(booking);
            lesson.addBooking(booking);
            System.out.println("Lesson booked successfully!");
        }
    }

}
