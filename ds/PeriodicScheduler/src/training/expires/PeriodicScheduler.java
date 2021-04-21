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
            var task = taskThread.getTask();
            var thread = taskThread.getThread();
            task.updateStatus(TaskStatus.STOPPED);
            try {
                thread.join();
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

    public void suspend(Runnable runnable) {
        var task = allTasks.get(runnable).getTask();
        if (task != null) {
            task.updateStatus(TaskStatus.SUSPENDED);
        }
    }

    public void resume(Runnable runnable) {
        var task = allTasks.get(runnable).getTask();
        if (task != null) {
            task.updateStatus(TaskStatus.RUNNING);
        }
    }

    public void reSchedule(Runnable runnable, long period, TimeUnit unit) {
        var task = allTasks.get(runnable).getTask();
        if (task != null) {
            task.setPeriodAndUnit(period, unit);
            task.updateStatus(TaskStatus.RUNNING);
        }
    }

    public void getScdInfo() {
        /*
        System.out.println("Number of active tasks: " + tasksRunnable.size());
        System.out.println("Number of suspend tasks: " + suspendTasks.size());
*/

    }

}
