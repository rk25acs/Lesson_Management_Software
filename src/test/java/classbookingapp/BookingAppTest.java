package classbookingapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;

public class BookingAppTest {
    private BookingSystem booking;
    private Timetable timetable;

    @BeforeEach
    void setup() {
        timetable = new Timetable();
        timetable.TTData();
        booking = new BookingSystem(timetable);
        booking.addCustomers(new Customer(1, "Test1"));
        booking.addCustomers(new Customer(2, "Test2"));
        booking.addCustomers(new Customer(3, "Test3"));
        booking.addCustomers(new Customer(4, "Test4"));
        booking.addCustomers(new Customer(5, "Test5"));
    }

    @Test
    void testbooking() {
        booking.bookLesson(1,1);

        assertEquals(1, booking.getCustomer(1).getBookedLessons().size());
    }

    @Test
    void testLessonFull(){
        for (int i = 2;i<5;i++){
            booking.bookLesson(i, 1);
        }
        //Trying to add 5th member to lesson
        booking.bookLesson(5, 1);
        assertNotEquals(5, booking.getBookings().get(0).getLesson().getAttendees());
    }

    @Test
    void testcancel(){
        int initial = booking.getCustomer(1).getBookedLessons().size();
        booking.bookLesson(1, 1);
        int middle = booking.getCustomer(1).getBookedLessons().size();
        booking.cancelBooking(1, 1);
        int fin = booking.getCustomer(1).getBookedLessons().size();

        assertEquals(initial, fin);
        assertNotEquals(middle, fin);

    }

    @Test
    void testlessonsbyname(){
        List<Lessons> name = timetable.getLessonsbyName("Yoga");
        List<Lessons> result = timetable.getLessonsbyName("zUmBA");

        assertTrue(name.stream().allMatch(l -> l.getName().equalsIgnoreCase("Yoga")));
        assertTrue(result.stream().allMatch(l -> l.getName().equalsIgnoreCase("Zumba")));
    }

    @Test
    void testAttendance(){
        booking.bookLesson(1, 1);
        booking.bookLesson(2, 1);
        booking.attendLesson(1, 1);
        booking.attendLesson(2, 1);
        assertEquals(2, booking.getAttendance(timetable.getLesson(1)));
    }
}