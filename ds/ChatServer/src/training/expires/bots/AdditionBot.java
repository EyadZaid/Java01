package training.expires.bots;

import java.util.Random;

public class AdditionBot implements IBot {
    private final Random rand;

    public AdditionBot() {
        this.rand =  new Random();
    }

    @Override
    public String doSomething() {
        int num = rand.nextInt(100);
        String str = "Solve: " + num + " + " + " 10 ";
        return str;
    }
}
