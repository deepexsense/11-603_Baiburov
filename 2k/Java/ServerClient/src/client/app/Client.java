package client.app;

import client.utils.*;

import java.io.IOException;
import java.net.Socket;

public class Client {
    public static final String ADDRESS = "127.0.0.1";
    public static final int PORT = 8080;

    private Socket socket;
    private Reader userReader;
    private Writer userWriter;

    private String nickname;

    public Client() {
        try {
            socket = new Socket(ADDRESS, PORT);
            userReader = new ConsoleUserReader();
            userWriter = new ConsoleUserWriter();

            userWriter.write("Enter nickname");
            nickname = userReader.read();
            userWriter.write("Now you can write messages");

            ReadRunnable readRunnable = new ReadRunnable(socket.getInputStream());
            new Thread(readRunnable).start();

            WriteRunnable writeRunnable = new WriteRunnable(socket.getOutputStream(), nickname);
            new Thread(writeRunnable).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}