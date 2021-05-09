package training.expires;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ThreadSafeContainer<T> {
    private final Map<Integer, Queue<T>> container;
    private final List<Integer> threadsID;

    public ThreadSafeContainer() {
        this.container = new ConcurrentHashMap<>();
        this.threadsID = new ArrayList<>();
    }

    public void put(T item, int threadID) {
        var queue = container.get(threadID);
        if (queue == null) {
            Queue<T> q = new LinkedList<>();
            q.add(item);
            container.put(threadID, q);
        }
        else {
            queue.add(item);
        }

        if (!threadsID.contains(threadID)) {
            threadsID.add(threadID);
        }
    }

    public Object[] get() {
        Object[] twoItems = new Object[2];

        for (var id : threadsID) {
            var queue = container.get(id);
            if (queue.size() > 1) {
                twoItems[0] = queue.remove();
                twoItems[1] = queue.remove();
                return twoItems;
            }
        }
        return twoItems;  ///////////////////// wait()
    }

}
