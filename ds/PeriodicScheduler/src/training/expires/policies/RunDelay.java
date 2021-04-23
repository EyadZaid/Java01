package training.expires.policies;

public class RunDelay implements DelayCalculator{

    @Override
    public long calculateWaitTime(long duration, long cycle) {
        if (duration <= cycle) {
            return cycle - duration;
        }

        return cycle - (duration % cycle);
    }
}
