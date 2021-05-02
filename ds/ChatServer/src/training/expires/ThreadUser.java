package training.expires;

import java.io.IOException;
import java.util.Scanner;

public class ThreadUser implements Runnable {
    private final ChatServer server;
    private final User user;
    private Scanner inputStream;

    public ThreadUser(User user, ChatServer server) {
        this.user = user;
        this.server = server;
    }

    @Override
    public void run() {
        try {
            inputStream = new Scanner(user.getInputStream());
            while(true) {
                if(!inputStream.hasNext()) {
                    return;
                }
                String chatLine = inputStream.nextLine();
                System.out.println(chatLine);
                user.getRoom().sendMessage(chatLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}