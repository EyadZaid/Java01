package training.expires.commands;

public class FactoryCommand {

    public ICommand getCommand(CommandType commandType) {

        if(commandType == null){
            return null;
        }

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

        return command;
    }
}
