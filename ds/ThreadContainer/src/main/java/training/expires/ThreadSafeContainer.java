package training.expires;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeContainer<T> {
    private final Map<Long, Queue<T>> container;
    private final Queue<Long> threadsID;
    private final Lock lock;
    private final Condition havePairItems;


    public ThreadSafeContainer() {
        container = new ConcurrentHashMap<>();
        threadsID = new LinkedList<>();
        lock = new ReentrantLock();
        havePairItems = lock.newCondition();
    }

    public void put(T item, long threadID) {        // --threadID
        //long threadID = Thread.currentThread().getId();
        lock.lock();
        try {
            var queue = container.get(threadID);
            if (queue == null) {
                Queue<T> q = new LinkedList<>();
                q.add(item);
                container.put(threadID, q);
            }
            else {
                queue.add(item);
            }
            threadsID.add(threadID);
            havePairItems.signal();
        }
        finally {
            lock.unlock();
        }

    }

    public Object[] get() {
        Object[] twoItems = null;
        lock.lock();

        try {
            while (!checkHavePairItems()) {
                havePairItems.await();
            }

            twoItems = new Object[2];
            for (var id : threadsID) {
                var queue = container.get(id);
                if (queue.size() > 1) {
                    twoItems[0] = queue.remove();
                    twoItems[1] = queue.remove();
                    updateThreadsID(id);
                    return twoItems;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

        return twoItems;
    }

    private boolean checkHavePairItems() {
        for (var id : threadsID) {
            var queue = container.get(id);
            if (queue.size() > 1) {
                return true;
            }
        }
        return false;
    }

    private void updateThreadsID(long id) {
        threadsID.remove(id);
        threadsID.remove(id);
    }

}