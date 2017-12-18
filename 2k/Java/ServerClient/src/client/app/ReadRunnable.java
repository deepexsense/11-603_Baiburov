package client.app;

import client.utils.ConsoleUserWriter;
import client.utils.Reader;
import client.utils.ServerReaderImpl;
import client.utils.Writer;

import java.io.IOException;
import java.io.InputStream;

public class ReadRunnable implements Runnable {
    private Reader serverReader;
    private Writer userWriter;

    public ReadRunnable(InputStream is) {
        serverReader = new ServerReaderImpl(is);
        userWriter = new ConsoleUserWriter();
    }

    public void run() {
        while (true) {
            String receiveMessage = null;
            try {
                receiveMessage = serverReader.read();
            } catch (IOException e) {
                userWriter.write("error");
            }
            if (receiveMessage != null) {
                userWriter.write(receiveMessage);
            }
        }

    }
}
