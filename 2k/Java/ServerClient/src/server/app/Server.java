package server.app;

import server.utils.ConsoleServerWriter;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    public static final int PORT = 8080;
    private ServerSocket serverSocket;
    private ConsoleServerWriter consoleServerWriter;
    private static List<Socket> clients = new ArrayList<Socket>();

    public Server() {
        try {
            consoleServerWriter = new ConsoleServerWriter();
            serverSocket = new ServerSocket(PORT);
            while (true) {
                Socket socket = serverSocket.accept();

                consoleServerWriter.write("New client!");
                clients.add(socket);

                ClientHandler clientHandler = new ClientHandler(socket);
                new Thread(clientHandler).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Socket> getClients(){
        return clients;
    };
}
