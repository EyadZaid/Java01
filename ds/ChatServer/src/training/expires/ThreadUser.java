package training.expires;

import java.io.IOException;
import java.util.Scanner;

public class ThreadUser implements Runnable {
    private final ChatServer server;
    private final User user;

    public ThreadUser(User user, ChatServer server) {
        this.user = user;
        this.server = server;
    }

    @Override
    public void run() {
        Scanner inputStream;
        try {
            inputStream = new Scanner(user.getInputStream());
            while(true) {
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

}