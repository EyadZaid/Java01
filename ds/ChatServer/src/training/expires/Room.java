package training.expires;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Room {
    private final List<User> users;
    private final String name;

    public Room(String name) {
        users = new ArrayList<>();
        this.name = name;
    }

    public String getName() {
        return name;
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
