package training.expires;

import java.util.List;

public class Producer implements Runnable{
    private final ThreadSafeQueue<Integer> queue;
    private final List<Integer> list;

    public Producer(ThreadSafeQueue<Integer> queue, List<Integer> list) {
        if (queue == null || list == null){
            throw new IllegalStateException();
        }
        this.queue = queue;
        this.list = list;
    }

    @Override
    public void run() {
        for (int i=0; i<list.size(); i++){
            queue.enqueue(list.get(i));
        }
    }
}
