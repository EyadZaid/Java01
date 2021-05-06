package training.expires.userHandler;

import training.expires.commands.*;

public class UserInputHandler {
    private final String input;
    private final User user;
    private final FactoryCommand factoryCommand;

    public UserInputHandler(String input, User user) {
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
