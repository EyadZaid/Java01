package training.expires.tests;

import org.junit.jupiter.api.Test;
import training.expires.NonRepeatingGeneric;
import training.expires.NonRepeatingNum;

import static org.junit.jupiter.api.Assertions.*;

class NonRepeatingNumTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.Test
    void first_non_repeating_num() {
        int array[] = {1,5,3,4,2,9,3,1,7,5,1,2};
        assertEquals(4, NonRepeatingNum.first_non_repeating_num(array));
    }

    @Test
    void first_non_repeatingEmptyArrayTest() {
        int[] array = {};
        assertEquals(null, NonRepeatingNum.first_non_repeating_num(array));
    }

    @Test
    void first_non_repeatingOneItemInArrayTest() {
        int[] array = {10};
        assertEquals(10, NonRepeatingNum.first_non_repeating_num(array));
    }
}