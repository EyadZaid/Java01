package com.experis.tests;

import com.experis.PairSum;

import static org.junit.jupiter.api.Assertions.*;

class PairSumTest {

    @org.junit.jupiter.api.Test
    void pairEqualSum() {
        int[] arr = {0,10,-5,30,25,50,60,71,-11,55,91};
        PairSum.pairEqualSum(arr, 55);
    }
}