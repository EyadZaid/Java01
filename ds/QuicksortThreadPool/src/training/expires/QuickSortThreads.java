package training.expires;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class QuickSortThreads<T extends Comparable<T>> extends RecursiveTask<T> {
    private final T[] arr;
    private final int start;
    private final int end;

    public QuickSortThreads(T[] arr) {
        this(0, arr.length-1, arr);
    }

    private QuickSortThreads(int start, int end, T[] arr) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    public void sort() {
        ForkJoinPool pool = ForkJoinPool.commonPool();
        pool.invoke(new QuickSortThreads<>(start, end, arr));
    }

    private int partition(int start, int end) {
        int i = start, j = end;
        int pivot = new Random().nextInt(end - start) + start;

        swap(pivot, j);
        j--;

        while (i <= j) {
            if (arr[i].compareTo(arr[end]) <= 0) {
                i++;
                continue;
            }
            if (arr[j].compareTo(arr[end]) >= 0) {
                j--;
                continue;
            }
            swap(i, j);
            j--;
            i++;
        }

        swap(end, j+1);
        return j + 1;
    }


    @Override
    protected T compute() {
        if (start >= end)
            return null;

        int p = partition(start, end);

        QuickSortThreads<T> left = new QuickSortThreads<>(start, p - 1, arr);
        QuickSortThreads<T> right = new QuickSortThreads<>(p + 1, end, arr);

        left.fork();
        right.compute();
        left.join();

        return null;
    }

    private void swap(int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
