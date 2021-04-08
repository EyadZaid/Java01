package training.expires.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import training.expires.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MintWithIterator {

    @BeforeEach
    void setUp() {
    }

    @Test
    void minElementWithIterator() {
        var list = Arrays.asList(8, 6, 2, 23, -13, 4);
        int n = -698;
        var v1= Integer.valueOf(n);
        var v2= Integer.valueOf(n);
        list.set(1,v1);
        list.set(4, v2);
        assertEquals(v1, Utils.minElementWithIterator(list));
    }

    @Test
    void minElementWithIterator_OneElement() {
        List<Double> list = new ArrayList<>();
        list.add(10.0);
        double n = 10;
        var v1= Double.valueOf(n);
        list.set(0,v1);
        assertEquals(v1, Utils.minElementWithIterator(list));
    }
}