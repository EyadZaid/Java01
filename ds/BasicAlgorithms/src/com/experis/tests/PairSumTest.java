package com.experis.tests;

import com.experis.PairSum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PairSumTest {

    @Test
    void pairEqualSum() {
        int[] arr = {0,10,-5,30,25,50,60,71,-11,55,91};
        System.out.println();
        PairSum.pairEqualSum(arr, 55);
    }

    @Test
    void pairEqualSumWithSort() {
        int[] arr = {0,10,-5,30,25,50,60,71,-11,55,91};
        System.out.println();
        PairSum.pairEqualSumWithSort(arr, 55);
    }
}