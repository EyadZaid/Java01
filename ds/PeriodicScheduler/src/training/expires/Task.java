package training.expires;

import training.expires.policies.DelayCalculator;
import training.expires.policies.DelayPolicy;
import training.expires.policies.RunDelay;
import training.expires.policies.RunImmediately;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Task implements Runnable{
    private final Runnable userRunnable;
    private final Lock guard;
    private final Condition running;
    private final DelayPolicy delayPolicy;
    private long periodNano;
    private long lastDuration;
    private long durationRun;
    private TaskStatus status;
    private DelayCalculator delayCalculator;
    private final ITaskInfoObserver observer;


    public Task(Runnable userRunnable, long period, TimeUnit unit, DelayPolicy delayPolicy, ITaskInfoObserver observer) {
        this.userRunnable = userRunnable;
        this.periodNano = unit.toNanos(period);
        this.delayPolicy = delayPolicy;
        this.observer = observer;
        status = TaskStatus.RUNNING;
        guard = new ReentrantLock();
        running = guard.newCondition();
        lastDuration = -1;
        initDelayCalculator();
    }

    private void executeTask() {
        observer.onTaskStart(periodNano, delayPolicy);

        switch (delayPolicy) {

            case IMMEDIATELY -> runTaskImmediately();

            case DELAY -> runTaskDelay();
        }

        observer.onTaskEnd(lastDuration);
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
                guard.unlock();

                executeTask();
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

    private static void delay(long durationNano) {
        long durMillis = TimeUnit.NANOSECONDS.toMillis(durationNano);
        try {
            Thread.sleep(durMillis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void runTaskImmediately() {
        long start = System.nanoTime();
        try {
            userRunnable.run();
        }
        catch(Exception e){
            observer.onException(e);
        }
        observer.onTaskCompleted();
        lastDuration = durationRun;
        durationRun = System.nanoTime() - start;
        long waitTime = delayCalculator.calculateWaitTime(durationRun, periodNano);
        delay(waitTime);
    }

    private void runTaskDelay() {
        long start;
        if (lastDuration == -1) {
            start = System.nanoTime();

            try {
                userRunnable.run();
            }catch(Exception e){
                observer.onException(e);
            }

            durationRun = System.nanoTime() - start;
            long waitTime = delayCalculator.calculateWaitTime(durationRun, periodNano);
            delay(waitTime);
        }
        else {
            long waitTime = delayCalculator.calculateWaitTime(lastDuration, periodNano);
            delay(waitTime);

            start = System.nanoTime();
            try {
                userRunnable.run();
            }
            catch(Exception e){
                observer.onException(e);
            }
            durationRun = System.nanoTime() - start;
        }
        lastDuration = durationRun;
        observer.onTaskCompleted();
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

    private void initDelayCalculator() {
        switch (delayPolicy) {
            case IMMEDIATELY -> delayCalculator = new RunImmediately();

            case DELAY -> delayCalculator = new RunDelay();
        }
    }

    public String getInfo() {
        return observer.toString();
    }

}
