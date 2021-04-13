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
        ArraySummary arrSum1 = new ArraySummary(arr, 0, 5);
        ArraySummary arrSum2 = new ArraySummary(arr, 5, arr.length);

        Thread t1 = new Thread(arrSum1);
        Thread t2 = new Thread(arrSum2);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int sum = arrSum1.getSum() + arrSum2.getSum();
        System.out.println(sum);
        assertEquals(42, sum);
    }
}