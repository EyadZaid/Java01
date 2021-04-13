package training.expires;

import java.util.Arrays;

public class ArraySummary {
    private int[] array;

    public ArraySummary(int[] array) {
        this.array = array;
    }

    public int summary(){
        int middle = array.length/2;
        int[] arrLeft = subArray(array, 0, middle-1);
        int[] arrRight = subArray(array, middle, array.length-1);

        SumRunnable sortLeft = new SumRunnable(arrLeft);
        SumRunnable sortRight = new SumRunnable(arrRight);


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

        return sortLeft.getSum() + sortRight.getSum();
    }

    private int[] subArray(int[] array, int from, int to) {
        return Arrays.copyOfRange(array, from, to + 1);
    }


    private class SumRunnable implements Runnable{
        private int[] array;
        private int sum;

        public SumRunnable(int[] array) {
            this.array = array;
            this.sum = 0;
        }

        @Override
        public void run() {
            for (var e : array){
                sum += e;
            }
        }

        public int getSum() {
            return sum;
        }
    }
}
