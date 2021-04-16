package training.expires;

import java.util.HashMap;

public class CountPairsSum {
    private HashMap<Integer, Integer> hashMap;


    public CountPairsSum() {
        this.hashMap = new HashMap<>();
    }


    public int countPairsWithSum(int[] arr, int sum, int nThreads){
        int sizeArr = arr.length;
        if (sizeArr < 1){
            return 0;
        }
        if (nThreads > sizeArr) {
            nThreads = sizeArr;
        }
        int segment = sizeArr / nThreads;
        int leftOver = sizeArr % nThreads;

        CountPairsRunnable[] finds = new CountPairsRunnable[nThreads+1];
        for (int i=0; i<nThreads; i++){
            finds[i] = new CountPairsRunnable(arr, i*segment, i*segment + segment, hashMap);
        }
        finds[nThreads] = new CountPairsRunnable(arr, sizeArr-leftOver, sizeArr, hashMap);

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
        return getPairsCount(arr, sum);
    }

    private int getPairsCount(int[] arr, int sum) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            Integer key = sum - arr[i];
            if (hashMap.get(key) != null) {
                count++;
                hashMap.remove(key);
                hashMap.remove(arr[i]);
            }
        }
        return count;
    }
    private class CountPairsRunnable implements Runnable{
        private final int[] array;
        private final int start;
        private final int end;
        private HashMap<Integer, Integer> hashMap;

        public CountPairsRunnable(int[] array, int start, int end, HashMap<Integer, Integer> hashMap) {
            this.array = array;
            this.start = start;
            this.end = end;
            this.hashMap = hashMap;
        }

        @Override
        public void run() {
            for (int i = start; i< end; i++){
                if (!hashMap.containsKey(array[i])) {
                    hashMap.put(array[i], 1);
                }
            }
        }
    }

}
