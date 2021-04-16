package training.expires.tests;

import org.junit.jupiter.api.Test;
import training.expires.ArraySummary;

import java.util.Random;

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
        Random rng = new Random();
        int[] arr = new int[100];
        int sum = 0;
        for (int i=0; i<arr.length; i++){
            int rndNum = rng.nextInt(1000 - 10)  + 10;
            arr[i] = rndNum;
            sum += rndNum;
        }

        ArraySummary arraySummary = new ArraySummary(arr);

        assertEquals(sum, arraySummary.summary());
    }

    @Test
    void emptyArrayTest(){
        int[] arr = {};

        ArraySummary arraySummary = new ArraySummary(arr);

        assertEquals(0, arraySummary.summary());
    }

}