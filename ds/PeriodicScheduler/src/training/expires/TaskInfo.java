package training.expires;

import training.expires.policies.DelayPolicy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class TaskInfo {
    private long period;
    private TimeUnit unit;
    private TaskStatus status;
    private DelayPolicy policy;
    private long lastDuration;
    private long executionTotal;
    private long failuresTotal;
    private long completedTotal;
    private long totalTimeExecution;
    private double averageRunTime;
    private final List<Exception> exceptions;


    public TaskInfo() {
        exceptions = new ArrayList<>();
    }

    public void addException(Exception e) {
        exceptions.add(e);
    }

    public void setPeriod(long period) {
        this.period = period;
    }

    public void setUnit(TimeUnit unit) {
        this.unit = unit;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public void setPolicy(DelayPolicy policy) {
        this.policy = policy;
    }

    public void setLastDuration(long lastDuration) {
        this.lastDuration = lastDuration;
    }

    public void setExecutionTotal(long executionTotal) {
        this.executionTotal = executionTotal;
    }

    public void setFailuresTotal(long failuresTotal) {
        this.failuresTotal = failuresTotal;
    }

    public void setCompletedTotal(long completedTotal) {
        this.completedTotal = completedTotal;
    }

    public void setTotalTimeExecution(long totalTimeExecution) {
        this.totalTimeExecution = totalTimeExecution;
    }

    public void setAverageRunTime(double averageRunTime) {
        this.averageRunTime = averageRunTime;
    }
}
