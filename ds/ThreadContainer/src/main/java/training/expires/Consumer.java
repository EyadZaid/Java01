package training.expires;

import java.util.ArrayList;
import java.util.List;

public class Consumer<T> implements Runnable {
    private final ThreadSafeContainer<T> container;
    private final List<Pair<T>> list;
    private final int numOfGets;

    public Consumer(ThreadSafeContainer<T> container, int numOfGets) {
        this.container = container;
        this.list = new ArrayList<>();
        this.numOfGets = numOfGets;
    }

    @Override
    public void run() {
        for (int i=0; i<numOfGets; i++) {
            list.add(container.get());
        }
    }

    public List<Pair<T>> getList() {
        return list;
    }
}
