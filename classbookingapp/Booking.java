package classbookingapp;

public class Booking {
    private int Bookingid;
    private Lessons lesson;
    private Customer customer;

    public void setBookingid(int id){
        this.Bookingid = id;
    }
    public void getBookingid(){
        System.out.println(Bookingid);
    }
    public void setLesson(Lessons lesson){
        this.lesson = lesson;
    }
    public void getLesson(){
        System.out.println(lesson);
    }
    public void setCustomer(Customer customer){
        this.customer = customer;
    }
    public void getCustomer(){
        System.out.println(customer);
    }
}
