package training.expires.policies;

public class RunDelay implements DelayCalculator{

    @Override
    public long calculateWaitTime(long timeSpan, long cycle) {
        return 0;
    }
}
