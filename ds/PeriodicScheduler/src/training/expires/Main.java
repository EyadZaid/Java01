package training.expires;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        PeriodicScheduler scheduler = new PeriodicScheduler();
        Task task1 = new Task(() -> System.out.println("Task #1 running"));
        Task task2 = new Task(() -> System.out.println("Task #2 running"));


        scheduler.schedule(task1, 1000, TimeUnit.MILLISECONDS);
        scheduler.schedule(task2, 1000, TimeUnit.MILLISECONDS);

        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        scheduler.stop(task1);

        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        scheduler.resume(task1);

    }
}
