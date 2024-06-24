package exceptions;

/**
 * The {@code NonexistentException} class represents an exception that is thrown when an attempt is made
 * to access a row or column index that does not exist.
 * <p>
 * This exception is used to indicate that a specified index is out of bounds or invalid within the context
 * of a table or grid structure.
 * </p>
 *
 * <pre>
 * {@code
 * if (rowIndex >= table.getRows().size()) {
 *     throw new NonexistentException("Row index " + rowIndex);
 * }
 * }
 * </pre>
 *
 * @version 1.0
 * @since 2024-06-24
 */
public class NonexistentException extends Exception {

    /**
     * Constructs a {@code NonexistentException} with no detail message.
     */
    public NonexistentException() {}

    /**
     * Constructs a {@code NonexistentException} with the specified detail message.
     *
     * @param message the detail message
     */
    public NonexistentException(String message) {
        super(message);
    }
}
