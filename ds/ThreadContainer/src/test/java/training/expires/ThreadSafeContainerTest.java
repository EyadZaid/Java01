package training.expires;

import org.junit.Test;

import static org.junit.Assert.*;

public class ThreadSafeContainerTest {

    @org.junit.Before
    public void setUp() throws Exception {
    }

    @Test
    public void threadContainerTest() {
        var container = new ThreadSafeContainer<String>();

        container.put("A", 1);
        container.put("D", 2);
        container.put("B", 1);
        container.put("E", 2);
        container.put("X", 3);
        container.put("C", 1);
        container.put("Y", 3);

        String[] expected1 = {"A", "B"};
        var actual = container.get();
        assertArrayEquals(expected1, actual);

        String[] expected2 = {"D", "E"};
        actual = container.get();
        assertArrayEquals(expected2, actual);

        String[] expected3 = {"X", "Y"};
        actual = container.get();
        assertArrayEquals(expected3, actual);
    }

    @Test
    public void put() {
    }

    @Test
    public void get() {
    }


}