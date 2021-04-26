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

        scheduler.schedule(f1, 2000, TimeUnit.MILLISECONDS, DelayPolicy.IMMEDIATELY);
        scheduler.schedule(f2, 3000, TimeUnit.MILLISECONDS, DelayPolicy.IMMEDIATELY);

        delay(5000);

        scheduler.stopAll();

        long executionTotalTask1 = scheduler.getInfo(f1).getExecutionTotal();
        assertEquals(3, executionTotalTask1);

        long executionTotalTask2 = scheduler.getInfo(f2).getExecutionTotal();
        assertEquals(2, executionTotalTask2);
    }

    @Test
    void schedulerDelayPolicyTest() {
        scheduler = new PeriodicScheduler();
        Func1 f1 = new Func1();
        Func2 f2 = new Func2();

        scheduler.schedule(f1, 1500, TimeUnit.MILLISECONDS, DelayPolicy.DELAY);
        scheduler.schedule(f2, 3000, TimeUnit.MILLISECONDS, DelayPolicy.DELAY);

        delay(5000);

        scheduler.stopAll();

        long executionTotalTask1 = scheduler.getInfo(f1).getExecutionTotal();
        assertEquals(4, executionTotalTask1);

        long executionTotalTask2 = scheduler.getInfo(f2).getExecutionTotal();
        assertEquals(2, executionTotalTask2);
    }

    @Test
    void SchedulerResumeAllTest() {
        scheduler = new PeriodicScheduler();
        Func1 f1 = new Func1();
        Func2 f2 = new Func2();

        scheduler.schedule(f1, 2000, TimeUnit.MILLISECONDS, DelayPolicy.IMMEDIATELY);
        scheduler.schedule(f2, 3000, TimeUnit.MILLISECONDS, DelayPolicy.IMMEDIATELY);

        delay(5000);

        scheduler.suspend(f1);
        scheduler.suspend(f2);

        delay(2000);

        scheduler.resumeAll();

        delay(2000);

        scheduler.stopAll();

        long executionTotalTask1 = scheduler.getInfo(f1).getExecutionTotal();
        assertEquals(5, executionTotalTask1);

        long executionTotalTask2 = scheduler.getInfo(f2).getExecutionTotal();
        assertEquals(3, executionTotalTask2);
    }

    @Test
    void SchedulerSuspendAllTest() {
        scheduler = new PeriodicScheduler();
        Func1 f1 = new Func1();
        Func2 f2 = new Func2();

        scheduler.schedule(f1, 1500, TimeUnit.MILLISECONDS, DelayPolicy.IMMEDIATELY);
        scheduler.schedule(f2, 3000, TimeUnit.MILLISECONDS, DelayPolicy.IMMEDIATELY);

        delay(5000);

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

        scheduler.schedule(f1, 1500, TimeUnit.MILLISECONDS, DelayPolicy.IMMEDIATELY);
        scheduler.schedule(f2, 3000, TimeUnit.MILLISECONDS, DelayPolicy.IMMEDIATELY);

        delay(4000);

        scheduler.suspend(f1);

        delay(2000);

        scheduler.reschedule(f1, 1000, TimeUnit.MILLISECONDS);

        try {
            Thread.sleep(2000);
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


    private void delay(long millis) {
        try {
            Thread.sleep(millis);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}