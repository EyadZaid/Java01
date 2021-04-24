package training.expires;

import training.expires.policies.DelayPolicy;

import java.util.concurrent.TimeUnit;

class ThreadedTask {
    private final Task task;
    private final Thread thread;

    public ThreadedTask(Runnable runnable, long period, TimeUnit unit, DelayPolicy delayPolicy) {
        this.task = new Task(runnable, period, unit, delayPolicy, new TaskInfoObserver());
        this.thread = new Thread(task);
        thread.start();
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

    public void resume() {
        task.resume();
    }

    public String getInfo() {
        return task.getInfo();
    }
}
