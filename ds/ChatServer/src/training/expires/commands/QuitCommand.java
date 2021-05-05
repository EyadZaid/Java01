package training.expires.commands;

import training.expires.ChatManager;
import training.expires.userHandler.User;

public class QuitCommand implements ICommand {
    @Override
    public void execute(String input, User user) {

        var userThreads = ChatManager.getInstance().getThreadUserMap();
        for (var userThread : userThreads.values()) {
            userThread.stop();
        }

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
