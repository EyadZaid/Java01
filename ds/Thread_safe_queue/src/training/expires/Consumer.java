package training.expires;

import java.util.ArrayList;
import java.util.List;

public class Consumer implements Runnable{
    private final ThreadSafeQueue<Integer> queue;
    private final List<Integer> result;

    public Consumer(ThreadSafeQueue<Integer> queue) {
        if (queue == null){
            throw new IllegalStateException();
        }
        this.queue = queue;
        this.result = new ArrayList<>();
    }

    @Override
    public void run() {
        while (true) {
            var num = queue.dequeue();
            if (num == -1){
                break;
            }
            result.add(num);
        }
    }

    public List<Integer> getResult() {
        return result;
    }
}
