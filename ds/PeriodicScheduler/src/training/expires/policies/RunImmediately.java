package training.expires.policies;

public class RunImmediately implements DelayCalculator{

    @Override
    public long calculateWaitTime(long timeSpan, long cycle) {
        if ((cycle - timeSpan) < 0) {
            return 0;
        }

        return cycle - timeSpan;
    }
}
