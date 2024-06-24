package exceptions;

/**
 * The {@code ClosedFileException} class represents an exception that is thrown when an attempt is made
 * to execute a command that requires an open file, but no file is currently open.
 * <p>
 * This exception ensures that certain operations are only performed when a file is open.
 * </p>
 *
 * <pre>
 * {@code
 * if (table.getFilePath() == null) {
 *     throw new ClosedFileException();
 * }
 * }
 * </pre>
 *
 * @version 1.0
 * @since 2024-06-24
 */
public class ClosedFileException extends Exception {

    /**
     * Constructs a {@code ClosedFileException} with no detail message.
     */
    public ClosedFileException() {}

    /**
     * Returns the detail message string of this throwable.
     *
     * @return the detail message string of this {@code ClosedFileException} instance (which is "Closed file")
     */
    @Override
    public String getMessage() {
        return "Closed file";
    }
}
