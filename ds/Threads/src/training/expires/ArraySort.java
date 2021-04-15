package training.expires;

public class ArraySort {
    public int[] array;


    public ArraySort(int[] array) {
        this.array = array;
    }


    public int[] sort(){
        int middle = array.length/2;

        SortRunnable sortLeft = new SortRunnable(array, 0, middle - 1);
        SortRunnable sortRight = new SortRunnable(array, middle, array.length - 1);

        Thread tLeft = new Thread(sortLeft);
        Thread tRight = new Thread(sortRight);

        tLeft.start();
        tRight.start();

        try {
            tLeft.join();
            tRight.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        merge(array, 0, middle - 1, middle, array.length - 1);
        return array;
    }


    private void merge(int[] arr, int startFirst, int endFirst, int startSecond, int endSecond) {
        int i = startFirst, j = startSecond, k = 0;
        int[] temp = new int[array.length];
        while (i <= endFirst && j <= endSecond) {
            if (array[i] < array[j]) {
                temp[k] = array[i];
                i++;
            } else {
                temp[k] = array[j];
                j++;
            }
            k++;
        }
        while (i <= endFirst) {
            temp[k] = array[i];
            i++;
            k++;
        }
        while (j <= endSecond) {
            temp[k] = array[j];
            j++;
            k++;
        }
        array = temp;
    }


    private class SortRunnable implements Runnable{
        private int[] array;
        private final int startIndex;
        private final int endIndex;

        public SortRunnable(int[] array, int startIndex, int endIndex) {
            this.array = array;
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }

        @Override
        public void run() {
            bubbleSort(array, startIndex, endIndex);
        }

        private void bubbleSort(int arr[], int start, int end) {
            int i, j;
            int size = end - start + 1;
            boolean swapped;
            for (i = 0; i < size - 1; i++) {
                swapped = false;
                for (j = start; j < end - i; j++) {
                    if (arr[j] > arr[j + 1]) {
                        swap(arr, j, j+1);
                        swapped = true;
                    }
                }
                if (swapped == false)
                    break;
            }
        }

        private void swap(int arr[], int a, int b){
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }

    }

}