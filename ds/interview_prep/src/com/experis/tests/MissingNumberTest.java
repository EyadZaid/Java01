package com.experis.tests;

import org.junit.jupiter.api.Test;

import static com.experis.MissingNumber.missingNum;
import static org.junit.jupiter.api.Assertions.*;

public class MissingNumberTest {

    @Test
    public void testMissingNum() {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 9, 10, 11, 12 };

        assertEquals(8, missingNum(arr));
    }
}