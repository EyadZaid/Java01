package training.expires;

import java.util.concurrent.TimeUnit;

public class TaskRunnable implements Runnable{
    private final Task task;
    private final long period;
    private final TimeUnit unit;
    private boolean active;

    public TaskRunnable(Task task, long period, TimeUnit unit) {
        this.task = task;
        this.period = period;
        this.unit = unit;
        this.active = true;
    }

    @Override
    public void run() {
        while (task.getStatus() == TaskStatus.RUNNING) {
            long start = System.nanoTime();
            task.execute();
            long timeSpan = System.nanoTime() - start;

            long timeSleep_nano =  unit.toNanos(period) - timeSpan;
            if (timeSleep_nano < 0) {
                timeSleep_nano = 0;
            }

            long timeSleep_millis = TimeUnit.NANOSECONDS.toMillis(timeSleep_nano);
            try {
                Thread.sleep(timeSleep_millis);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void stop() {
        active = false;
    }






    /*
     @Override
    public void run() {
        while (active) {
            if (task.getStatus() == TaskStatus.STOPPED) {
                stop();
                break;
            }

            if (task.getStatus() == TaskStatus.RUNNING) {
                long start = System.nanoTime();
                task.execute();
                long timeSpan = System.nanoTime() - start;

                long timeSleep_nano =  unit.toNanos(period) - timeSpan;
                if (timeSleep_nano < 0) {
                    timeSleep_nano = 0;
                }

                long timeSleep_millis = TimeUnit.NANOSECONDS.toMillis(timeSleep_nano);
                try {
                    Thread.sleep(timeSleep_millis);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
     */

}
