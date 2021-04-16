package training.expires;

public class ParallelFind {

    public boolean search(int[] arr, int findElement, int nThreads){
        int sizeArr = arr.length;
        if (sizeArr < 1){
            return false;
        }
        if (nThreads > sizeArr || nThreads < 1) {
            nThreads = sizeArr;
        }
        int segment = sizeArr / nThreads;
        int leftOver = sizeArr % nThreads;

        FindRunnable[] finds = new FindRunnable[nThreads+1];
        for (int i=0; i<nThreads; i++){
            finds[i] = new FindRunnable(arr, findElement, i*segment, i*segment + segment);
        }
        finds[nThreads] = new FindRunnable(arr, findElement, sizeArr-leftOver, sizeArr);

        Thread[] tFinds = new Thread[nThreads+1];
        for (int i=0; i<finds.length; i++){
            tFinds[i] = new Thread(finds[i]);
            tFinds[i].start();
        }

        for (var thread : tFinds){
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (var e : finds){
            if (e.isExist){
                return true;
            }
        }
        return false;
    }


    private class FindRunnable implements Runnable{
        private final int[] array;
        private final int start;
        private final int end;
        private final int findElement;
        private boolean isExist;

        public FindRunnable(int[] array, int findElement, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
            this.findElement = findElement;
            this.isExist = false;
        }

        @Override
        public void run() {
            for (int i = start; i< end; i++){
                if (array[i] == findElement){
                    isExist = true;
                    break;
                }
            }
        }

        public boolean isExist() {
            return isExist;
        }
    }


}
