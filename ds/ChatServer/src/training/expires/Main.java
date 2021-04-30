package training.expires;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            new ChatServer().startServer();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
