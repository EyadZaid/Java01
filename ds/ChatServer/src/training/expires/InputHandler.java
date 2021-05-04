package training.expires;

import training.expires.commands.*;
import training.expires.userHandler.User;

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

            case NICKNAME -> command = new NicknameCommand();

            case LIST -> command = new ListCommand();

            case LEAVE -> command = new LeaveCommand();

            case PRIVATE_MSG -> command = new PrivateMsgCommand();

            case QUIT -> command = new QuitCommand();

            default -> command = null;
        }

        if (command != null) {
            command.execute(input, user);
        }
    }
}
