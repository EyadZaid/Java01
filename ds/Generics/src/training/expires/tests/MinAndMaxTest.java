package training.expires.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import training.expires.Utils;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MinAndMaxTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void minAndMaxElementInList() {
        var list = Arrays.asList(8, 6, 2, 23, -13, 4);
        int n1 = -698;
        int n2 = 1516;
        var v1= Integer.valueOf(n1);
        var v2= Integer.valueOf(n2);
        list.set(1,v1);
        list.set(4, v2);
        assertEquals(v1, Utils.minAndMaxElementInList(list).getMin());
        assertEquals(v2, Utils.minAndMaxElementInList(list).getMax());
    }
}