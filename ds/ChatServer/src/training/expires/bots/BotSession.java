package training.expires.bots;

import training.expires.ChatManager;
import training.expires.Room;

import java.io.IOException;
import java.util.HashMap;

public class BotSession  implements Runnable{
    private final IBot firstBot;
    private final IBot secondBot;
    private final HashMap<String, Room> rooms;

    public BotSession(IBot firstBot, IBot secondBot) {
        this.firstBot = firstBot;
        this.secondBot = secondBot;
        rooms = ChatManager.getInstance().getRooms();
    }

    @Override
    public void run() {
        int flag = 1;

        while (true) {
            for (var e : rooms.values()) {
                if (e.getNumberOfUsers() > 0) {
                    try {
                        String str = (flag >  0) ? firstBot.doSomething() : secondBot.doSomething();
                        e.botSendMsgInRoom(str);
                        flag *= -1;
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }


            try {
                Thread.sleep(30_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
