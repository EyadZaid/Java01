package training.expires.commands;

import training.expires.ChatManager;
import training.expires.userHandler.User;

public class QuitCommand implements ICommand {
    @Override
    public void execute(String input, User user) {
        //var users = ChatManager.getInstance().getUsers();


        var threads = ChatManager.getInstance().getThreads();
        for (var thread : threads.values()) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
