package training.expires;

import training.expires.policies.DelayPolicy;

import java.util.ArrayList;
import java.util.List;

public class TaskInfo {
    private long periodNano;
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

    public void setPeriodNano(long periodNano) {
        this.periodNano = periodNano;
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

    public void updateAverageRunTime() {
        if (totalTimeExecution != 0 && executionTotal != 0)
        this.averageRunTime = (double) totalTimeExecution / executionTotal;
    }

    @Override
    public String toString() {
        return "\n ## Task Info ##" +
                "\nPeriod (nano): " + periodNano +
                "\nStatus: " + status +
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
