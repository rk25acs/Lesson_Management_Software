package classbookingapp;

public class Booking {
    private int Bookingid;
    private Lessons lesson;
    private Customer customer;
    private String status;
    private static int idCounter = 1;

    public void getBookingid(){
        System.out.println(Bookingid);
    }
    public void getLesson(){
        System.out.println(lesson);
    }
    public void getCustomer(){
        System.out.println(customer);
    }
    public String getStatus(){
        return this.status;
    }

    public Booking(int id, Lessons lesson, Customer customer){
        this.Bookingid = id;
        this.lesson = lesson;
        this.customer = customer;
        this.status = "Booked";

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
