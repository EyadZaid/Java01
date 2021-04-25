package training.expires;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortThreadsTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void quickSortBigArrayTest() {
        var arr = generateArray(10_000);
        var expectedArr = Arrays.copyOfRange(arr, 0, arr.length);
        Arrays.sort(expectedArr);

        var quickSort = new QuickSortThreads<>(arr);
        quickSort.sort();

        assertArrayEquals(expectedArr, arr);
    }


    @Test
    void quickSortThreadTest() {
        Integer[] arr = {4, 9, 1, -2, 46, 98, 34, -16, 7, 6};
        Integer[] expectedArr = Arrays.copyOfRange(arr, 0, arr.length);
        Arrays.sort(expectedArr);

        QuickSortThreads<Integer> quickSort = new QuickSortThreads<>(arr);
        quickSort.sort();

        //System.out.println(Arrays.toString(arr));
        assertArrayEquals(expectedArr, arr);
    }


    private Integer[] generateArray(int size){
        Random rnd = new Random();
        Integer[] arr = new Integer[size];
        for (int i=0; i<size; i++){
            arr[i] = rnd.nextInt(size) - 100;
        }
        return arr;
    }
}