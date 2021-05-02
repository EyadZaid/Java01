package training.expires;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
    private final static int PORT = 7777;
    private ServerSocket serverSocket;
    private final List<Room> rooms;
    private final List<User> users;

    public ChatServer() {
        try {
            serverSocket = new ServerSocket(PORT);
            serverSocket.setReuseAddress(true);
        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        }

        rooms = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void startServer() throws IOException {
        Room room1 = new Room("room1");
        rooms.add(room1);

        System.out.println("Accepting clients...");
        while (true) {
            // wait for a client
            Socket socket = serverSocket.accept();
            System.out.println("New user accepted...");

            // Available rooms
            //Room name
            //Select room

            User user = new User(socket, room1);
            users.add(user);
            rooms.get(0).addUser(user);

            ThreadUser threadUser = new ThreadUser(user, this);

            Thread t = new Thread(threadUser);
            t.start();
        }
    }

}