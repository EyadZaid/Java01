package training.expires.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import training.expires.ParallelFind;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class ParallelFindTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void searchTestSmallArray() {
        int[] arr = {3, 6, 8, 2, 4, 1, 0, 7, 5, 6};

        ParallelFind find = new ParallelFind();
        assertTrue(find.search(arr, 7, 2));
    }

    @Test
    void searchTestRandomArray() {
        Random rng = new Random();
        int[] arr = new int[100];
        int x = 23;
        for (int i=0; i<arr.length; i++){
            arr[i] = rng.nextInt(1000 - 10)  + 10;
        }
        arr[arr.length/2] = x;

        ParallelFind find = new ParallelFind();
        assertTrue(find.search(arr, x, 5));
    }

    @Test
    void searchTestEmptyArray() {
        int[] arr = {};

        ParallelFind find = new ParallelFind();
        assertFalse(find.search(arr, 0, 2));
    }
}