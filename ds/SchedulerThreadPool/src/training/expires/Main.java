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

        scheduler.schedule(f1, 2000, TimeUnit.MILLISECONDS, DelayPolicy.IMMEDIATELY);
        scheduler.schedule(f2, 3000, TimeUnit.MILLISECONDS, DelayPolicy.IMMEDIATELY);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        scheduler.stop(f1);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        scheduler.stopAll();


        scheduler.getInfoString(f1);
    }
}
