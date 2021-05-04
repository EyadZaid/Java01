package training.expires;

import training.expires.userHandler.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ChatManager {
    private static ChatManager instance = null;
    private final HashMap<String, Room> rooms;
    private final HashMap<User,Thread> threads;
    private final List<User> users;

    private ChatManager() {
        rooms = new HashMap<>();
        threads = new HashMap<>();
        users = new ArrayList<>();
        initializeRooms();
    }

    public static ChatManager getInstance() {
        if (instance == null)
            instance = new ChatManager();

        return instance;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void addThread(User user, Thread thread) {
        threads.put(user, thread);
    }

    public HashMap<String, Room> getRooms() {
        return rooms;
    }

    public List<User> getUsers() {
        return users;
    }

    public HashMap<User, Thread> getThreads() {
        return threads;
    }

    public User getUserByName(String name) {
        for (var u : users) {
            if (u.getNickname().equals(name)) {
                return u;
            }
        }
        return null;
    }

    public void initializeRooms() {
        for (int i=0; i<5; i++) {
            rooms.put("room" + i ,new Room("room" + i));
        }
    }
}
