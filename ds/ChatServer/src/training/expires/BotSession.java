package training.expires;

import training.expires.bots.IBot;

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

        while (true) {
            for (var e : rooms.values()) {
                if (e.getNumberOfUsers() > 0) {
                    try {
                        e.botSendMsgInRoom(firstBot.doSomething());
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }


            try {
                Thread.sleep(15_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
