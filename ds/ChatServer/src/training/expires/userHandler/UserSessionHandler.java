package training.expires.userHandler;

import java.io.IOException;
import java.util.Scanner;

public class UserSessionHandler implements Runnable {
    private final User user;
    private volatile boolean active;

    public UserSessionHandler(User user) {
        this.user = user;
        active = true;
    }

    @Override
    public void run() {
        Scanner inputStream;
        try {
            inputStream = new Scanner(user.getInputStream());
            while(active) {
                if (!inputStream.hasNext()) {
                    return;
                }
                String input = inputStream.nextLine();
                UserInputHandler userInputHandler = new UserInputHandler(input, user);
                userInputHandler.handleInput();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        active = false;
    }

}