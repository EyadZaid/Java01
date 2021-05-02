package training.expires;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Room {
    private final List<User> users;
    private final int number;

    public Room(int number) {
        users = new ArrayList<>();
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void sendMessage(String msg) throws IOException {
        for (var u : users) {
            u.sendMessage(msg);
        }
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

}
