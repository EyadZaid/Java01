package training.expires.userHandler;

import training.expires.ChatServer;
import training.expires.InputHandler;

import java.io.IOException;
import java.util.Scanner;

public class UserSessionHandler implements Runnable {
    private final ChatServer server;
    private final User user;
    private volatile boolean active;

    public UserSessionHandler(User user, ChatServer server) {
        this.user = user;
        this.server = server;
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
                InputHandler inputHandler = new InputHandler(input, user);
                inputHandler.handleInput();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        active = false;
    }

}