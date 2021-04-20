package training.expires;

public class Main {

    public static void main(String[] args) {
        PeriodicScheduler scheduler = new PeriodicScheduler();
        Task task1 = new Task(() -> System.out.println("Task #1 running"));
        Task task2 = new Task(() -> System.out.println("Task #2 running"));


        scheduler.schedule(task1, 1000);
        scheduler.schedule(task2, 1000);
    }
}
