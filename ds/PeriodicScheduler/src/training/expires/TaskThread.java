package training.expires;

public class TaskThread {
    private Task task;
    private Thread thread;

    public TaskThread(Task task, Thread thread) {
        this.task = task;
        this.thread = thread;
    }

    public Task getTask() {
        return task;
    }

    public Thread getThread() {
        return thread;
    }
}
