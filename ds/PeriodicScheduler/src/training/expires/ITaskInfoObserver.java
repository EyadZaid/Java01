package training.expires;

import training.expires.policies.DelayPolicy;

public interface ITaskInfoObserver {

    void onTaskStart(long periodNano, DelayPolicy policy);

    void onTaskCompleted();

    void onException(Exception e);

    void onTaskEnd(long lastDuration);

}
