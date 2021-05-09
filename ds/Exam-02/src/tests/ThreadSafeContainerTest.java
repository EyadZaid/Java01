package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import training.expires.ThreadSafeContainer;

import static org.junit.jupiter.api.Assertions.*;

class ThreadSafeContainerTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void threadContainerTest() {
        var container = new ThreadSafeContainer<String>();

        container.put("A", 1);
        container.put("B", 1);
        container.put("C", 1);

        container.put("D", 2);
        container.put("E", 2);

        container.put("X", 3);

        String[] expected = {"A", "B"};
        var actual = container.get();
        assertArrayEquals(expected, actual);

        String[] expected2 = {"D", "E"};
        actual = container.get();
        assertArrayEquals(expected2, actual);




    }
}