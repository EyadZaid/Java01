package training.expires;

import java.util.Arrays;

public class ArraySort implements Runnable {
    public int[] array;
    private int middle;

    public ArraySort(int[] array) {
        this.array = array;
        this.middle = array.length / 2;
    }

    @Override
    public void run() {
        ArraySort arrLeft = new ArraySort(subArray(array, 0, middle));
        ArraySort arrRight = new ArraySort(subArray(array, middle, array.length));

        Thread tLeft = new Thread(arrLeft);
        Thread tRight = new Thread((arrRight));

        tRight.start();
        tLeft.start();

        try {
            tLeft.join();
            tRight.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        merge(arrLeft.array, arrRight.array);
    }

    private void merge(int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        int[] temp = new int[array.length];
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                temp[k] = left[i];
                i++;
            } else {
                temp[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < left.length) {
            temp[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length) {
            temp[k] = right[j];
            j++;
            k++;
        }
        array = temp;
    }


    public int[] subArray(int[] array, int from, int to) {
        return Arrays.copyOfRange(array, from, to + 1);
    }

}