package training.expires.tests;

import org.junit.jupiter.api.Test;
import training.expires.Utils;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ListGeneratorTest {

    @Test
    void listGenerator() {
        var list = Utils.listGenerator(0, 3, 6, (a,b) -> a.intValue() + b.intValue());
        var li = Arrays.asList(0, 3, 6, 9, 12, 15);
        assertEquals(li, list);
    }
}