package com.experis.tests;

import com.experis.MultiValuedMap;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MultiValuedMapTest {

    @Test
    void testMultiValuedMap() {
        MultiValuedMap<Integer, Integer> mMap = new MultiValuedMap<>();
        mMap.put(4, 13);
        mMap.put(7, 17);
        mMap.put(4, 19);

        var expected = Arrays.asList(13, 19);

        assertEquals(expected, mMap.get(4));
    }
}