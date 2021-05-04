package training.expires.commands;

import training.expires.Room;
import training.expires.userHandler.User;

public class LeaveCommand implements ICommand {

    @Override
    public void execute(String input, User user) {
        Room room = user.getRoom();
        if (room != null) {
            room.removeUser(user);
            user.setRoom(null);
        }
    }
}
