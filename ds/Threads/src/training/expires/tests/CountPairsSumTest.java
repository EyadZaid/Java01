package training.expires.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import training.expires.CountPairsSum;

import static org.junit.jupiter.api.Assertions.*;

class CountPairsSumTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void countTwoPairsWithSumFive() {
        int[] arr = {3, 1, 9, 4, 5, 2, 8};

        CountPairsSum countPairsSum = new CountPairsSum();

        int count = countPairsSum.countPairsWithSum(arr, 5, 3);
        assertEquals(2, count);
    }


    @Test
    void countOnePairsWithSumThree() {
        int[] arr = {1, 3, 2, 2, 2, 4};

        CountPairsSum countPairsSum = new CountPairsSum();

        int count = countPairsSum.countPairsWithSum(arr, 3, 3);
        assertEquals(1, count);
    }

    @Test
    void countPairsWithSumThreeWithNegative() {
        int[] arr = {1, 3, 2, 2, 2, 4, 7, 5, 19, -4, 46, -2, -56};

        CountPairsSum countPairsSum = new CountPairsSum();

        int count = countPairsSum.countPairsWithSum(arr, 3, 5);
        assertEquals(3, count);
    }

    @Test
    void countPairsWithSumEmptyArray() {
        int[] arr = {};

        CountPairsSum countPairsSum = new CountPairsSum();

        int count = countPairsSum.countPairsWithSum(arr, 3, 3);
        assertEquals(0, count);
    }
}