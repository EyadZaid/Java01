package training.expires.commands;

import training.expires.Room;
import training.expires.User;

import java.io.IOException;

public class MessageCommand implements ICommand {

    @Override
    public void execute(String input, User user) {
        Room room = user.getRoom();
        if (room != null) {
            try {
                room.sendMessage(input, user);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
