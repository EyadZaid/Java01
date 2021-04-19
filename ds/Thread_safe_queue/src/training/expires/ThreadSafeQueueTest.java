package training.expires;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ThreadSafeQueueTest {
    private ThreadSafeQueue<Integer> queue;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }


    @Test
    void FIFOTest_oneThread() {
        queue = new ThreadSafeQueue<>(100);
        for (int i=0; i<100; i++){
            queue.enqueue(i);
        }

        for (int i=0; i<100; i++){
            assertEquals(i, queue.dequeue());
        }

        assertTrue(queue.isEmpty());
    }

    @Test
    void testWith_1producer_1consumer() {
        int capacity = 100;
        int n = 100000;
        queue = new ThreadSafeQueue<>(capacity);
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

        assertTrue(queue.isEmpty());
        assertEquals(list.size(), consumer.getResult().size());
        assertArrayEquals(list.toArray(), consumer.getResult().toArray());
    }

    @Test
    void testWith_2producers_1consumer() {
        int capacity = 1000;
        int enqueue_n = 10000;  //for 1 producer
        int dequeue_n = enqueue_n * 2;

        queue = new ThreadSafeQueue<>(capacity);
        List<Integer> list = generateList(enqueue_n);
        var tg = new ThreadGroup(2, () -> new Producer(queue, list) );
        tg.start();

        Consumer consumer = new Consumer(queue, dequeue_n);
        Thread tConsumer = new Thread(consumer);
        tConsumer.start();
        try {
            tg.join();
            tConsumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
            fail();
        }

        assertTrue(queue.isEmpty());
        assertEquals(dequeue_n, consumer.getResult().size());
        assertTrue(checkResultFor_2producers(list, consumer.getResult()));
    }


    private boolean checkResultFor_2producers(List<Integer> list, List<Integer> result) {
        int list_size = list.size();
        if (list_size * 2 != result.size()){
            return false;
        }

        List<Integer> list1 = new ArrayList<>(list);
        List<Integer> list2 = new ArrayList<>(list);

        int i = 0, j = 0;
        for (int k=0; k<result.size(); k++){
            if (result.get(k) == list1.get(i)){
                i = (i < list_size-1) ? (i + 1) : i;
            }
            else {
                if (result.get(k) == list2.get(j)){
                    j = (j < list_size-1) ? (j + 1) : j;
                }
                else {
                    return false;
                }
            }
        }

        return true;
    }

    private List<Integer> generateList(int size){
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<size; i++){
            list.add(i);
        }
        return list;
    }


}