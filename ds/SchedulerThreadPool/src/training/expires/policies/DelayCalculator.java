package training.expires.policies;

public interface DelayCalculator {

    long calculateWaitTime(long duration, long cycle);

}
