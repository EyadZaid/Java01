package com.experis.tests;

import com.experis.CountDistinct;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountDistinctTest {

    @Test
    void distinctCount() {
        int[] arr = {-4, -4, -1, 0, 1, 2, 3, 3, 4, 4, 4, 6, 10};
        int count = CountDistinct.CountDistinctNumbers(arr);
        assertEquals(7, count);
    }
}