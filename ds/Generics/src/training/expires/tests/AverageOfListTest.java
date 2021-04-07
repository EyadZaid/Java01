package training.expires.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import training.expires.Utils;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AverageOfListTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void averageOfList() {
        List<Double> list = new ArrayList<>();
        list.add(10.0);
        list.add(5.2);
        list.add(4.3);
        list.add(20.5);
        double result = 10;
        assertEquals(result, Utils.averageOfList(list));
    }
}