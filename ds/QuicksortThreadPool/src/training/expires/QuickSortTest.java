package training.expires;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @Test
    void quickSortTest() {
        Integer[] arr = {4, 9, 1, -2, 46, 98, 34, -16, 7, 6};
        Integer[] expectedArr = Arrays.copyOfRange(arr, 0, arr.length);

        QuickSort<Integer> quickSort = new QuickSort<>(arr);

        quickSort.sort();

        Arrays.sort(expectedArr);

        assertArrayEquals(expectedArr, arr);
    }
}