package training.expires.commands;

import training.expires.ChatManager;
import training.expires.userHandler.User;

public class PrivateMsgCommand implements ICommand {

    @Override
    public void execute(String input, User user) {
        String[] arrInput = input.split(" ", 3);

        if (arrInput.length < 3) {
            return;
        }

        String username = arrInput[1].trim().toLowerCase();
        User toUser = ChatManager.getInstance().getUserByName(username);

        if (toUser == null) {
            return;
        }

        toUser.sendMessage(arrInput[2], user);
    }
}
