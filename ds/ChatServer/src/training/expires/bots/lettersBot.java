package training.expires.bots;

import java.util.Random;

public class lettersBot implements IBot {
    private final Random rand;

    public lettersBot() {
        this.rand =  new Random();
    }

    @Override
    public String doSomething() {
        char ch = (char)(rand.nextInt('z' - 'a') + 'a');
        String str = "Letter: " + ch;
        return str;
    }
}
