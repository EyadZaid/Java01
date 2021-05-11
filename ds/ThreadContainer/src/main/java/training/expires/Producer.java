package training.expires;

import java.util.List;

public class Producer<T> implements Runnable{
    private final ThreadSafeContainer<T> container;
    private final List<T> list;

    public Producer(ThreadSafeContainer<T> container, List<T> list) {
        this.container = container;
        this.list = list;
    }

    @Override
    public void run() {
        for (var e : list) {
            container.put(e);
        }
    }
}
