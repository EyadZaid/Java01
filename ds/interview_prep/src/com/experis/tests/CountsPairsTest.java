package com.experis.tests;

import com.experis.CountsPairs;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountsPairsTest {

    @Test
    void countsPairsBits() {
        String binaryString="00011001110101";
        long decimal = Long.parseLong(binaryString, 2);

        int expected = CountsPairs.countsPairsBits(decimal);
        assertEquals(3, expected);
    }
}