package training.expires.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import training.expires.ArraySummary;
import training.expires.CountPairsSum;

import static org.junit.jupiter.api.Assertions.*;

class CountPairsSumTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void countPairsWithSum() {
        int[] arr = {3, 1, 9, 4, 5, 2, 8};

        CountPairsSum countPairsSum = new CountPairsSum();

        int count = countPairsSum.countPairsWithSum(arr, 5, 3);
        assertEquals(2, count);
    }
}