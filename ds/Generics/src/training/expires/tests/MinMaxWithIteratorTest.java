package training.expires.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import training.expires.Utils;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxWithIteratorTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void minAndMaxAdvancedWithIterator_Even() {
        var list = Arrays.asList(8, 6, 2, 23, -13, 4);
        int n1 = -698;
        int n2 = 1516;
        var v1= Integer.valueOf(n1);
        var v2= Integer.valueOf(n2);
        list.set(1,v1);
        list.set(4, v2);
        assertEquals(v1, Utils.MinAndMaxAdvancedWithIterator(list).getMin());
        assertEquals(v2, Utils.MinAndMaxAdvancedWithIterator(list).getMax());
    }


    @Test
    void minAndMaxAdvancedWithIterator_Odd() {
        var list = Arrays.asList(15, 6, 2, 23, -13, 4, 5);
        int n1 = -698;
        int n2 = 1516;
        var v1= Integer.valueOf(n1);
        var v2= Integer.valueOf(n2);
        list.set(1,v1);
        list.set(6, v2);
        assertEquals(v1, Utils.MinAndMaxAdvancedWithIterator(list).getMin());
        assertEquals(v2, Utils.MinAndMaxAdvancedWithIterator(list).getMax());
    }
}