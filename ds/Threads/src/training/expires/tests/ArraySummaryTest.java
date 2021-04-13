package training.expires.tests;

import org.junit.jupiter.api.Test;
import training.expires.ArraySummary;

import static org.junit.jupiter.api.Assertions.*;

class ArraySummaryTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @Test
    void arraySummaryTest(){
        int[] arr = {3, 6, 8, 2, 4, 1, 0, 7, 5, 6};  //Sum = 42

        ArraySummary arraySummary = new ArraySummary(arr);

        int sum = arraySummary.summary();
        assertEquals(42, sum);
    }


    @Test
    void largeArrayTest(){
        int[] arr = new int[1000000];
    }

}