package training.expires;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class PeriodicScheduler {
    private final List<Task> runningTasks;
    private final List<Task> suspendTasks;
    private final Map<Task, TaskRunnable> tasksRunnable;
    private final List<Thread> threads;

    public PeriodicScheduler() {
        runningTasks = new ArrayList<>();
        suspendTasks = new ArrayList<>();
        tasksRunnable = new HashMap<>();
        threads = new ArrayList<>();
    }

    public void schedule(Task task, long period, TimeUnit unit) {
        TaskRunnable taskRunnable = new TaskRunnable(task, period, unit);
        Thread thread = new Thread(taskRunnable);
        task.setStatus(TaskStatus.RUNNING);
        thread.start();
        runningTasks.add(task);
        threads.add(thread);
        tasksRunnable.put(task, taskRunnable);
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
        runningTasks.remove(task);
    }

    public void resume(Task task) {
        if (suspendTasks.contains(task)) {
            task.setStatus(TaskStatus.RUNNING);
            tasksRunnable.get(task).run();
            runningTasks.add(task);
            suspendTasks.remove(task);
        }
    }

    public void reSchedule(Task task, long period, TimeUnit unit) {
        if (suspendTasks.contains(task)) {
            TaskRunnable taskRunnable = tasksRunnable.get(task);
            taskRunnable.setPeriod(period);
            taskRunnable.setUnit(unit);
            resume(task);
        }



    }

    public void getScdInfo() {


    }

}
