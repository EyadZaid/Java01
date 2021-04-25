package training.expires;

import training.expires.policies.DelayPolicy;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class PeriodicScheduler {
    private final Map<Runnable, ThreadedTask> taskThreadsMap;

    public PeriodicScheduler() {
        taskThreadsMap = new ConcurrentHashMap<>();
    }

    public void schedule(Runnable runnable, long period, TimeUnit unit, DelayPolicy delayPolicy) {
        if (taskThreadsMap.get(runnable) == null) {
            var threadedTask = createThreadTask(runnable, period, unit, delayPolicy);
            taskThreadsMap.put(runnable, threadedTask);
        }
    }

    private ThreadedTask createThreadTask(Runnable runnable, long period, TimeUnit unit, DelayPolicy delayPolicy) {
        return new ThreadedTask(runnable, period, unit, delayPolicy);
    }

    public void stopAll() {
        for (var runnable : taskThreadsMap.keySet()) {
            stop(runnable);
        }
    }

    public void stop(Runnable runnable) {
        var threadedTask = taskThreadsMap.get(runnable);
        if (threadedTask != null) {
            threadedTask.stop();
        }
    }

    public void suspendAll() {
        for (var runnable : taskThreadsMap.keySet()) {
            suspend(runnable);
        }
    }

    public void suspend(Runnable runnable) {
        var threadedTask = taskThreadsMap.get(runnable);
        if (threadedTask != null) {
            threadedTask.suspend();
        }
    }

    public void resumeAll() {
        for (var runnable : taskThreadsMap.keySet()) {
            resume(runnable);
        }
    }

    public void resume(Runnable runnable) {
        var threadedTask = taskThreadsMap.get(runnable);
        if (threadedTask != null) {
            threadedTask.resume();
        }
    }

    public void reschedule(Runnable runnable, long period, TimeUnit unit) {
        var threadedTask = taskThreadsMap.get(runnable);
        if (threadedTask != null) {
            threadedTask.reschedule(period, unit);
        }
    }

    public void getInfoString(Runnable runnable) {
        var threadedTask = taskThreadsMap.get(runnable);
        if (threadedTask != null) {
            System.out.println(threadedTask.getInfoString());
        }
    }

    public TaskInfo getInfo(Runnable runnable) {
        var threadedTask = taskThreadsMap.get(runnable);
        if (threadedTask != null) {
            return threadedTask.getInfo();
        }
        return null;
    }

}
