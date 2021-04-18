package training.expires;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ThreadSafeQueueTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @Test
    void FIFOTest() {
        ThreadSafeQueue<Integer> queue = new ThreadSafeQueue<>(10);

        for (int i=0; i<10; i++){
            queue.enqueue(i);
        }

        for (int i=0; i<10; i++){
            assertEquals(i, queue.dequeue());
        }
    }
}