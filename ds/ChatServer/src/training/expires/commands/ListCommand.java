package training.expires.commands;

import training.expires.userHandler.User;

public class ListCommand implements ICommand {

    @Override
    public void execute(String input, User user) {

        user.availableRooms();

    }
}
