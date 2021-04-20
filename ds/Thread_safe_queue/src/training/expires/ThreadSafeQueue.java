package training.expires;

import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeQueue<T> {
    private final T[] data;
    private final int capacity;
    private int size;
    private int head;
    private int tail;
    private Lock lock;
    private Condition haveSomeItems;
    private Condition haveSomeVacancies;

    public ThreadSafeQueue(int capacity) {
        this.capacity = capacity;
        data = (T[]) new Object[capacity];
        size = 0;
        head = 0;
        tail = capacity - 1;
        lock = new ReentrantLock();
        haveSomeItems = lock.newCondition();
        haveSomeVacancies = lock.newCondition();
    }

    public int getSize(){
        lock.lock();
        int temp = size;
        lock.unlock();
        return temp;
    }

    public boolean isEmpty(){
        lock.lock();
        boolean temp = size == 0;
        lock.unlock();
        return temp;
    }

    public boolean isFull(){
        lock.lock();
        boolean temp = size == capacity;
        lock.unlock();
        return temp;
    }

    private boolean empty(){
        return size == 0;
    }

    private boolean full(){
        return size == capacity;
    }

    public void enqueue(T item){
        lock.lock();
        try {
            while(full()){
                haveSomeVacancies.await();
            }
            tail = (tail + 1) % capacity;
            data[tail] = item;
            size++;

            haveSomeItems.signal();

        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }

    public T dequeue() {
        T item = null;

        lock.lock();
        try {
            while(empty()){
                haveSomeItems.await();
            }

            item = data[head];
            head = (head + 1) % capacity;
            size--;

            haveSomeVacancies.signal();

        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }

        return item;
    }

    public void enqueue(Iterator<T> iterator) {
        lock.lock();
        while (iterator.hasNext()){
            enqueue(iterator.next());
        }
        lock.unlock();
    }

    public void enqueue(T... allItems) {
        enqueue(Arrays.stream(allItems).iterator());
    }

}
