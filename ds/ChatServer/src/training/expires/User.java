package training.expires;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class User {
    private final Socket socket;
    private final PrintWriter writer;
    private Room room;

    public User(Socket socket, Room room) throws IOException{
        this.socket = socket;
        this.room = room;
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
}
