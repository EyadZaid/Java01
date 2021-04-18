package training.expires;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ThreadSafeQueueTest {
    private ThreadSafeQueue<Integer> queue;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        queue = new ThreadSafeQueue<>(100);
    }

    @Test
    void FIFOTest_oneThread() {
        for (int i=0; i<10; i++){
            queue.enqueue(i);
        }

        for (int i=0; i<10; i++){
            assertEquals(i, queue.dequeue());
        }
    }

    @Test
    void twoThreadTest() {
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

        assertArrayEquals(list.toArray(), consumer.getResult().toArray());
    }


    @Test
    void nThreadTest() {
        /*
        int n = 10;
        int m = 5;
        Producer[] producers = new Producer[n];
        Consumer[] consumers = new Consumer[m];
        Thread[] threads = new Thread[n + m];

        for (int i=0; i<n; i++){
            producers[i] = new Producer(queue, i+1);
            threads[i] = new Thread(producers[i]);
        }

        for (int i=0; i<m; i++){
            consumers[i] = new Consumer(queue, i+1);
            threads[i + n] = new Thread(consumers[i]);
        }


        for (int i=0; i<threads.length; i++){
            threads[i].start();
        }
         */
    }

    private List<Integer> generateList(int size){
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<size; i++){
            list.add(i);
        }
        return list;
    }


}