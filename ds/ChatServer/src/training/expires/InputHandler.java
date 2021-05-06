package training.expires;

import training.expires.commands.*;
import training.expires.userHandler.User;

public class InputHandler {
    private final String input;
    private final User user;
    private final FactoryCommand factoryCommand;

    public InputHandler(String input, User user) {
        this.input = input;
        this.user = user;
        factoryCommand = new FactoryCommand();
    }

    public void handleInput() {
        String[] arrInput = input.split(" ");

        if (arrInput.length < 1) {
            return;
        }

        CommandType commandType = CommandType.getCommandType(arrInput[0]);
        ICommand command = factoryCommand.getCommand(commandType);

        if (command != null) {
            command.execute(input, user);
        }
    }
}
