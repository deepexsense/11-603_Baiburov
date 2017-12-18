package client.utils;

public class ConsoleUserWriter implements Writer {
    public void write(String message) {
        System.out.println(message);
    }
}
