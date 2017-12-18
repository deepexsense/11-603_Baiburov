package server.app;

import server.utils.Reader;
import server.utils.ServerReaderImpl;
import server.utils.ServerWriterImpl;
import server.utils.Writer;

import java.io.IOException;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private Socket socket;

    public ClientHandler(Socket clientSocket) {
        this.socket = clientSocket;
    }

    public void run() {
        Reader serverReader;
        Writer serverWriter;
        try {
            serverReader = new ServerReaderImpl(socket.getInputStream());
            while(true) {
                String msg = serverReader.read();
                if(msg != null) {
                    for(Socket other : Server.getClients()) {
                        serverWriter = new ServerWriterImpl(other.getOutputStream());
                        serverWriter.write(msg);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
