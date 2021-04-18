package training.expires;

public class ThreadSafeQueue<T> {
    private final T[] data;
    private final int capacity;
    private boolean present;
    private final Object lock;
    private int size;
    private int front;
    private int rear;

    public ThreadSafeQueue(int capacity) {
        this.capacity = capacity;
        data = (T[]) new Object[capacity];
        size = 0;
        front = 0;
        rear = capacity - 1;
        present = false;
        lock = new Object();
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return size == capacity;
    }

    public void enqueue(T item){
        synchronized (lock) {
            while(present){
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            rear = (rear + 1) % capacity;
            data[rear] = item;
            size++;

            if (isFull()) {
                present = true;
                lock.notify();
            }
        }
    }

    public T dequeue() {
        synchronized (lock) {
            while(!present){
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            T item = data[front];
            front = (front + 1) % capacity;
            size--;

            if (isEmpty()) {
                present = false;
                lock.notify();
            }

            return item;
        }
    }

}
