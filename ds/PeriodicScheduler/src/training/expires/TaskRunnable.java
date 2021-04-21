package training.expires;

import java.util.concurrent.TimeUnit;

public class TaskRunnable implements Runnable{
    private final Task task;
    private final long period;
    private final TimeUnit unit;

    public TaskRunnable(Task task, long period, TimeUnit unit) {
        this.task = task;
        this.period = period;
        this.unit = unit;
    }

    @Override
    public void run() {
        while (task.getStatus() == TaskStatus.RUNNING) {
            long start = System.nanoTime();
            task.execute();
            long timeSpan = System.nanoTime() - start;

            long timeSleep =  unit.toNanos(period) - timeSpan;
            if (timeSleep < 0) {
                timeSleep = 0;
            }

            try {
                Thread.sleep(TimeUnit.NANOSECONDS.toMillis(timeSleep));
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
