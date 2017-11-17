package java_files.exceptions;

public class NotCorrectLoginDataException extends Exception {
    public NotCorrectLoginDataException() {
        super();
    }

    public NotCorrectLoginDataException(String message) {
        super(message);
    }
}
