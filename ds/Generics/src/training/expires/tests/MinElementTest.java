package training.expires.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import training.expires.Utils;

import java.util.Arrays;

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
}