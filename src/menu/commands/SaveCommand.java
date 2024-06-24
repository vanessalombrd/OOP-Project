package menu.commands;

import components.table.Table;
import exceptions.ClosedFileException;
import fileOperations.Writer;
import menu.Command;
import messages.Messages;

/**
 * The {@code SaveCommand} class implements the {@code Command} interface to save the changes made to the table
 * back to the same file from which the data was read.
 *
 * <pre>
 * {@code
 * Table table = new Table(new TypeChecker());
 * Writer writer = new TextFileWriter();
 * SaveCommand saveCommand = new SaveCommand(writer, table);
 * saveCommand.execute(new String[] {"save"});
 * }
 * </pre>
 *
 * @version 1.0
 * @since 2024-06-24
 */
public class SaveCommand implements Command {
    private final Writer writer;
    private final Table table;

    /**
     * Constructs a {@code SaveCommand} with the specified {@link Writer} and {@link Table}.
     *
     * @param writer the writer to be used for saving the table
     * @param table  the table whose contents are to be saved
     */
    public SaveCommand(Writer writer, Table table) {
        this.writer = writer;
        this.table = table;
    }

    /**
     * Executes the save command. This method performs the following steps:
     * <ol>
     *     <li>Checks if the table's file is open.</li>
     *     <li>The writer writes the table's contents back to the file it was read from, saving any changes made.</li>
     *     <li>Displays an appropriate message if an error occurs.</li>
     * </ol>
     *
     * @param data an array of command parts
     * @throws ClosedFileException if the table's file is closed
     */
    @Override
    public void execute(String[] data) throws ClosedFileException {
        if (table.getFilePath() == null) {
            throw new ClosedFileException();
        } else {
            try {
                writer.write(table.getFilePath(), table);
                System.out.println(Messages.FILE_SUCCESS("saved", table.getFilePath()));
            } catch (Exception e) {
                System.out.println(Messages.ERROR("saving"));
            }
        }
    }
}
