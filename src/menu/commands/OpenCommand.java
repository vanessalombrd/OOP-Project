package menu.commands;

import components.table.Table;
import fileOperations.Reader;
import menu.Command;
import messages.Messages;

import java.io.File;

/**
 * The {@code OpenCommand} class implements the {@code Command} interface to load the contents of a given file.
 * <p>
 * If the file does not exist, a new file with the specified name is created with empty content.
 * All other commands can only be executed if a file has been successfully loaded.
 * If an error occurs while loading the data, the application displays an appropriate error message and terminates.
 * </p>
 *
 * <pre>
 * {@code
 * Table table = new Table(new TypeChecker());
 * Reader reader = new TextFileReader(new TypeChecker());
 * OpenCommand openCommand = new OpenCommand(reader, table);
 * openCommand.execute(new String[] {"open", "data.csv"});
 * }
 * </pre>
 *
 * @version 1.0
 * @since 2024-06-24
 */
public class OpenCommand implements Command {
    private final Reader reader;
    private final Table table;

    /**
     * Constructs an {@code OpenCommand} with the specified {@link Reader} and {@link Table}.
     *
     * @param reader the reader to be used for reading the file
     * @param table  the table to be populated with the file data
     */
    public OpenCommand(Reader reader, Table table) {
        this.reader = reader;
        this.table = table;
    }

    /**
     * Executes the open command. This method performs the following steps:
     * <ol>
     *     <li>Checks if the file exists.</li>
     *     <li>If the file exists, it is opened and read by the reader.</li>
     *     <li>If the file does not exist, a new file with the specified name is created.</li>
     *     <li>Throws an error if an unexpected problem occurs.</li>
     * </ol>
     *
     * @param data an array of command parts
     */
    @Override
    public void execute(String[] data) {
        try {
            String fileName = data[1];
            File file = new File(fileName);
            if (file.exists()) {
                reader.read(fileName, table);
                System.out.println(Messages.FILE_SUCCESS("opened", fileName));
            } else {
                if (file.createNewFile()) {
                    System.out.println(Messages.CREATE_FILE_SUCCESS(fileName));
                } else {
                    System.out.println(Messages.CREATE_FILE_FAIL(fileName));
                }
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println(Messages.OUT_OF_BOUNDS());
        } catch (Exception e) {
            System.out.println(Messages.ERROR("opening"));
        }
    }
}
