package training.expires;

public class Main {

    public static void main(String[] args) {
        ThreadSafeQueue<Integer> queue = new ThreadSafeQueue<>(10);

        Producer producer1 = new Producer(queue, 1);
        Consumer consumer1 = new Consumer(queue, 1);

        Thread tProducer1 = new Thread(producer1);
        Thread tConsumer1 = new Thread(consumer1);

        tProducer1.start();
        tConsumer1.start();
    }
}
