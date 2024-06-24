package menu.commands;

import components.table.Table;
import exceptions.ClosedFileException;
import fileOperations.Writer;
import menu.Command;
import messages.Messages;

/**
 * The {@code SaveAsCommand} class implements the {@code Command} interface to save the changes made to the table to a specified file.
 * This command allows the user to specify the path of the file to save the table's contents.
 *
 * <pre>
 * {@code
 * Table table = new Table(new TypeChecker());
 * Writer writer = new TextFileWriter();
 * SaveAsCommand saveAsCommand = new SaveAsCommand(writer, table);
 * saveAsCommand.execute(new String[] {"saveas", "newFile.csv"});
 * }
 * </pre>
 *
 * @version 1.0
 * @since 2024-06-24
 */
public class SaveAsCommand implements Command {
    private final Writer writer;
    private final Table table;

    /**
     * Constructs a {@code SaveAsCommand} with the specified {@link Writer} and {@link Table}.
     *
     * @param writer the writer to be used for saving the table
     * @param table  the table whose contents are to be saved
     */
    public SaveAsCommand(Writer writer, Table table) {
        this.writer = writer;
        this.table = table;
    }

    /**
     * Executes the save as command. This method performs the following steps:
     * <ol>
     *     <li>Checks if the table's file is open.</li>
     *     <li>Saves the specified file name in a new variable.</li>
     *     <li>The writer writes the table's contents to the specified file.</li>
     *     <li>Displays an appropriate message depending on whether and what kind of error was encountered.</li>
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
                String newFile = data[1];
                writer.write(newFile, table);
                System.out.println(Messages.FILE_SUCCESS("saved another", newFile));
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(Messages.OUT_OF_BOUNDS());
            } catch (Exception e) {
                System.out.println(Messages.ERROR("saving another"));
            }
        }
    }
}
