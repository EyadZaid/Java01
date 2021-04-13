package training.expires;

public class ArraySummary implements Runnable{
    private int[] array;
    private int from;
    private int to;
    private int sum;

    public ArraySummary(int[] array, int from, int to) {
        this.array = array;
        this.from = from;
        this.to = to;
        this.sum = 0;
    }

    @Override
    public void run() {
        for (int i=from; i<to; i++){
            sum += array[i];
        }
    }

    public int getSum() {
        return sum;
    }
}
