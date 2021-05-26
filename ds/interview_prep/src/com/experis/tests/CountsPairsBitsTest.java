package com.experis.tests;

import com.experis.CountsPairsBits;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountsPairsBitsTest {

    @Test
    void countsPairsBits() {
        String binaryString="00011001110101";
        long decimal = Long.parseLong(binaryString, 2);

        int expected = CountsPairsBits.countsPairsBits(decimal);
        assertEquals(3, expected);
    }

    @Test
    void countsPairsBitsPart2() {
        String binaryString="00011001110101";
        long decimal = Long.parseLong(binaryString, 2);

        int expected = CountsPairsBits.countsPairsBits2(decimal);
        assertEquals(3, expected);
    }

    @Test
    void countsPairsBitsConsecutive() {
        String binaryString="00011001110101";
        long decimal = Long.parseLong(binaryString, 2);

        int expected = CountsPairsBits.countsPairsBitsConsecutive(decimal);
        assertEquals(2, expected);
    }
}