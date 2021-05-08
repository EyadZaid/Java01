package training.expires;

import training.expires.bots.AdditionBot;
import training.expires.bots.BotSession;
import training.expires.bots.lettersBot;
import training.expires.userHandler.UserSessionHandler;
import training.expires.userHandler.User;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
    private final static int PORT = 7777;
    private final ChatManager chatManager;
    private ServerSocket serverSocket;
    private boolean active;

    public ChatServer() {
        active = true;
        try {
            serverSocket = new ServerSocket(PORT);
            serverSocket.setReuseAddress(true);
        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        }
        chatManager = ChatManager.getInstance();
    }

    public void startServer() throws IOException {
        System.out.println("Accepting clients...");
        while (active) {
            // wait for a client
            Socket socket = serverSocket.accept();
            System.out.println("New user accepted...");

            User user = new User(socket);
            chatManager.addUser(user);
            UserSessionHandler userSessionHandler = new UserSessionHandler(user);

            Thread thread = new Thread(userSessionHandler);
            thread.start();
            chatManager.addThread(user, thread);
            chatManager.addUserThread(user, userSessionHandler);

            BotSession botSession = new BotSession(new AdditionBot(), new lettersBot());
            Thread t = new Thread(botSession);
            t.start();
        }
    }

    public void stopServer() {
        active = false;
    }

}