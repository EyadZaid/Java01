package training.expires;

import training.expires.commands.CommandType;
import training.expires.commands.ICommand;
import training.expires.commands.MessageCommand;
import training.expires.commands.SelectRoomCommand;

public class InputHandler {
    private final String input;
    private final User user;

    public InputHandler(String input, User user) {
        this.input = input;
        this.user = user;
    }

    public void handleInput() {
        String[] arrInput = input.split(" ");

        if (arrInput.length < 1) {
            return;
        }

        CommandType commandType = CommandType.getCommandType(arrInput[0]);
        ICommand command;

        switch (commandType) {
            case ROOM_MSG -> command = new MessageCommand();

            case ROOM -> command = new SelectRoomCommand();

            default -> command = null;
        }
        
        command.execute(input, user);
    }
}
