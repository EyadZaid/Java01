package training.expires;

import training.expires.policies.DelayPolicy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

    public void incExecutionTotal() {
        this.executionTotal++;
    }

    public void incFailuresTotal() {
        this.failuresTotal++;
    }

    public void incCompletedTotal() {
        this.completedTotal++;
    }

    public void addToTotalTimeExecution(long timeExecution) {
        this.totalTimeExecution += timeExecution;
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

    public void setAverageRunTime(double averageRunTime) {
        this.averageRunTime = averageRunTime;
    }
}
