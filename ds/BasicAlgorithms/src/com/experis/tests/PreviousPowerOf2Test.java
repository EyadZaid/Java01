package com.experis.tests;

import com.experis.PreviousPowerOf2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PreviousPowerOf2Test {

    @Test
    void prevPowOf2() {
        int actual = PreviousPowerOf2.prevPowOf2(23);
        assertEquals(16, actual);

        int actual2 = PreviousPowerOf2.prevPowOf2(33);
        assertEquals(32, actual2);

        int actual3 = PreviousPowerOf2.prevPowOf2(1);
        assertEquals(1, actual3);

    }
}