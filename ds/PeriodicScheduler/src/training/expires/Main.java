package training.expires;

import training.expires.policies.DelayPolicy;
import training.expires.tasksFunctions.Func1;
import training.expires.tasksFunctions.Func2;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        PeriodicScheduler scheduler = new PeriodicScheduler();
        Func1 f1 = new Func1();
        Func2 f2 = new Func2();

        scheduler.schedule(f1, 1000, TimeUnit.MILLISECONDS, DelayPolicy.IMMEDIATELY);
        scheduler.schedule(f2, 1000, TimeUnit.MILLISECONDS, DelayPolicy.IMMEDIATELY);

        try {
            Thread.sleep(3000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        scheduler.stopAll();
    }
}
