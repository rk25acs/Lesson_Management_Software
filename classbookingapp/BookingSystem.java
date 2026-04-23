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
        Iterator<Booking> iterator = bookings.iterator();
        while (iterator.hasNext()) {
            Booking booking = iterator.next();
            if (booking.getCustomer().getCustomerID() == cid && booking.getLesson().getId() == lid) {
                iterator.remove(); // ✅ safe
                customers.get(cid - 1).removeLesson(booking);
                booking.getLesson().removeBooking(booking);

        System.out.println("Booking cancelled successfully!");
        return;
    }
}
        System.out.println("Booking not found!");
    }

    public void attendLesson(int cid, int lid){
        for (Booking booking : bookings) {
            if (booking.getCustomer().getCustomerID() == cid && booking.getLesson().getId() == lid) {
                booking.setStatus("Attended");
                System.out.println("Lesson attended successfully!");
                return;
            }
        }
        System.out.println("Booking not found!");
    }

    public void giveReview(int cid, int lid, String review){
        for (Booking booking : bookings) {
            if (booking.getCustomer().getCustomerID() == cid && booking.getLesson().getId() == lid && booking.getStatus().equals("Attended")) {
                booking.getLesson().addReview(review);
                System.out.println("Review added successfully!");
                return;
            }
        }
        System.out.println("Booking not found!");
    }

    public void giveRating(int cid, int lid, float rating){
        for (Booking booking : bookings) {
            if (booking.getCustomer().getCustomerID() == cid && booking.getLesson().getId() == lid && booking.getStatus().equals("Attended")) {
                booking.getLesson().addRating(rating);
                System.out.println("Rating added successfully!");
                return;
            }
        }
        System.out.println("Booking not found!");
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

    public void AddedBookings(){

        bookLesson(1, 1);
        bookLesson(1,4);
        bookLesson(1,13);;
        bookLesson(1,16);
        bookLesson(1,25);
        bookLesson(1,28);
        bookLesson(1,37);
        bookLesson(1,40);
        bookLesson(1,49);

        bookLesson(2,8);
        bookLesson(2,10);
        bookLesson(2,20);
        bookLesson(2,22);
        bookLesson(2,32);
        bookLesson(2,34);
        bookLesson(2,43);
        bookLesson(2, 45);

        bookLesson(3, 5);
        bookLesson(3, 10);
        bookLesson(3, 12);
        bookLesson(3, 17);
        bookLesson(3, 22);
        bookLesson(3, 24);
        bookLesson(3, 29);

        bookLesson(4, 5);
        bookLesson(4, 6);
        bookLesson(4, 11);
        bookLesson(4, 12);
        bookLesson(4, 17);
        bookLesson(4, 18);
        bookLesson(4, 23);
        bookLesson(4, 24);
        bookLesson(4, 29);
        bookLesson(4, 30);
        bookLesson(4, 35);
        bookLesson(4, 36);
        bookLesson(4, 41);
        bookLesson(4, 42);

        bookLesson(5, 1);
        bookLesson(5, 7);
        bookLesson(5, 13);
        bookLesson(5, 19);
        bookLesson(5, 25);
        bookLesson(5, 31);


        bookLesson(6, 3);
        bookLesson(6, 15);
        bookLesson(6, 27);
        bookLesson(6, 39);

        bookLesson(7, 2);
        bookLesson(7, 14);
        bookLesson(7, 26);

        bookLesson(8, 5);
        bookLesson(8, 6);
        bookLesson(8, 17);
        bookLesson(8, 18);
        bookLesson(8, 29);
        bookLesson(8, 30);

        bookLesson(9, 1);
        bookLesson(9, 8);
        bookLesson(9, 15);
        bookLesson(9, 22);
        bookLesson(9, 29);
        bookLesson(9, 36);

        bookLesson(10, 1);
        bookLesson(10, 2);
        bookLesson(10, 3);
        bookLesson(10, 4);
        bookLesson(10, 5);
        bookLesson(10, 6);
        bookLesson(10, 7);
        bookLesson(10, 13);
        bookLesson(10, 19);
        bookLesson(10, 25);

        bookLesson(11, 3);
        bookLesson(11, 6);
        bookLesson(11, 9);
        bookLesson(11, 12);
        bookLesson(11, 15);
        bookLesson(11, 18);
        bookLesson(11, 21);
        bookLesson(11, 24);
        bookLesson(11, 27);
        bookLesson(11, 30);


        bookLesson(12, 2);
        bookLesson(12, 9);
        bookLesson(12, 14);
        bookLesson(12, 21);
        bookLesson(12, 26);
        bookLesson(12, 33);
        bookLesson(12, 38);
    }
}