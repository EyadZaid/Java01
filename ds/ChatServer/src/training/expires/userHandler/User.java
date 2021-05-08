package training.expires.userHandler;

import training.expires.ChatManager;
import training.expires.Room;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.*;

public class User {
    private final Socket socket;
    private final PrintWriter writer;
    private Room room;
    private String nickname;
    private final String uniqueID;
    private final Date date;
    private final SimpleDateFormat formatter;

    public User(Socket socket) throws IOException{
        this.socket = socket;
        writer = new PrintWriter(socket.getOutputStream());
        nickname = "Anonymous";
        uniqueID = UUID.randomUUID().toString();
        date = new Date();
        formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
    }

    public void sendMessage(String msg, User user) {
        if (!socket.isClosed()) {
            writer.println("[" + formatter.format(date) + " from:" +
                    user.getNickname() + "]"+ ": " + msg);
            writer.flush();
        }
    }

    public void sendMessage(String msg) {
        if (!socket.isClosed()) {
            writer.println("[" + formatter.format(date) + "]"+ ": " + msg);
            writer.flush();
        }
    }

    public void availableRooms() {
        StringBuilder str = new StringBuilder("Available Rooms:\n");
        ChatManager chatManager = ChatManager.getInstance();
        List<Room> rooms = new ArrayList<Room> (chatManager.getRooms().values());

        for (var r : rooms) {
            str.append(r.getName() + "\n");
        }

        if (!socket.isClosed()) {
            writer.println(str);
            writer.flush();
        }
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public InputStream getInputStream() throws IOException {
        return socket.getInputStream();
    }

    public void closeSocket() {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(uniqueID, user.uniqueID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uniqueID);
    }

}
