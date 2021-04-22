package training.expires.policies;

public class RunDelay implements DelayCalculator{

    @Override
    public long calculateWaitTime(long timeSpan, long cycle) {
        if (timeSpan <= cycle) {
            return cycle - timeSpan;
        }

        return cycle - (timeSpan % cycle);
    }
}
