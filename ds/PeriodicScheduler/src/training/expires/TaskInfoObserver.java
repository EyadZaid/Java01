package training.expires;

import training.expires.policies.DelayPolicy;

import java.util.ArrayList;
import java.util.List;

public class TaskInfoObserver implements ITaskInfoObserver{
    private long periodNano;
    private DelayPolicy policy;
    private long lastDuration;
    private long executionTotal;
    private long failuresTotal;
    private long completedTotal;
    private long totalTimeExecution;
    private double averageRunTime;
    private final List<Exception> exceptions;

    public TaskInfoObserver() {
        exceptions = new ArrayList<>();
    }


    @Override
    public void onTaskStart(long periodNano, DelayPolicy policy) {
        this.periodNano = periodNano;
        this.policy = policy;
        executionTotal++;
    }

    @Override
    public void onTaskCompleted() {
        completedTotal++;
    }

    @Override
    public void onException(Exception e) {
        failuresTotal++;
        exceptions.add(e);
    }

    @Override
    public void onTaskEnd(long lastDuration) {
        this.lastDuration = lastDuration;
        totalTimeExecution += lastDuration;
        if (totalTimeExecution != 0 && executionTotal != 0)
            averageRunTime = (double) totalTimeExecution / executionTotal;
    }

    @Override
    public TaskInfo getInfo() {
        TaskInfo taskInfo = new TaskInfo();
        taskInfo.setPeriodNano(periodNano);
        taskInfo.setPolicy(policy);
        taskInfo.setAverageRunTime(averageRunTime);
        taskInfo.setTotalTimeExecution(totalTimeExecution);
        taskInfo.setLastDuration(lastDuration);
        taskInfo.setFailuresTotal(failuresTotal);
        taskInfo.setCompletedTotal(completedTotal);
        taskInfo.setExecutionTotal(executionTotal);

        return taskInfo;
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
