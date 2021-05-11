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

        var expected1 = new Pair<>("A", "B");
        var actual = container.get();
        assertEquals(expected1, actual);

        var expected2 = new Pair<>("D", "E");
        actual = container.get();
        assertEquals(expected2, actual);

        var expected3 = new Pair<>("X", "Y");
        actual = container.get();
        assertEquals(expected3, actual);
    }

    @Test
    public void put() {
    }

    @Test
    public void get() {
    }


}