package training.expires.tests;

import org.junit.jupiter.api.Test;
import training.expires.Utils;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ListGeneratorTest {

    @Test
    void listGenerator() {
        var list = Utils.listGenerator(0, 3, 6);
        var li = Arrays.asList(0.0, 3.0, 6.0, 9.0, 12.0, 15.0);
        assertEquals(li, list);
    }
}