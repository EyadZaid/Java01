package com.experis.tests;

import com.experis.NumPowerOfEight;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumPowerOfEightTest {

    @Test
    void checkNumPowerOf8() {
        boolean expected = NumPowerOfEight.checkNumPowerOf8(64 * 64 * 64);
        assertTrue(expected);
    }

    @Test
    void checkNumPowerOfEight() {
        boolean expected = NumPowerOfEight.checkNumPowerOfEight(64 * 64 * 64);
        assertTrue(expected);
    }
}