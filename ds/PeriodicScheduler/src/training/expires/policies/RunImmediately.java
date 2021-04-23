package training.expires.policies;

public class RunImmediately implements DelayCalculator{

    @Override
    public long calculateWaitTime(long duration, long cycle) {
        if ((cycle - duration) < 0) {
            return 0;
        }

        return cycle - duration;
    }
}
