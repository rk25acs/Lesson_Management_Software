package classbookingapp;
import java.util.*;


public class BookingSystem {
    private List<Booking> bookings;
    private List<Customer> customers;
    private Timetable timetable;
    private static int idCounter = 1;

    public BookingSystem(Timetable timetable){
        this.timetable = timetable;
        this.bookings = new ArrayList<Booking>();
        this.customers = new ArrayList<Customer>();
        
    }
    public void addCustomers(Customer customer) {
        customers.add(customer);
    }
    public int getcounter(){
        return customers.size();
    }
    public List<Customer> getCustomers() {
        return customers;
    }
    public Customer getCustomer(int id) {
        for (Customer customer : customers) {
            if (customer.getCustomerID() == id) {
                return customer;
            }
        }
        return null; // Return null if customer not found
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

    public void bookLesson(int cid, int lid){
        Lessons lesson = timetable.getLessons().stream().filter(l -> l.getId() == lid).findFirst().orElse(null);
        if (lesson != null && lesson.checkbookingslots()) {
            Booking booking = new Booking(idCounter++, lesson, customers.get(cid-1));
            bookings.add(booking);
            customers.get(cid-1).addLesson(booking);
            lesson.addBooking(booking);
            System.out.println("Lesson booked successfully!");
        } else {
            System.out.println("Lesson not found or no available slots!");
        }
    }

    public void cancelBooking(int cid, int lid){
        for (Booking booking : bookings) {
            if (booking.getCustomer().get(0).getCustomerID() == cid && booking.lesson.getId() == lid) {
                booking.status = "Cancelled";
                booking.lesson.removeBooking(booking);
                booking.getCustomer().get(0).removeLesson(booking);
                System.out.println("Booking cancelled successfully!");
                return;
            }
        }
        System.out.println("Booking not found!");
    }

    public void attendLesson(int cid, int lid){
        for (Booking booking : bookings) {
            if (booking.getCustomer().get(0).getCustomerID() == cid && booking.lesson.getId() == lid) {
                booking.status = "Attended";
                System.out.println("Lesson attended successfully!");
                return;
            }
        }
        System.out.println("Booking not found!");
    }

    public void giveReview(int cid, int lid, String review){
        for (Booking booking : bookings) {
            if (booking.getCustomer().get(0).getCustomerID() == cid && booking.lesson.getId() == lid && booking.getStatus().equals("Attended")) {
                booking.lesson.addReview(review);
                System.out.println("Review added successfully!");
                return;
            }
        }
        System.out.println("Booking not found!");
    }
    
    public void giveRating(int cid, int lid, float rating){
        for (Booking booking : bookings) {
            if (booking.getCustomer().get(0).getCustomerID() == cid && booking.lesson.getId() == lid && booking.getStatus().equals("Attended")) {
                booking.lesson.addRating(rating);
                System.out.println("Rating added successfully!");
                return;
            }
        }
        System.out.println("Booking not found!");
    }
}
