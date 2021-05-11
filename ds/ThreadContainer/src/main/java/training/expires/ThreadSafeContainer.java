package training.expires;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ThreadSafeContainer<T> {
    private final Map<Long, Queue<T>> container;
    private final Queue<Long> threadsID;


    public ThreadSafeContainer() {
        container = new ConcurrentHashMap<>();
        threadsID = new LinkedList<>();
    }

    public void put(T item, long threadID) {
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
    }

    public Object[] get() {
        Object[] twoItems = new Object[2];

        for (var id : threadsID) {
            var queue = container.get(id);
            if (queue.size() > 1) {
                twoItems[0] = queue.remove();
                twoItems[1] = queue.remove();
                updateThreadsID(id);
                return twoItems;
            }
        }
        return twoItems;  ///////////////////// wait()
    }

    private void updateThreadsID(long id) {
        threadsID.remove(id);
        threadsID.remove(id);
    }

}