package training.expires.commands;

import training.expires.User;

public class NicknameCommand implements ICommand {

    @Override
    public void execute(String input, User user) {
        String[] arrInput = input.split(" ");

        if (arrInput.length < 2) {
            return;
        }

        String nickname = arrInput[1].trim().toLowerCase();
        user.setNickname(nickname);
    }
}
