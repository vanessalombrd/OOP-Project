package exceptions;

/**
 * Изключение при въведен индекс на
 * ред или колона, който не съществува
 */
public class NonexistentException extends Exception {
    public NonexistentException() {}

    public NonexistentException(String message) {
        super(message);
    }
}
