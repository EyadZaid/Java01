package com.experis.tests;

import com.experis.MergeLists;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MergeListsTest {

    @Test
    void mergeLists() {
        var l1 = Arrays.asList(1, 5, 9, 10, 15, 20);
        var l2 = Arrays.asList(2, 3, 8, 13);

        System.out.println(MergeLists.mergeLists(l1, l2));

    }
}