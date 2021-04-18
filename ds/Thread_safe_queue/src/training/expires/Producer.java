package training.expires;

public class Producer implements Runnable{
    private final ThreadSafeQueue<Integer> queue;
    private final int number;

    public Producer(ThreadSafeQueue<Integer> queue, int number) {
        if (queue == null || number < 1){
            throw new IllegalStateException();
        }
        this.queue = queue;
        this.number = number;
    }

    @Override
    public void run() {
        for (int i=0; i<number; i++){
            queue.enqueue(i);
        }
    }
}
