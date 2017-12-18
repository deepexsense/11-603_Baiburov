package client.app;

import client.utils.*;

import java.io.IOException;
import java.io.OutputStream;

public class WriteRunnable implements Runnable {
    private Writer serverWriter;
    private Reader userReader;
    private String nickname;
    private Writer userWriter;

    public WriteRunnable(OutputStream os, String nickname) {
        this.serverWriter = new ServerWriterImpl(os);
        userReader = new ConsoleUserReader();
        this.nickname = nickname;
        userWriter = new ConsoleUserWriter();
    }

    public void run() {
        while (true) {
            String sendMessage = null;
            try {
                sendMessage = userReader.read();
            } catch (IOException e) {
                userWriter.write("error");
            }
            serverWriter.write(nickname + ": " + sendMessage);
        }
    }
}
