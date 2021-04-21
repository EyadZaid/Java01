package training.expires;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class PeriodicScheduler {
    private final Map<Runnable, TaskThread> allTasks;

    public PeriodicScheduler() {
        allTasks = new ConcurrentHashMap<>();
    }

    public void schedule(Runnable runnable, long period, TimeUnit unit) {
        if (allTasks.get(runnable) == null) {
            Task task = new Task(runnable, period,unit);
            Thread thread = new Thread(task);
            TaskThread taskThread = new TaskThread(task, thread);
            allTasks.put(runnable, taskThread);
            thread.start();
        }
    }

    public void stop(Runnable runnable) {
        var taskThread = allTasks.get(runnable);
        if (taskThread != null) {
            taskThread.getTask().stop();
            try {
                taskThread.getThread().join();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stopAll() {
        for (var runnable : allTasks.keySet()) {
            stop(runnable);
        }
    }

    public void suspendAll() {
        for (var runnable : allTasks.keySet()) {
            suspend(runnable);
        }
    }

    public void suspend(Runnable runnable) {
        var taskThread = allTasks.get(runnable);
        if (taskThread != null) {
            taskThread.getTask().suspend();
        }
    }

    public void resume(Runnable runnable) {
        var taskThread = allTasks.get(runnable);
        if (taskThread != null) {
            taskThread.getTask().resume();
        }
    }

    public void reSchedule(Runnable runnable, long period, TimeUnit unit) {
        var taskThread = allTasks.get(runnable);
        if (taskThread != null) {
            var task = taskThread.getTask();
            task.setPeriodAndUnit(period, unit);
            task.resume();
        }
    }

    public void getScdInfo() {

    }

}
