package training.expires;

import java.util.ArrayList;
import java.util.List;

public class Consumer implements Runnable{
    private final ThreadSafeQueue<Integer> queue;
    private final List<Integer> result;
    private final int number;

    public Consumer(ThreadSafeQueue<Integer> queue, int number) {
        if (queue == null || number < 1){
            throw new IllegalStateException();
        }
        this.queue = queue;
        this.result = new ArrayList<>();
        this.number = number;
    }

    @Override
    public void run() {
        for (int i=0; i<number; i++){
            result.add(queue.dequeue());
        }
    }

    public List<Integer> getResult() {
        return result;
    }
}
