package training.expires;

import java.util.Objects;

public class Pair<T> {
    private T firstItem;
    private T secondItem;

    public Pair(T firstItem, T secondItem) {
        this.firstItem = firstItem;
        this.secondItem = secondItem;
    }

    public T getFirstItem() {
        return firstItem;
    }

    public void setFirstItem(T firstItem) {
        this.firstItem = firstItem;
    }

    public T getSecondItem() {
        return secondItem;
    }

    public void setSecondItem(T secondItem) {
        this.secondItem = secondItem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pair)) return false;
        Pair<?> pair = (Pair<?>) o;
        return Objects.equals(firstItem, pair.firstItem) && Objects.equals(secondItem, pair.secondItem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstItem, secondItem);
    }
}
