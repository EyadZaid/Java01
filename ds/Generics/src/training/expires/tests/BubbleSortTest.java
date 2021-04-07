package training.expires.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import training.expires.Utils;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void bubbleSortList() {
        var list = Arrays.asList(8, 6, 2, 23, -13, 4);
        var sortedList = Arrays.asList(-13, 2, 4, 6, 8, 23);
        Assertions.assertEquals(sortedList, Utils.bubbleSortList(list));
    }
}