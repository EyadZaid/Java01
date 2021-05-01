package training.expires;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ChatClientHandler implements Runnable {
    private final ChatServer server;
    private final Socket client;
    private Scanner inputStream;

    public ChatClientHandler(Socket client, ChatServer server) {
        this.client = client;
        this.server = server;
    }

    @Override
    public void run() {
        try {
            inputStream = new Scanner(client.getInputStream());
            while(true) {
                if(!inputStream.hasNext()) {
                    return;
                }
                String chatLine = inputStream.nextLine();
                System.out.println(chatLine);
                server.sendChatMessageToAll(chatLine, client);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}