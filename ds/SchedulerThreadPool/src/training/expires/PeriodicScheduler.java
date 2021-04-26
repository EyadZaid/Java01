package training.expires;

import training.expires.policies.DelayPolicy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class PeriodicScheduler {
    private final Map<Runnable, Task> tasksMap;

    private final ScheduledThreadPoolExecutor threadPool;
   // private final ExecutorService executor;
    //private final Map<Runnable, Future<?>> futuresMap;


    public PeriodicScheduler(int poolSize) {
        tasksMap = new ConcurrentHashMap<>();

        threadPool = new ScheduledThreadPoolExecutor(poolSize);
        //executor = Executors.newFixedThreadPool(poolSize);
        //futuresMap = new ConcurrentHashMap<>();
    }

    public PeriodicScheduler() {
        this(5);
    }

    public void schedule(Runnable runnable, long period, TimeUnit unit, DelayPolicy delayPolicy) {
        if (tasksMap.get(runnable) == null) {
            Task task = new Task(runnable, period, unit, delayPolicy, new TaskInfoObserver());

            threadPool.execute(task);
            //var future = executor.submit(task);
            //futuresMap.put(runnable, future);

            tasksMap.put(runnable, task);
        }
    }

    public void stopAll() {
        for (var runnable : tasksMap.keySet()) {
            stop(runnable);
        }
        threadPool.shutdown();
        //executor.shutdown();
    }

    public void stop(Runnable runnable) {
        var task = tasksMap.get(runnable);
        if (task != null) {
            task.stop();
        }
    }

    public void suspendAll() {
        for (var runnable : tasksMap.keySet()) {
            suspend(runnable);
        }
    }

    public void suspend(Runnable runnable) {
        var task = tasksMap.get(runnable);
        if (task != null) {
            task.suspend();
            //futuresMap.get(runnable).cancel(true);
        }
    }

    public void resumeAll() {
        for (var runnable : tasksMap.keySet()) {
            resume(runnable);
        }
    }

    public void resume(Runnable runnable) {
        var task = tasksMap.get(runnable);
        if (task != null) {
            task.resume();
        }
    }

    public void reschedule(Runnable runnable, long period, TimeUnit unit) {
        var task = tasksMap.get(runnable);
        if (task != null) {
            task.reschedule(period, unit);
        }
    }

    public void getInfoString(Runnable runnable) {
        var task = tasksMap.get(runnable);
        if (task != null) {
            System.out.println(task.getInfoString());
        }
    }

    public TaskInfo getInfo(Runnable runnable) {
        var task = tasksMap.get(runnable);
        if (task != null) {
            return task.getInfo();
        }
        return null;
    }

}
