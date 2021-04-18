package training.expires;

import java.util.Iterator;
import java.util.List;

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

            rear = (rear + 1) % capacity;
            data[rear] = item;
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

            T item = data[front];
            front = (front + 1) % capacity;
            size--;
            lock.notifyAll();

            return item;
        }
    }

    public void enqueue(List<T> items) {
        synchronized (lock) {
            for (var i : items){
                enqueue(i);
            }
        }
    }

    public void enqueue(T... items) {
        synchronized (lock) {
            for (var i : items){
                enqueue(i);
            }
        }
    }
}
