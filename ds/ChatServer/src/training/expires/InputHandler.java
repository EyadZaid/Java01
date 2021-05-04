package training.expires;

import training.expires.commands.*;

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

            default -> command = null;
        }
        
        command.execute(input, user);
    }
}
