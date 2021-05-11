package training.expires;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeContainer<T> {
    private final Map<Long, T> itemsMap;
    private final Queue<Pair<T>> readyPairs;
    private final Queue<Condition> havePairs;
    private final Lock lock;


    public ThreadSafeContainer() {
        itemsMap = new ConcurrentHashMap<>();
        readyPairs = new LinkedList<>();
        lock = new ReentrantLock();
        havePairs = new LinkedList<>();
    }

    public void put(T item) {
        long threadID = Thread.currentThread().getId();
        lock.lock();
        try {
            var firstItem = itemsMap.get(threadID);
            if (firstItem != null) {
                addPairToReadyPairs(firstItem, item);
                itemsMap.remove(threadID);
                signalWaiter();
            }
            else {
                itemsMap.put(threadID, item);
            }
        }
        finally {
            lock.unlock();
        }
    }

    public Pair<T> get() {
        lock.lock();
        try {
           var condition = lock.newCondition();
           havePairs.add(condition);
           if (havePairs.size() > 1) {
               condition.await();
           }

           if (readyPairs.isEmpty()) {
                condition.await();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            havePairs.remove();
            signalWaiter();
            lock.unlock();
        }

        return readyPairs.poll();
    }

    private void addPairToReadyPairs(T firstItem, T item) {
        Pair<T> pair = new Pair<>(firstItem, item);
        readyPairs.add(pair);
    }

    private void signalWaiter() {
        var havePair = havePairs.peek();
        if (havePair != null) {
            havePair.signal();
        }
    }

}