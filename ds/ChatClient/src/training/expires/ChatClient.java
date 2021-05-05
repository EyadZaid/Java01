package training.expires;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ChatClient implements Runnable {
    private final static String ADDRESS = "127.0.0.1";
    private final static int PORT = 7777;
    private PrintWriter outputStream;
    private Scanner inputStream;
    private String username;
    private Socket socket;
    private boolean active;

    public ChatClient() throws IOException {
        initialize();
    }

    @Override
    public void run() {
        while (active) {
            if (inputStream.hasNextLine()) {

                String str = inputStream.nextLine();
                System.out.println(str);
            }
        }
    }

    private void initialize() throws IOException {
        active = true;
        Scanner keyboard = new Scanner(System.in);

        // get user nickname
        System.out.println("What is your name?");
        username = keyboard.next();

        // connect to server
        InetAddress host = null;
        try {
            host = InetAddress.getByName(ADDRESS);
        } catch (UnknownHostException e1) {
            System.out.println("Host not found");
        }
        System.out.println("Enter a command: ");

        socket = null;
        try {
            socket = new Socket(host, PORT);
            socket.setReuseAddress(true);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("not found");
        }
        inputStream = new Scanner(socket.getInputStream());
        outputStream = new PrintWriter(socket.getOutputStream());

        // start new thread to listen from server
        Thread t = new Thread(this);
        t.start();

        outputStream.println("nickname " + username.trim());


        // continuously listen your user input
        while (active && keyboard.hasNextLine()) {
            String input = keyboard.nextLine();
            if (input.trim().length() != 0) {
                outputStream.println(input);
            }
            outputStream.flush();

            if (input.trim().toLowerCase().equals("quit")) {
                active = false;
            }
        }
        socket.close();
    }
}