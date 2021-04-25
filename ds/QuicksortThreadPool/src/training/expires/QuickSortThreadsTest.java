package training.expires;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortThreadsTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void quickSortBigArrayTest() {

    }


    @Test
    void quickSortThreadTest() {
        Integer[] arr = {4, 9, 1, -2, 46, 98, 34, -16, 7, 6};
        Integer[] expectedArr = Arrays.copyOfRange(arr, 0, arr.length);

        QuickSortThreads<Integer> quickSort = new QuickSortThreads<>(arr);

        quickSort.sort();

        Arrays.sort(expectedArr);

        //System.out.println(Arrays.toString(arr));
        assertArrayEquals(expectedArr, arr);
    }
}