package training.expires;

public class ArraySummary {
    private final int[] array;

    public ArraySummary(int[] array) {
        this.array = array;
    }

    public int summary(){
        int middle = array.length/2;
        SumRunnable sumLeft = new SumRunnable(array, 0, middle - 1);
        SumRunnable sumRight = new SumRunnable(array, middle, array.length - 1);

        Thread tLeft = new Thread(sumLeft);
        Thread tRight = new Thread(sumRight);

        tRight.start();
        tLeft.start();

        try {
            tLeft.join();
            tRight.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return sumLeft.getSum() + sumRight.getSum();
    }


    private class SumRunnable implements Runnable{
        private final int[] array;
        private int sum;
        private final int startIndex;
        private final int endIndex;

        public SumRunnable(int[] array, int startIndex, int endIndex) {
            this.array = array;
            this.sum = 0;
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }

        @Override
        public void run() {
            for (int i=startIndex; i<=endIndex; i++){
                sum += array[i];
            }
        }

        public int getSum() {
            return sum;
        }
    }
}
