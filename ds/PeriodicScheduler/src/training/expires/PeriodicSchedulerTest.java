package training.expires;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PeriodicSchedulerTest {
    private PeriodicScheduler scheduler;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        scheduler = new PeriodicScheduler();
    }

    @Test
    void scheduleTest() {
        Task task1 = new Task(() -> System.out.println("Task #1 running"));
        Task task2 = new Task(() -> System.out.println("Task #2 running"));


        scheduler.schedule(task1, 1000);
        scheduler.schedule(task2, 1000);

    }
}