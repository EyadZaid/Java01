package com.experis.tests;

import com.experis.SortSpecialArray;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SortSpecialArrayTest {

    @Test
    void sortArr() {
        var arr = new int[] {2, 1, 1, 1, 2, 0, 0, 1, 2, 1, 2};
        SortSpecialArray.sortArr(arr);
        System.out.println(Arrays.toString(arr));
    }
}