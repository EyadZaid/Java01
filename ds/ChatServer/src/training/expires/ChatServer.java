package training.expires;

import training.expires.userHandler.ThreadUser;
import training.expires.userHandler.User;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
    private final static int PORT = 7777;
    private final ChatManager chatManager;
    private ServerSocket serverSocket;

    public ChatServer() {
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
        while (true) {
            // wait for a client
            Socket socket = serverSocket.accept();
            System.out.println("New user accepted...");

            User user = new User(socket);
            chatManager.addUser(user);
            ThreadUser threadUser = new ThreadUser(user, this);

            Thread thread = new Thread(threadUser);
            thread.start();
            chatManager.addThread(user, thread);
            chatManager.addUserThread(user, threadUser);
        }
    }



}