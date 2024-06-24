package menu;

import exceptions.ClosedFileException;

/**
 * The {@code Command} interface represents a command that can be executed with a set of data.
 * Implementations of this interface should provide specific behavior for the {@link #execute(String[])} method.
 * <p>
 * This interface is part of a menu system where different commands can be executed based on user input.
 * </p>
 *
 * <pre>
 * {
 * public class OpenCommand implements Command {
 *
 *     public void execute(String[] data) throws ClosedFileException {
 *         // Implementation of the open command
 *     }
 * }
 * }
 * </pre>
 *
 * @version 1.0
 * @since 2024-06-24
 */
public interface Command {

    /**
     * Executes the command with the specified data.
     * <p>
     * Implementations of this method should define the specific behavior of the command.
     * This method may throw a {@link ClosedFileException} if the command attempts to operate on a closed file.
     * </p>
     *
     * @param data the data to be used by the command
     * @throws ClosedFileException if the command attempts to operate on a closed file
     */
    void execute(String[] data) throws ClosedFileException;
}
