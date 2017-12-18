package server.utils;

import client.utils.Writer;

public class ConsoleServerWriter implements Writer {
    public void write(String message) {
        System.out.println(message);
    }
}
