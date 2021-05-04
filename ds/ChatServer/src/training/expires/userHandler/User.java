package training.expires.userHandler;

import training.expires.ChatManager;
import training.expires.Room;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class User {
    private final Socket socket;
    private final PrintWriter writer;
    private Room room;
    private String nickname;
    private final String uniqueID;

    public User(Socket socket) throws IOException{
        this.socket = socket;
        writer = new PrintWriter(socket.getOutputStream());
        nickname = "Anonymous";
        uniqueID = UUID.randomUUID().toString();
    }

    public void sendMessage(String msg, User user) {
        if (!socket.isClosed()) {
            writer.println(user.getNickname() + ": " + msg);
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
