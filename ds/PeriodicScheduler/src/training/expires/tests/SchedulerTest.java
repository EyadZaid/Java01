package training.expires.tests;

import org.junit.jupiter.api.Test;
import training.expires.PeriodicScheduler;
import training.expires.policies.DelayPolicy;
import training.expires.tasksFunctions.Func1;
import training.expires.tasksFunctions.Func2;
import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

class SchedulerTest {
    private PeriodicScheduler scheduler;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        scheduler = new PeriodicScheduler();
    }

    @Test
    void schedulerImmediatelyPolicyTest() {
        scheduler = new PeriodicScheduler();
        Func1 f1 = new Func1();
        Func2 f2 = new Func2();

        scheduler.schedule(f1, 1500, TimeUnit.MILLISECONDS, DelayPolicy.IMMEDIATELY);
        scheduler.schedule(f2, 3000, TimeUnit.MILLISECONDS, DelayPolicy.IMMEDIATELY);

        try {
            Thread.sleep(6000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        scheduler.stopAll();

        long executionTotalTask1 = scheduler.getInfo(f1).getExecutionTotal();
        assertEquals(5, executionTotalTask1);

        long executionTotalTask2 = scheduler.getInfo(f2).getExecutionTotal();
        assertEquals(3, executionTotalTask2);
    }

    @Test
    void schedulerDelayPolicyTest() {
        scheduler = new PeriodicScheduler();
        Func1 f1 = new Func1();
        Func2 f2 = new Func2();

        scheduler.schedule(f1, 1500, TimeUnit.MILLISECONDS, DelayPolicy.DELAY);
        scheduler.schedule(f2, 3000, TimeUnit.MILLISECONDS, DelayPolicy.DELAY);

        try {
            Thread.sleep(6000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        scheduler.stopAll();

        long executionTotalTask1 = scheduler.getInfo(f1).getExecutionTotal();
        assertEquals(4, executionTotalTask1);

        long executionTotalTask2 = scheduler.getInfo(f2).getExecutionTotal();
        assertEquals(3, executionTotalTask2);
    }

    @Test
    void SchedulerResumeAllTest() {
        scheduler = new PeriodicScheduler();
        Func1 f1 = new Func1();
        Func2 f2 = new Func2();

        scheduler.schedule(f1, 1500, TimeUnit.MILLISECONDS, DelayPolicy.IMMEDIATELY);
        scheduler.schedule(f2, 3000, TimeUnit.MILLISECONDS, DelayPolicy.IMMEDIATELY);

        try {
            Thread.sleep(6000);
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

        scheduler.resumeAll();

        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        scheduler.stopAll();

        long executionTotalTask1 = scheduler.getInfo(f1).getExecutionTotal();
        assertEquals(7, executionTotalTask1);

        long executionTotalTask2 = scheduler.getInfo(f2).getExecutionTotal();
        assertEquals(4, executionTotalTask2);
    }

    @Test
    void SchedulerSuspendAllTest() {
        scheduler = new PeriodicScheduler();
        Func1 f1 = new Func1();
        Func2 f2 = new Func2();

        scheduler.schedule(f1, 1500, TimeUnit.MILLISECONDS, DelayPolicy.IMMEDIATELY);
        scheduler.schedule(f2, 3000, TimeUnit.MILLISECONDS, DelayPolicy.IMMEDIATELY);

        try {
            Thread.sleep(5000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        scheduler.suspendAll();

        long executionTotalTask1 = scheduler.getInfo(f1).getExecutionTotal();
        assertEquals(4, executionTotalTask1);

        long executionTotalTask2 = scheduler.getInfo(f2).getExecutionTotal();
        assertEquals(2, executionTotalTask2);

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