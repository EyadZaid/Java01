package training.expires;

public class Consumer implements Runnable{
    private ThreadSafeQueue<Integer> queue;
    private final int number;

    public Consumer(ThreadSafeQueue<Integer> queue, int number) {
        this.queue = queue;
        this.number = number;
    }

    @Override
    public void run() {
        for (int i=0; i<10; i++){
            System.out.println("Consumer " + number + " dequeue: " + queue.dequeue());
        }

    }
}
