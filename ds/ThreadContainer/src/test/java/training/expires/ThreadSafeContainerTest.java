package training.expires;

import org.junit.Test;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class ThreadSafeContainerTest {
    private ThreadSafeContainer<Integer> container;
    private ExecutorService pool;

    @org.junit.Before
    public void setUp() throws Exception {
        container = new ThreadSafeContainer<Integer>();
        pool = Executors.newFixedThreadPool(3);
    }

    @Test
    public void threadContainerTest() {
        var list1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        var list2 = Arrays.asList(100, 200, 300, 400, 500, 600, 700, 800, 900, 1000);

        Producer<Integer> prod1 = new Producer<>(container, list1);
        Producer<Integer> prod2 = new Producer<>(container, list2);

        Consumer<Integer> consumer = new Consumer<>(container, 4);

        pool.execute(prod1);
        pool.execute(prod2);
        pool.execute(consumer);
        pool.shutdown();
        try {
            pool.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(consumer.getList());
    }

    /*
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
*/

}