package training.expires;

import training.expires.moderators.Moderator;
import training.expires.userHandler.User;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;

public class Room {
    private final HashSet<User> users;
    private final String name;
    private final Moderator moderator;


    public Room(String name) {
        this.name = name;
        users = new HashSet<>();
        moderator = new Moderator();
        initializeModerator();
    }

    public String getName() {
        return name;
    }

    public void sendMsgAllUsersRoom(String msg, User user) throws IOException {

        String newMsg = moderator.censor(msg);

        if (checkMuchCurses(user)) {
            return;
        }

        for (var u : users) {
            u.sendMessage(newMsg, user);
        }
    }

    private boolean checkMuchCurses(User user) {
        if (moderator.isCensored()) {
            user.incCountCensor();

            if (user.getCountCensor() == 3) {
                user.setCountCensor(0);
                removeUser(user);
                user.setRoom(null);
                return true;
            }
        }
        return false;
    }

    public void botSendMsgInRoom(String msg) throws IOException {
        msg = moderator.censor(msg);
        for (var u : users) {
            u.sendMessage(msg);
        }
    }

    public int getNumberOfUsers() {
        return users.size();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    private void initializeModerator() {
        var list = Arrays.asList("fuck","piss","damn","shit","asshole");
        moderator.addListWords(list);
    }
}
