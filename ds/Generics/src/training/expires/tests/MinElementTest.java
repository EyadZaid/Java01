package training.expires.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import training.expires.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MinElementTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void minElementInList() {
        var list = Arrays.asList(8, 6, 2, 23, -13, 4);
        int n = -698;
        var v1= Integer.valueOf(n);
        var v2= Integer.valueOf(n);
        list.set(1,v1);
        list.set(4, v2);
        assertEquals(v1, Utils.minElementInList(list));
    }

    @Test
    void minElementInList_EmptyList() {
        List<Double> list = new ArrayList<>();
        assertEquals(null, Utils.minElementInList(list));
    }

    @Test
    void minElementInList_Duplicated() {
        List<Double> list = new ArrayList<>();
        list.add(10.0);
        list.add(10.0);
        list.add(10.0);
        list.add(10.5);
        double n = 10;
        var v1= Double.valueOf(n);
        var v2= Double.valueOf(n);
        list.set(0,v1);
        list.set(2, v2);
        assertEquals(v1, Utils.minElementInList(list));
    }

    @Test
    void minElementInList_OneElement() {
        List<Double> list = new ArrayList<>();
        list.add(10.0);
        double n = 10;
        var v1= Double.valueOf(n);
        list.set(0,v1);
        assertEquals(v1, Utils.minElementInList(list));
    }
}