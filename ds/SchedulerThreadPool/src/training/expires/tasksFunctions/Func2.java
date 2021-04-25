package training.expires.tasksFunctions;

public class Func2 implements Runnable{

    @Override
    public void run() {
        System.out.println("Task #2 running...");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
