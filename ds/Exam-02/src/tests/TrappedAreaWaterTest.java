package tests;

import org.junit.jupiter.api.Test;
import training.expires.TrappedAreaWater;

import static org.junit.jupiter.api.Assertions.*;

class TrappedAreaWaterTest {

    @Test
    void trappedAreaTest() {
        int[] arr = { 1, 2, 0, 1, 4, 3, 1, 2, 6, 1, 3};

        int actual = TrappedAreaWater.trappedArea(arr);
        assertEquals(11, actual);


        int[] arr2 = { 1, 2, 0, 1, 5, 8, 1, 2, 6, 1, 3};

        actual = TrappedAreaWater.trappedArea(arr2);
        assertEquals(14, actual);
    }
}