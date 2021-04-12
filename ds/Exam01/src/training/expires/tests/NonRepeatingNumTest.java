package training.expires.tests;

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
}