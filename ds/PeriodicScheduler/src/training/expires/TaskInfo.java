package training.expires;

import training.expires.policies.DelayPolicy;

import java.util.ArrayList;
import java.util.List;

public class TaskInfo {
    private long periodNano;
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

    public long getPeriodNano() {
        return periodNano;
    }

    public DelayPolicy getPolicy() {
        return policy;
    }

    public long getLastDuration() {
        return lastDuration;
    }

    public long getExecutionTotal() {
        return executionTotal;
    }

    public long getFailuresTotal() {
        return failuresTotal;
    }

    public long getCompletedTotal() {
        return completedTotal;
    }

    public long getTotalTimeExecution() {
        return totalTimeExecution;
    }

    public double getAverageRunTime() {
        return averageRunTime;
    }

    public List<Exception> getExceptions() {
        return exceptions;
    }

    public void setPeriodNano(long periodNano) {
        this.periodNano = periodNano;
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

    @Override
    public String toString() {
        return "\n ## Task Info ##" +
                "\nPeriod (nano): " + periodNano +
                "\nPolicy: " + policy +
                "\nLastDuration: " + lastDuration +
                "\nExecutionTotal: " + executionTotal +
                "\nCompletedTotal: " + completedTotal +
                "\nFailuresTotal: " + failuresTotal +
                "\nTotalTimeExecution: " + totalTimeExecution +
                "\nAverageRunTime: " + averageRunTime +
                "\nExceptions: " + exceptions +
                "\n";
    }
}
