package training.expires;

import java.util.concurrent.TimeUnit;

class ThreadedTask {
    private Task task;
    private Thread thread;

    public ThreadedTask(Runnable runnable, long period, TimeUnit unit) {
        this.task = new Task(runnable, period, unit);
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
}
