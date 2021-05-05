package training.expires;

import training.expires.userHandler.User;

import java.io.IOException;
import java.util.HashSet;

public class Room {
    private final HashSet<User> users;
    private final String name;
    private final Moderator moderator;

    public Room(String name) {
        users = new HashSet<>();
        this.name = name;
        moderator = new Moderator();
    }

    public String getName() {
        return name;
    }

    public void sendMessage(String msg, User user) throws IOException {
        moderator.censor(msg);
        for (var u : users) {
            if (!u.equals(user)) {
                u.sendMessage(msg, user);
            }
        }
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }
}
