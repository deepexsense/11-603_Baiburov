package client.utils;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ServerReaderImpl implements Reader {
    BufferedReader bufferedReader;

    public ServerReaderImpl(InputStream is) {
        bufferedReader = new BufferedReader(new InputStreamReader(is));
    }

    public String read() throws IOException {
        return bufferedReader.readLine();
    }
}
