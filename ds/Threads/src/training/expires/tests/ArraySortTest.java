package training.expires.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import training.expires.ArraySort;

import static org.junit.jupiter.api.Assertions.*;

class ArraySortTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void arraySortTest() {
        int[] arr = {3, 6, 8, 2, 4, 1, 0, 7, 5, 6};
        int[] arrExpected = {0, 1, 2, 3, 4, 5, 6, 6, 7, 8};

        ArraySort arraySort = new ArraySort(arr);
        int[] sortedArr = arraySort.sort();

        for (int i=0; i<arr.length; i++){
            System.out.println(sortedArr[i]);
            assertEquals(arrExpected[i], sortedArr[i]);
        }
    }
}