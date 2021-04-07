package training.expires;

public class MinAndMax<T extends Comparable> {
    private T min;
    private T max;

    public MinAndMax(T min, T max) {
        this.min = min;
        this.max = max;
    }

    public T getMin() {
        return min;
    }

    public T getMax() {
        return max;
    }

    @Override
    public String toString() {
        return "MinAndMax{" +
                "min=" + min +
                ", max=" + max +
                '}';
    }
}
