package training.expires.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import training.expires.NonRepeatingGeneric;
import training.expires.NonRepeatingNum;

import static org.junit.jupiter.api.Assertions.*;

class NonRepeatingGenericTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void first_non_repeatingTest() {
        String array[] = { "1", "5" ,"3", "4", "2", "9", "3", "1", "7", "5", "1","2"};
        assertEquals("4", NonRepeatingGeneric.first_non_repeating(array));
    }

    @Test
    void first_non_repeatingEmptyArrayTest() {
        String array[] = {};
        assertEquals(null, NonRepeatingGeneric.first_non_repeating(array));
    }

    @Test
    void first_non_repeatingOneItemInArrayTest() {
        String array[] = {"10"};
        assertEquals("10", NonRepeatingGeneric.first_non_repeating(array));
    }
}