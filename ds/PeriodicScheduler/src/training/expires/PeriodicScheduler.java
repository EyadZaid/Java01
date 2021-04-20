package training.expires;

import java.util.ArrayList;
import java.util.List;

public class PeriodicScheduler {
    private final List<Task> runningTasks;
    private final List<Task> suspendTasks;
    private final List<Thread> threads;

    public PeriodicScheduler() {
        runningTasks = new ArrayList<>();
        suspendTasks = new ArrayList<>();
        threads = new ArrayList<>();
    }

    public void schedule(Task task, long period) {
        TaskRunnable taskRunnable = new TaskRunnable(task, period);
        Thread thread = new Thread(taskRunnable);
        task.setStatus(TaskStatus.RUNNING);
        thread.start();
        runningTasks.add(task);
        threads.add(thread);
    }

    public void stop(Task task) {
        task.setStatus(TaskStatus.STOPPED);
        runningTasks.remove(task);
    }

    public void stopAll() {
        for (var task: runningTasks) {
            task.setStatus(TaskStatus.STOPPED);
        }
        runningTasks.clear();
    }

    public void suspend(Task task) {
        task.setStatus(TaskStatus.SUSPENDED);
        suspendTasks.add(task);
    }

    public void resume(Task task) {

    }

    public void reSchedule(Task task, long period) {


    }

    public void getScdInfo() {


    }

}
