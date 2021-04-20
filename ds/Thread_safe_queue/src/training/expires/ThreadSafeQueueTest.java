package training.expires;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ThreadSafeQueueTest {
    private ThreadSafeQueue<Integer> queue;

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
        Consumer consumer = new Consumer(queue);

        Thread tProducer = new Thread(producer);
        Thread tConsumer = new Thread(consumer);

        tProducer.start();
        tConsumer.start();

        try {
            tProducer.join();
            queue.enqueue(-1);
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
        int enqueue_n = 10000;  //10000 elements for each producer

        queue = new ThreadSafeQueue<>(capacity);
        List<Integer> list = generateList(enqueue_n);
        var tg = new ThreadGroup(2, () -> new Producer(queue, list));
        tg.start();

        Consumer consumer = new Consumer(queue);
        Thread tConsumer = new Thread(consumer);
        tConsumer.start();
        try {
            tg.join();
            queue.enqueue(-1);
            tConsumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
            fail();
        }

        assertTrue(queue.isEmpty());
        assertEquals(enqueue_n * 2, consumer.getResult().size());
        assertTrue(checkResults_2producers(list, consumer.getResult()));
    }

    @Test
    void testWith_1producer_2consumers() {
        int capacity = 1000;
        int enqueue_n = 10000;  //10000 for 1 producer

        queue = new ThreadSafeQueue<>(capacity);
        List<Integer> list = generateList(enqueue_n);

        Producer producer = new Producer(queue, list);
        Consumer consumer1 = new Consumer(queue);
        Consumer consumer2 = new Consumer(queue);

        Thread tProducer = new Thread(producer);
        Thread tConsumer1 = new Thread(consumer1);
        Thread tConsumer2 = new Thread(consumer2);

        tProducer.start();
        tConsumer1.start();
        tConsumer2.start();

        try {
            tProducer.join();
            queue.enqueue(-1);
            queue.enqueue(-1);
            tConsumer1.join();
            tConsumer2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
            fail();
        }

        assertTrue(queue.isEmpty());
        assertEquals(enqueue_n, consumer1.getResult().size() + consumer2.getResult().size());
        assertTrue(checkResults_2consumers(list, consumer1.getResult(), consumer2.getResult()));
    }

    @Test
    void testWith_nProducers_mConsumers() {
        int nProducers = 2;
        int mConsumers = 4;
        int capacity = 100;
        int enqueue_n = 100;  //100 elements for each producer

        queue = new ThreadSafeQueue<>(capacity);
        List<Integer> list = generateList(enqueue_n);
        var producers = new ThreadGroup(nProducers, () -> new Producer(queue, list));
        producers.start();

        Consumer[] consumers = new Consumer[mConsumers];
        Thread[] tConsumers = new Thread[mConsumers];

        for (int i=0; i<mConsumers; i++) {
            consumers[i] = new Consumer(queue);
            tConsumers[i] = new Thread(consumers[i]);
            tConsumers[i].start();
        }

        try {
            producers.join();
            for (int i=0; i<mConsumers; i++){
                queue.enqueue(-1);
            }
            for (var th : tConsumers){
                th.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            fail();
        }

        assertTrue(queue.isEmpty());

        List<List<Integer>> results = new ArrayList<>();
        for (var c : consumers) {
            results.add(c.getResult());
        }

        assertTrue(checkResults_nProd_mCons(list, results, nProducers));
    }


    private boolean checkResults_2producers(List<Integer> list, List<Integer> result) {
        int list_size = list.size();
        if (list_size * 2 != result.size()){
            return false;
        }

        int i = 0, j = 0;
        for (int k=0; k<result.size(); k++){
            if (result.get(k) == list.get(i)){
                i = (i < list_size-1) ? (i + 1) : i;
            }
            else {
                if (result.get(k) == list.get(j)){
                    j = (j < list_size-1) ? (j + 1) : j;
                }
                else {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean checkResults_2consumers(List<Integer> list, List<Integer> result1, List<Integer> result2) {
        if (list.size() != (result1.size() + result2.size())){
            return false;
        }
        int result1_size = result1.size();
        int result2_size = result2.size();

        int i = 0, j = 0;
        for (int k=0; k<list.size(); k++){
            if (list.get(k) == result1.get(i)){
                i = (i < result1_size-1) ? (i + 1) : i;
            }
            else {
                if (list.get(k) == result2.get(j)){
                    j = (j < result2_size-1) ? (j + 1) : j;
                }
                else {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean checkResults_nProd_mCons(List<Integer> list, List<List<Integer>> results, int nProducers) {
        int sizeAllResults = 0;

        for (var r : results){
            sizeAllResults += r.size();
        }

        if (list.size() * nProducers != sizeAllResults) {
            return false;
        }

        int[] values = new int[nProducers];
        Arrays.fill(values, 1);

        for (var res : results) {
            for (var r : res) {
                int index = findIndex(values, r);
                if (index != -1) {
                    values[index]++;
                }
                else {
                    return false;
                }
            }
        }
        return true;
    }

    private int findIndex(int arr[], int value) {
        for (int i=0; i<arr.length; i++){
            if (arr[i] == value){
                return i;
            }
        }
        return -1;
    }

    private List<Integer> generateList(int size){
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<size; i++){
            list.add(i+1);
        }
        return list;
    }


}