package training.expires;

import java.util.Arrays;

public class ArraySort {
    public int[] array;


    public ArraySort(int[] array) {
        this.array = array;
    }


    public int[] sort(){
        int middle = array.length/2;
        int[] arrLeft = subArray(array, 0, middle);
        int[] arrRight = subArray(array, middle, array.length);

        SortRunnable sortLeft = new SortRunnable(arrLeft);
        SortRunnable sortRight = new SortRunnable(arrRight);


        Thread tLeft = new Thread(sortLeft);
        Thread tRight = new Thread(sortRight);

        tRight.start();
        tLeft.start();

        try {
            tLeft.join();
            tRight.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        merge(arrLeft, arrRight);
        return array;
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


    class SortRunnable implements Runnable{
        private int[] array;

        public SortRunnable(int[] array) {
            this.array = array;
        }

        @Override
        public void run() {
            Arrays.sort(array);
        }

        public int[] getArray() {
            return array;
        }
    }

}