package training.expires;

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
}
