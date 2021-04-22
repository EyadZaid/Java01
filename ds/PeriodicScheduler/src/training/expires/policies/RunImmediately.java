package training.expires.policies;

public class RunImmediately implements DelayCalculator{

    @Override
    public long calculateWaitTime(long timeSpan, long cycle) {
        long waitTimeNano =  cycle - timeSpan;

        if (waitTimeNano < 0) {
            waitTimeNano = 0;
        }

        return waitTimeNano;
    }
}
