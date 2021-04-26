package training.expires;

import java.util.concurrent.ScheduledThreadPoolExecutor;

public class ScheduledThreadPool {
    ScheduledThreadPoolExecutor threadPool;

    public ScheduledThreadPool() {
        this.threadPool = new ScheduledThreadPoolExecutor(2);
    }

    public void testScheduledThreadPool() {
        var w = new Runnable(){
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.printf("working %d on thread %d\n", i+1, Thread.currentThread().getId());
                    sleep(200);
                }
            }
        };


        Runnable task1 = new WorkerThread(w);
        Runnable task2 = new WorkerThread(w);

        threadPool.execute(task1);
        threadPool.execute(task2);

        try {
            Thread.sleep(3000);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        threadPool.shutdown();
    }

    private static void sleep(int n) {
        try {
            Thread.sleep(n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
