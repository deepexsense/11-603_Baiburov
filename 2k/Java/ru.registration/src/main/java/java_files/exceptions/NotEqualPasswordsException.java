package java_files.exceptions;

public class NotEqualPasswordsException extends Exception {
    public NotEqualPasswordsException() {
        super();
    }

    public NotEqualPasswordsException(String message) {
        super(message);
    }
}
