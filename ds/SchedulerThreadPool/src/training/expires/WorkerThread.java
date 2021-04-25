package training.expires;

public class WorkerThread implements Runnable{
    private final Runnable userRunnable;

    public WorkerThread(Runnable userRunnable) {
        this.userRunnable = userRunnable;
    }

    @Override
    public void run() {
        userRunnable.run();

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
