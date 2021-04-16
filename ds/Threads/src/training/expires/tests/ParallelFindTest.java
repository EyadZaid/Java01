package training.expires.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import training.expires.ArraySummary;
import training.expires.ParallelFind;

import static org.junit.jupiter.api.Assertions.*;

class ParallelFindTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void searchTest() {
        int[] arr = {3, 6, 8, 2, 4, 1, 0, 7, 5, 6};

        ParallelFind find = new ParallelFind();
        assertTrue(find.search(arr, 7, 2));
    }
}