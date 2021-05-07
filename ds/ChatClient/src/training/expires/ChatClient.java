package training.expires;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ChatClient implements Runnable {
    private final static String ADDRESS = "127.0.0.1";
    private final static int PORT = 7777;
    private final Scanner keyboard;
    private PrintWriter outputStream;
    private Scanner inputStream;
    private boolean active;
    private final Lock lock;
    private long timeLastCommand;

    public ChatClient() throws IOException {
        lock = new ReentrantLock();
        keyboard = new Scanner(System.in);
        active = true;
        timeLastCommand = -1;
        start();
    }

    public boolean isActive() {
        lock.lock();
        boolean temp = active;
        lock.unlock();
        return temp;
    }

    public void setActive(boolean active) {
        lock.lock();
        this.active = active;
        lock.unlock();
    }

    @Override
    public void run() {
        while (isActive()) {
            if (timeLastCommand != -1) {
                long currentTime = System.currentTimeMillis() - timeLastCommand;
                if ( currentTime > 10_000) {
                    setActive(false);
                    break;
                }
            }
            if (inputStream.hasNextLine()) {
                String str = inputStream.nextLine();
                System.out.println(str);
            }
        }
    }

    private void start() throws IOException {
        // get user nickname
        System.out.println("What is your name?");
        String username = keyboard.next();

        // connect to server
        InetAddress host = null;
        try {
            host = InetAddress.getByName(ADDRESS);
        } catch (UnknownHostException e1) {
            System.out.println("Host not found");
        }
        System.out.println("Start typing: ");

        Socket socket = null;
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
        listenUserInput();

        socket.close();
    }

    private void listenUserInput() {
        timeLastCommand = System.currentTimeMillis();
        while (System.currentTimeMillis() - timeLastCommand < 1000 && keyboard.hasNextLine()) {
            timeLastCommand = System.currentTimeMillis();
            String input = keyboard.nextLine();
            if (input.trim().length() != 0) {
                outputStream.println(input);
            }
            outputStream.flush();

            if (input.trim().toLowerCase().equals("quit")) {
                setActive(false);
            }
        }
    }
}