package training.expires;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Task implements Runnable{
    private final Runnable userRunnable;
    private final Lock guard;
    private final Condition running;
    private long periodNano;
    private TaskStatus status;

    public Task(Runnable userRunnable, long period, TimeUnit unit) {
        this.userRunnable = userRunnable;
        this.periodNano = unit.toNanos(period);
        status = TaskStatus.RUNNING;
        guard = new ReentrantLock();
        running = guard.newCondition();
    }

    private void executeTask(long period) {
        long start = System.nanoTime();

        try {
            userRunnable.run();
        }catch(Throwable t){

        }

        long timeSpan = System.nanoTime() - start;
        long waitTimeNano =  period - timeSpan;

        if (waitTimeNano < 0) {
            waitTimeNano = 0;
        }

        long waitTimeMillis = TimeUnit.NANOSECONDS.toMillis(waitTimeNano);
        try {
            Thread.sleep(waitTimeMillis);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
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
                if(status == TaskStatus.STOPPED){
                    break;
                }
                var period = periodNano;
                guard.unlock();

                executeTask(period);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                guard.lock();
            }
        }

        guard.unlock();
    }


    public void stop() {
        guard.lock();
        try {
            this.status = TaskStatus.STOPPED;
            running.signal();
        }
        finally {
            guard.unlock();
        }
    }

    public void resume() {
        guard.lock();
        try {
            if(status == TaskStatus.SUSPENDED) {
                this.status = TaskStatus.RUNNING;
                running.signal();
            }
        }
        finally {
            guard.unlock();
        }
    }

    public void suspend() {
        guard.lock();
        try {
            this.status = TaskStatus.SUSPENDED;
        }
        finally {
            guard.unlock();
        }
    }

    public void reschedule(long period, TimeUnit unit) {
        guard.lock();
        try {
            periodNano = unit.toNanos(period);
            resume();
        }
        finally {
            guard.unlock();
        }
    }
}
