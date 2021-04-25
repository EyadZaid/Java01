package training.expires.tasksFunctions;

public class Func1 implements Runnable{

    @Override
    public void run() {
        System.out.println("Task #1 running...");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
