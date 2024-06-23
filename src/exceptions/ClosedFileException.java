package exceptions;

public class ClosedFileException extends Exception {
    public ClosedFileException() {}

    @Override
    public String getMessage() {
        return "Closed file";
    }
}
