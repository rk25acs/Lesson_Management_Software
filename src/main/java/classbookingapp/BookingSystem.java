package classbookingapp;
import java.util.*;

public class BookingSystem {
    private List<Booking> bookings;
    private List<Customer> customers;
    private Timetable timetable;
    private static int idCounter = 1;

    public BookingSystem(Timetable timetable) {
        this.timetable = timetable;
        this.bookings = new ArrayList<Booking>();
        this.customers = new ArrayList<Customer>();

    }

    public void addCustomers(Customer customer) {
        customers.add(customer);
    }

    public int getcounter() {
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

    public boolean checkLessonBooked(int cid, int lid) {
        for (Booking booking : bookings) {
            if (booking.getCustomer().getCustomerID() == cid && booking.getLesson().getId() == lid) {
                return true;
            }
        }
        return false;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void bookLesson(int cid, int lid) {
        Lessons lesson = timetable.getLessons().stream().filter(l -> l.getId() == lid).findFirst().orElse(null);
        if (lesson != null && lesson.checkbookingslots() && !checkLessonBooked(cid, lid)) {
            Booking booking = new Booking(idCounter++, lesson, customers.get(cid - 1));
            bookings.add(booking);
            customers.get(cid - 1).addLesson(booking);
            lesson.addBooking(booking);
            System.out.println("Lesson booked successfully!");
        } else {
            System.out.println("Lesson not found or no available slots!");
        }
    }

    public int cancelBooking(int cid, int lid) {
        Iterator<Booking> iterator = bookings.iterator();
        while (iterator.hasNext()) {
            Booking booking = iterator.next();
            if (booking.getCustomer().getCustomerID() == cid && booking.getLesson().getId() == lid && getifAttended(booking) == false) {
                iterator.remove(); 
                customers.get(cid - 1).removeLesson(booking);
                booking.getLesson().removeBooking(booking);

                System.out.println("Booking cancelled successfully!");
                return 1;
            }
        }
        System.out.println("Unable to cancel!");
        return 0;
    }

    public boolean getifAttended(Booking booking){
        if (booking.getStatus().equals("Attended")){
            return true;
        }
        return false;
    }
    public int attendLesson(int cid, int lid) {
        for (Booking booking : bookings) {
            if (booking.getCustomer().getCustomerID() == cid && booking.getLesson().getId() == lid && getifAttended(booking) == false) {
                booking.setStatus("Attended");
                System.out.println("Lesson attended successfully!");
                return 0;
            }
            else if(booking.getCustomer().getCustomerID() == cid && booking.getLesson().getId() == lid && getifAttended(booking)){
                System.out.println("Already attended this lesson!");
                return 1;
            }
        }
        System.out.println("Booking not found!");
        return 2;
    }

    public void giveReview(int cid, int lid, String review) {
        for (Booking booking : bookings) {
            if (booking.getCustomer().getCustomerID() == cid && booking.getLesson().getId() == lid && getifAttended(booking)) {
                booking.getLesson().addReview(review);
                System.out.println("Review added successfully!");
                return;
            }
        }
        System.out.println("Booking not found!");
    }

    public void giveRating(int cid, int lid, float rating) {
        for (Booking booking : bookings) {
            if (booking.getCustomer().getCustomerID() == cid && booking.getLesson().getId() == lid && getifAttended(booking)) {
                booking.getLesson().addRating(rating);
                System.out.println("Rating added successfully!");
                return;
            }
        }
        System.out.println("Booking not found!");
    }

    public int getAttendance(Lessons lesson) {
        int count = 0;

        for (Booking booking : bookings) {
            if ("Attended".equals(booking.getStatus()) &&
                    booking.getLesson().getId() == lesson.getId()) {

                count++;
            }
        }

        return count;
    }

    public float getTotalIncome(String lessonType) {
        float totalIncome = 0;

        for (Booking booking : bookings) {
            if ("Attended".equals(booking.getStatus()) &&
                    booking.getLesson().getName().equals(lessonType)) {

                totalIncome += booking.getLesson().getPrice();
            }
        }

        return totalIncome;
    }

    public void AddedCustomers() {
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

    public void AddedBookings() {

        bookLesson(1, 1);
        bookLesson(1, 4);
        bookLesson(1, 13);
        bookLesson(1, 16);
        bookLesson(1, 25);
        bookLesson(1, 28);
        bookLesson(1, 37);
        bookLesson(1, 40);
        bookLesson(1, 49);

        bookLesson(2, 8);
        bookLesson(2, 10);
        bookLesson(2, 20);
        bookLesson(2, 22);
        bookLesson(2, 32);
        bookLesson(2, 34);
        bookLesson(2, 43);
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

    public void AttendBookings() {
        attendLesson(1, 1);
        giveRating(1, 1, 5);
        giveReview(1, 1, "Easy to understand and follow along with the instructor. Highly recommend!");
        attendLesson(1, 4);
        giveRating(1, 4, 4);
        giveReview(1, 4, "Good lesson, but could use more examples.");
        attendLesson(1, 13);
        giveRating(1, 13, 3);
        giveReview(1, 13, "A bit too fast for my pace.");
        attendLesson(1, 16);
        giveRating(1, 16, 4);
        giveReview(1, 16, "Great lesson, but could use more interactive elements.");

        attendLesson(2, 8);
        giveRating(2, 8, 4);
        giveReview(2, 8, "Good introduction to the topic.");
        attendLesson(2, 10);
        giveRating(2, 10, 5);
        attendLesson(2, 20);
        giveRating(2, 20, 3);
        giveReview(2, 20, "Could use more real-world examples.");
        attendLesson(2, 22);
        giveRating(2, 22, 4);

        attendLesson(3, 5);
        giveRating(3, 5, 4);
        giveReview(3, 5, "Good lesson, but could use more examples.");
        attendLesson(3, 10);
        giveRating(3, 10, 5);
        attendLesson(3, 12);
        giveRating(3, 12, 3);
        attendLesson(3, 17);
        giveRating(3, 17, 4);
        giveReview(3, 17, "Good lesson, but could use more examples.");
        attendLesson(3, 22);
        giveRating(3, 22, 5);
        attendLesson(3, 24);
        giveRating(3, 24, 4);

        attendLesson(4, 5);
        giveRating(4, 5, 4);
        attendLesson(4, 6);
        giveRating(4, 6, 5);
        attendLesson(4, 11);
        giveRating(4, 11, 3);
        giveReview(4, 11, "Decent, but could use more examples.");
        attendLesson(4, 12);
        giveRating(4, 12, 4);
        attendLesson(4, 17);
        giveRating(4, 17, 5);
        attendLesson(4, 18);
        giveRating(4, 18, 4);
        attendLesson(4, 23);
        giveRating(4, 23, 5);
        giveReview(4, 23, "Great Lesson!");
        attendLesson(4, 24);
        giveRating(4, 24, 4);

        attendLesson(5, 1);
        giveRating(5, 1, 4);
        attendLesson(5, 7);
        giveRating(5, 7, 5);
        attendLesson(5, 13);
        giveRating(5, 13, 3);
        giveReview(5, 13, "Could use more real-world examples.");
        attendLesson(5, 19);
        giveRating(5, 19, 4);

        attendLesson(6, 3);
        giveRating(6, 3, 4);
        giveReview(6, 3, "Good lesson, but could use more examples.");
        attendLesson(6, 15);
        giveRating(6, 15, 5);

        attendLesson(7, 2);
        giveRating(7, 2, 4);
        attendLesson(7, 14);
        giveRating(7, 14, 5);
        giveReview(7, 14, "Great lesson, very informative.");

        attendLesson(8, 5);
        giveRating(8, 5, 4);
        attendLesson(8, 6);
        giveRating(8, 6, 4);
        giveReview(8, 6, "Good lesson, but could use more examples.");
        attendLesson(8, 17);
        giveRating(8, 17, 4);
        attendLesson(8, 18);
        giveRating(8, 18, 5);
        giveReview(8, 18, "Great Lesson!");

        attendLesson(9, 1);
        giveRating(9, 1, 4);
        attendLesson(9, 8);
        giveRating(9, 8, 5);
        attendLesson(9, 15);
        giveRating(9, 15, 4);
        attendLesson(9, 22);
        giveRating(9, 22, 5);
        giveReview(9, 22, "Great lesson, very informative.");

        attendLesson(10, 1);
        giveRating(10, 1, 4);
        attendLesson(10, 2);
        giveRating(10, 2, 5);
        giveReview(10, 2, "Really enjoyed this class!");
        attendLesson(10, 3);
        giveRating(10, 3, 4);
        attendLesson(10, 4);
        giveRating(10, 4, 5);
        attendLesson(10, 5);
        giveRating(10, 5, 3);
        giveReview(10, 5, "Average this week.");
        attendLesson(10, 6);
        giveRating(10, 6, 5);
        attendLesson(10, 7);
        giveRating(10, 7, 4);
        attendLesson(10, 13);
        giveRating(10, 13, 5);
        giveReview(10, 13, "Great lesson!");
        attendLesson(10, 19);
        giveRating(10, 19, 2);
        giveReview(10, 19, "Decent lesson I guess.");

        attendLesson(11, 3);
        giveRating(11, 3, 4);
        attendLesson(11, 6);
        giveRating(11, 6, 5);
        attendLesson(11, 9);
        giveRating(11, 9, 4);
        attendLesson(11, 12);
        giveRating(11, 12, 5);
        giveReview(11, 12, "Very Informative!");
        attendLesson(11, 15);
        giveRating(11, 15, 4);
        attendLesson(11, 18);
        giveRating(11, 18, 5);
        attendLesson(11, 21);
        giveRating(11, 21, 4);
        attendLesson(11, 24);
        giveRating(11, 24, 5);
        giveReview(11, 24, "Super Fun!!");

        attendLesson(12, 2);
        giveRating(12, 2, 4);
        attendLesson(12, 9);
        giveRating(12, 9, 5);
        attendLesson(12, 14);
        giveRating(12, 14, 4);
        attendLesson(12, 21);
        giveRating(12, 21, 5);
        giveReview(12, 21, "Great lesson!");

    }
}