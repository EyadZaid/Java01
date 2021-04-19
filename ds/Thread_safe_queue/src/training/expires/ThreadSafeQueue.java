package training.expires;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ThreadSafeQueue<T> {
    private final T[] data;
    private final int capacity;
    private final Object lock;
    private int size;
    private int head;
    private int tail;

    public ThreadSafeQueue(int capacity) {
        this.capacity = capacity;
        data = (T[]) new Object[capacity];
        size = 0;
        head = 0;
        tail = capacity - 1;
        lock = new Object();
    }

    public int getSize(){
        synchronized (lock) {
            return size;
        }
    }

    public boolean isEmpty(){
        synchronized (lock) {
            return size == 0;
        }
    }

    public boolean isFull(){
        synchronized (lock) {
            return size == capacity;
        }
    }

    private boolean empty(){
        return size == 0;
    }

    private boolean full(){
        return size == capacity;
    }

    public void enqueue(T item){
        synchronized (lock) {
            while(full()){
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            tail = (tail + 1) % capacity;
            data[tail] = item;
            size++;
            lock.notifyAll();
        }
    }

    public T dequeue() {
        synchronized (lock) {
            while(empty()){
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            T item = data[head];
            head = (head + 1) % capacity;
            size--;
            lock.notifyAll();

            return item;
        }
    }

    public void enqueue(Iterator<T> iterator) {
        synchronized (lock) {
            while (iterator.hasNext()){
                enqueue(iterator.next());
            }
        }
    }

    public void enqueue(T... allItems) {
        enqueue(Arrays.stream(allItems).iterator());
    }
}
