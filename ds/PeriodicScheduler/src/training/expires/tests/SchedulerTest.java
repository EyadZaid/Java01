package training.expires.tests;

import org.junit.jupiter.api.Test;
import training.expires.PeriodicScheduler;
import training.expires.policies.DelayPolicy;
import training.expires.tasksFunctions.Func1;
import training.expires.tasksFunctions.Func2;

import java.util.concurrent.TimeUnit;

class SchedulerTest {
    private PeriodicScheduler scheduler;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        scheduler = new PeriodicScheduler();
    }

    @Test
    void schedulerStopAllTest() {
        scheduler = new PeriodicScheduler();
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

    @Test
    void SchedulerTest() {
        scheduler = new PeriodicScheduler();
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

        scheduler.suspend(f1);

        try {
            Thread.sleep(3000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        scheduler.resume(f1);

        try {
            Thread.sleep(3000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        scheduler.stopAll();
    }


    @Test
    void schedulerReScheduleTest() {
        scheduler = new PeriodicScheduler();
        Func1 f1 = new Func1();
        Func2 f2 = new Func2();

        scheduler.schedule(f1, 500, TimeUnit.MILLISECONDS, DelayPolicy.IMMEDIATELY);
        scheduler.schedule(f2, 500, TimeUnit.MILLISECONDS, DelayPolicy.IMMEDIATELY);

        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        scheduler.suspend(f1);

        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        scheduler.reschedule(f1, 1000, TimeUnit.MILLISECONDS);

        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        scheduler.stopAll();
    }


    @Test
    void schedulerSuspendAllTest() {
        scheduler = new PeriodicScheduler();
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

        scheduler.suspendAll();

        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        scheduler.stopAll();
    }
}