package training.expires;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MaxElementTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.Test
    void maxElementInList() {
        var list = Arrays.asList(8, 6, 2, 23, -13, 4);
        int n = 3826;
        var v1= Integer.valueOf(n);
        var v2= Integer.valueOf(n);
        list.set(1,v1);
        list.set(4, v2);
        assertEquals(v2, Utils.maxElementInList(list));
    }
}