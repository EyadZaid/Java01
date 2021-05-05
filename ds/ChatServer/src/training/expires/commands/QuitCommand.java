package training.expires.commands;

import training.expires.ChatManager;
import training.expires.userHandler.User;

public class QuitCommand implements ICommand {
    @Override
    public void execute(String input, User user) {
        var chatManager = ChatManager.getInstance();
        var threadUser = chatManager.getThreadUserMap().get(user);

        threadUser.stop();
        user.closeSocket();

        var thread = chatManager.getThreads().get(user);

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
