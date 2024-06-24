package menu.commands;

import components.table.Table;
import menu.Command;
import messages.Messages;

/**
 * The {@code CloseCommand} class implements the {@code Command} interface to close the currently open document.
 * <p>
 * Closing the document clears the currently loaded information and the program cannot execute other commands
 * except for opening a file (Open) until a new file is opened.
 * </p>
 *
 * <pre>
 * {@code
 * Table table = new Table(new TypeChecker());
 * CloseCommand closeCommand = new CloseCommand(table);
 * closeCommand.execute(new String[] {});
 * }
 * </pre>
 *
 * @version 1.0
 * @since 2024-06-24
 */
public class CloseCommand implements Command {
    private final Table table;

    /**
     * Constructs a {@code CloseCommand} with the specified {@link Table}.
     *
     * @param table the table to be closed
     */
    public CloseCommand(Table table) {
        this.table = table;
    }

    /**
     * Closes the currently open file by resetting the file path of the table.
     * <p>
     * If the table has a file path set, it is reset to {@code null} to indicate the file is closed.
     * A success message is printed to the console. If no file is open, a message indicating that is printed instead.
     * </p>
     *
     * @param data an array of command parts
     */
    @Override
    public void execute(String[] data) {
        if (table.getFilePath() != null) {
            String path = table.getFilePath();
            table.setFilePath(null);
            System.out.println(Messages.FILE_SUCCESS("closed", path));
        } else {
            System.out.println("No file opened");
        }
    }
}
