package training.expires;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ThreadSafeQueueTest {
    private ThreadSafeQueue<Integer> queue;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        queue = new ThreadSafeQueue<>(10);
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
        Producer producer1 = new Producer(queue, 1);
        Consumer consumer1 = new Consumer(queue, 1);

        Thread tProducer1 = new Thread(producer1);
        Thread tConsumer1 = new Thread(consumer1);

        tProducer1.start();
        tConsumer1.start();
    }


    @Test
    void nThreadTest() {
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
    }
}