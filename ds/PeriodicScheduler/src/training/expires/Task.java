package training.expires;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Task implements Runnable{
    private final Runnable runnable;
    private final Lock guard;
    private final Condition running;
    private TaskStatus status;
    private long period;
    private TimeUnit unit;


    public Task(Runnable runnable, long period, TimeUnit unit) {
        this.runnable = runnable;
        this.period = period;
        this.unit = unit;
        status = TaskStatus.RUNNING;
        guard = new ReentrantLock();
        running = guard.newCondition();
    }

    private void executeTask() {
        long start = System.nanoTime();

        runnable.run();

        long timeSpan = System.nanoTime() - start;
        long waitTimeNano =  unit.toNanos(period) - timeSpan;

        if (waitTimeNano < 0) {
            waitTimeNano = 0;
        }

        try {
            running.awaitNanos(waitTimeNano);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void updateStatus(TaskStatus status) {
        guard.lock();
        try {
            this.status = status;
        }
        finally {
            guard.unlock();
        }
    }

    public void setPeriodAndUnit(long period, TimeUnit unit) {
        guard.lock();
        try {
            this.period = period;
            this.unit = unit;
        }
        finally {
            guard.unlock();
        }
    }

    @Override
    public void run() {
        guard.lock();
        while (status != TaskStatus.STOPPED) {
            try {
                while (status == TaskStatus.SUSPENDED) {
                    running.await();
                }
                guard.unlock();
                executeTask();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                guard.unlock();
            }
        }
        guard.unlock();
    }






}
