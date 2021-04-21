package training.expires.tests;

import org.junit.jupiter.api.Test;
import training.expires.PeriodicScheduler;
import training.expires.tasksFunctions.Func1;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class SchedulerTest {
    private PeriodicScheduler scheduler;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        scheduler = new PeriodicScheduler();
    }


    @Test
    void schedulerStopAllTest() {
        /*
        Task task1 = new Task(() -> System.out.println("Task #1 running"));
        Task task2 = new Task(() -> System.out.println("Task #2 running"));

        scheduler.schedule(task1, 1000, TimeUnit.MILLISECONDS);
        scheduler.schedule(task2, 1000, TimeUnit.MILLISECONDS);

        try {
            Thread.sleep(3000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        scheduler.stopAll();

         */
    }


    @Test
    void SuspendTest() {
        scheduler = new PeriodicScheduler();

        Func1 f1 = new Func1();
        scheduler.schedule(f1, 1000, TimeUnit.MILLISECONDS);

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

        /*
        scheduler.resume(f1);

        try {
            Thread.sleep(3000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
*/
        scheduler.stopAll();
    }
}