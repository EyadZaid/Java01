package training.expires.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import training.expires.Utils;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MidElementTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void midElementOfList() {
        var list = Arrays.asList(8, 6, 2, 23, -13, 4);
        int n = 99;
        var v1= Integer.valueOf(n);
        list.set(3,v1);
        Assertions.assertEquals(v1, Utils.midElementOfList(list));
    }
}