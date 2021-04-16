package training.expires.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import training.expires.ArraySort;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class ArraySortTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void arraySortTestSmallArray() {
        int[] arr = {3, 6, 8, 2, 4, 1, 0, 7, 5, 6};
        int[] arrExpected = {0, 1, 2, 3, 4, 5, 6, 6, 7, 8};

        ArraySort arraySort = new ArraySort(arr);
        int[] sortedArr = arraySort.sort();

        for (int i=0; i<arr.length; i++){
            assertEquals(arrExpected[i], sortedArr[i]);
        }
    }

    @Test
    void arraySortTestRandomArray() {
        Random rng = new Random();
        int[] arr = new int[100];
        int[] arrExpected = new int[100];
        for (int i=0; i<arr.length; i++){
            int rnd = rng.nextInt(1000 - 10)  + 10;
            arr[i] = rnd;
            arrExpected[i] = rnd;
        }

        ArraySort arraySort = new ArraySort(arr);
        int[] sortedArr = arraySort.sort();
        Arrays.sort(arrExpected);

        for (int i=0; i<arr.length; i++){
            assertEquals(arrExpected[i], sortedArr[i]);
        }
    }


    @Test
    void arraySortTestEmptyArray() {
        int[] arr = {};

        ArraySort arraySort = new ArraySort(arr);
        int[] sortedArr = arraySort.sort();

        assertEquals(0, sortedArr.length);
    }
}