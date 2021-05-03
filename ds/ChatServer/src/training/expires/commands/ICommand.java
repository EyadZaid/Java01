package training.expires.commands;

import training.expires.User;

public interface ICommand {
    void execute(String input, User user);
}
