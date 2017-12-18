package client.utils;

import java.io.OutputStream;
import java.io.PrintWriter;

public class ServerWriterImpl implements Writer {
    private PrintWriter pr;

    public ServerWriterImpl(OutputStream output) {
        pr = new PrintWriter(output);
    }

    public void write(String message) {
        pr.println(message);
        pr.flush();
    }
}
