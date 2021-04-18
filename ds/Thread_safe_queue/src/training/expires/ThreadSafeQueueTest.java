package training.expires;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ThreadSafeQueueTest {
    private ThreadSafeQueue<Integer> queue;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        queue = new ThreadSafeQueue<>(10000);
    }

    @Test
    void FIFOTest_oneThread() {
        for (int i=0; i<100; i++){
            queue.enqueue(i);
        }

        for (int i=0; i<100; i++){
            assertEquals(i, queue.dequeue());
        }
    }

    @Test
    void testWith_1producer_1consumer() {
        int n = 105;
        List<Integer> list = generateList(n);
        Producer producer = new Producer(queue, list);
        Consumer consumer = new Consumer(queue, n);

        Thread tProducer = new Thread(producer);
        Thread tConsumer = new Thread(consumer);

        tProducer.start();
        tConsumer.start();

        try {
            tProducer.join();
            tConsumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
            fail();
        }

        assertEquals(list.size(), consumer.getResult().size());
        assertArrayEquals(list.toArray(), consumer.getResult().toArray());
    }


    @Test
    void testWith_2producers_1consumer() {
        int n = 100;
        List<Integer> list = generateList(n);
        var tg = new ThreadGroup(2, () -> new Producer(queue, list) );
        tg.start();
        tg.join();

        Consumer consumer = new Consumer(queue, n);
        Thread tConsumer = new Thread(consumer);
        tConsumer.start();
        try {
            tConsumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
            fail();
        }

        System.out.println(list);
        System.out.println(consumer.getResult());

        assertEquals(list.size(), consumer.getResult().size());
        //assertArrayEquals(list.toArray(), consumer.getResult().toArray());

    }

    private List<Integer> generateList(int size){
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<size; i++){
            list.add(i);
        }
        return list;
    }


}