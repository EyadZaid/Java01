package training.expires;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class PeriodicScheduler {
    private final Map<Runnable, ThreadedTask> taskThreadsMap;

    public PeriodicScheduler() {
        taskThreadsMap = new ConcurrentHashMap<>();
    }

    public void schedule(Runnable runnable, long period, TimeUnit unit) {
        if (taskThreadsMap.get(runnable) == null) {
            var taskThread = cretaeThreadTask(runnable, period, unit);
            taskThreadsMap.put(runnable, taskThread);
        }
    }

    private ThreadedTask cretaeThreadTask(Runnable runnable, long period, TimeUnit unit) {
        return new ThreadedTask(runnable, period, unit);
    }

    public void stopAll() {
        for (var runnable : taskThreadsMap.keySet()) {
            stop(runnable);
        }
    }

    public void stop(Runnable runnable) {
        var taskThread = taskThreadsMap.remove(runnable);
        if (taskThread != null) {
            taskThread.stop();
        }
    }

    public void suspendAll() {
        for (var runnable : taskThreadsMap.keySet()) {
            suspend(runnable);
        }
    }

    public void suspend(Runnable runnable) {
        var taskThread = taskThreadsMap.get(runnable);
        if (taskThread != null) {
            taskThread.suspend();
        }
    }

    public void resumeAll() {
        for (var runnable : taskThreadsMap.keySet()) {
            resume(runnable);
        }
    }

    public void resume(Runnable runnable) {
        var taskThread = taskThreadsMap.get(runnable);
        if (taskThread != null) {
            taskThread.getTask().resume();
        }
    }

    public void reSchedule(Runnable runnable, long period, TimeUnit unit) {
        var taskThread = taskThreadsMap.get(runnable);
        if (taskThread != null) {
            taskThread.reschedule(period, unit);
        }
    }

}
