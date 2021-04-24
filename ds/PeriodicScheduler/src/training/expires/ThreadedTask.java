package training.expires;

import training.expires.policies.DelayPolicy;

import java.util.concurrent.TimeUnit;

class ThreadedTask {
    private Task task;
    private Thread thread;

    public ThreadedTask(Runnable runnable, long period, TimeUnit unit, DelayPolicy delayPolicy) {
        this.task = new Task(runnable, period, unit, delayPolicy);
        this.thread = new Thread(task);
        thread.start();
    }

    public Task getTask() {
        return task;
    }

    public Thread getThread() {
        return thread;
    }

    public void suspend() {
        task.suspend();
    }

    public void reschedule(long period, TimeUnit unit) {
        task.reschedule(period, unit);
    }

    public void stop() {
        task.stop();
        try {
            thread.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getInfo() {
        return task.getInfo();
    }
}
