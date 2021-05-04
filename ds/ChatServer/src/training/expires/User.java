package training.expires;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Objects;

public class User {
    private final Socket socket;
    private final PrintWriter writer;
    private Room room;
    private String nickname;

    public User(Socket socket) throws IOException{
        this.socket = socket;
        writer = new PrintWriter(socket.getOutputStream());
        nickname = "Anonymous";
    }

    public void sendMessage(String msg) {
        if (!socket.isClosed()) {
            writer.println(nickname + ": " + msg);
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
        return Objects.equals(nickname, user.nickname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nickname);
    }
}
