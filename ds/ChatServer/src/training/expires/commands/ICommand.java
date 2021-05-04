package training.expires.commands;

import training.expires.userHandler.User;

public interface ICommand {
    void execute(String input, User user);
}
