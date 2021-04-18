package training.expires;

public class ThreadSafeQueue<T> {
    private T[] data;
    private int capacity;
    private int size;

    public ThreadSafeQueue(int capacity) {
        this.capacity = capacity;
        this.data = (T[]) new Object[capacity];
    }


}
