package training.expires;

public class TaskRunnable implements Runnable{
    private final Task task;
    private final long period;

    public TaskRunnable(Task task, long period) {
        this.task = task;
        this.period = period;
    }

    @Override
    public void run() {
        while (task.getStatus() == TaskStatus.RUNNING) {
            long start = System.currentTimeMillis();
            task.execute();
            long timeSpan = System.currentTimeMillis() - start;

            long timeSleep = period - timeSpan;
            if (timeSleep < 0) {
                timeSleep = 0;
            }

            try {
                Thread.sleep(timeSleep);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
