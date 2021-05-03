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
    private String name;

    public User(Socket socket) throws IOException{
        this.socket = socket;
        writer = new PrintWriter(socket.getOutputStream());
    }

    //--------------------------------------------
    public void sendMessage(String msg) {
        if (!socket.isClosed()) {
            writer.println(msg);
            writer.flush();
        }
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
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
