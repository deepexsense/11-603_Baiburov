package client.utils;

import java.util.Scanner;

public class ConsoleUserReader implements Reader {
    private Scanner scanner;

    public ConsoleUserReader() {
        scanner = new Scanner(System.in);
    }

    public String read() {
        return scanner.nextLine();
    }
}
