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

    private void quickSort(int low, int high) {
        if (low < high) {
            int pivot = partition(low, high);

            quickSort(low, pivot - 1);
            quickSort(pivot + 1, high);
        }
    }

    private int partition(int low, int high) {
        T pivot = arr[high];
        int i = (low - 1);

        for(int j = low; j <= high - 1; j++) {
            if (arr[j].compareTo(pivot) < 0) {
                i++;
                swap(i, j);
            }
        }
        swap(i + 1, high);
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
