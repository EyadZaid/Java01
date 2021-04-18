package training.expires;

public class Producer implements Runnable{
    private ThreadSafeQueue<Integer> queue;
    private final int number;

    public Producer(ThreadSafeQueue<Integer> queue, int number) {
        this.queue = queue;
        this.number = number;
    }

    @Override
    public void run() {
        for (int i=0; i<15; i++){
            queue.enqueue(i);
            System.out.println("Producer " + number + " enqueue: " + i);
        }
    }
}
