package training.expires.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import training.expires.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RemoveMinTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void removeMinInList() {
        List<Double> list = new ArrayList<>();
        list.add(10.0);
        list.add(5.2);
        list.add(4.3);
        list.add(20.5);
        double n = -698;
        var v1= Double.valueOf(n);
        var v2= Double.valueOf(n);
        list.set(0,v1);
        list.set(2, v2);
        assertEquals(v1, Utils.removeMinInList(list));
    }
}