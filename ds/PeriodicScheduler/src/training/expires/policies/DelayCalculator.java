package training.expires.policies;

public interface DelayCalculator {

    long calculateWaitTime(long timeSpan, long cycle);

}
