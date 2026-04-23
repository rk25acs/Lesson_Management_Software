package classbookingapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BookingAppTest {

    @Test
    void testAddition() {
        assertEquals(4, 2 + 2);
    }

    @Test
    void testBoolean() {
        assertTrue(5 > 3);
    }

    @Test
    void testString() {
        assertEquals("hello", "he" + "llo");
    }
}