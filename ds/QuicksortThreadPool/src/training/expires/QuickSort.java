package training.expires;

import java.util.Arrays;

public class QuickSort<T extends Comparable<T>> {
    private final T[] arr;

    public QuickSort(T[] arr) {
        this.arr = arr;
    }

    public void sort() {
        quickSort(0, arr.length-1);
    }

    private void quickSort(int start, int end) {
        if (start < end) {
            int pivot = partition(start, end);

            quickSort(start, pivot - 1);
            quickSort(pivot + 1, end);
        }
    }

    private int partition(int start, int end) {
        T pivot = arr[end];
        int i = (start - 1);

        for(int j = start; j <= end - 1; j++) {
            if (arr[j].compareTo(pivot) < 0) {
                i++;
                swap(i, j);
            }
        }
        swap(i + 1, end);
        return (i + 1);
    }


    private void swap(int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    @Override
    public String toString() {
        return Arrays.toString(arr);
    }
}
