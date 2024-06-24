package menu.commands;

import components.table.Table;
import exceptions.ClosedFileException;
import exceptions.NonexistentException;
import functions.Editor;
import menu.Command;
import messages.Messages;

/**
 * The {@code EditCommand} class implements the {@code Command} interface to change the content of a specified cell.
 * The cell is identified by its row and column, and a new value is provided.
 *
 * <pre>
 * {@code
 * Table table = new Table(new TypeChecker());
 * Editor editor = new Editor(table);
 * EditCommand editCommand = new EditCommand(editor, table);
 * editCommand.execute(new String[] {"edit", "1", "2", "newValue"});
 * }
 * </pre>
 *
 * @version 1.0
 * @since 2024-06-24
 */
public class EditCommand implements Command {
    private final Editor editor;
    private final Table table;

    /**
     * Constructs an {@code EditCommand} with the specified {@link Editor} and {@link Table}.
     *
     * @param editor the editor to be used for editing the cell
     * @param table  the table containing the cell to be edited
     */
    public EditCommand(Editor editor, Table table) {
        this.editor = editor;
        this.table = table;
    }

    /**
     * Executes the edit command. The command expects four sub-commands from the user:
     * <ol>
     *     <li>The name of the command</li>
     *     <li>The row of the table</li>
     *     <li>The column of the table</li>
     *     <li>The new value for the cell</li>
     * </ol>
     * All possible errors that may arise are caught and handled.
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
                int row = Integer.parseInt(data[1]);
                int column = Integer.parseInt(data[2]);
                StringBuilder newValue = new StringBuilder();
                for (int i = 3; i < data.length; i++) {
                    newValue.append(data[i]);
                }
                editor.edit(row, column, newValue.toString());
                System.out.println(Messages.FILE_SUCCESS("edited", table.getFilePath()));
            } catch (NumberFormatException e) {
                System.out.println(Messages.NOT_INTEGER());
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(Messages.OUT_OF_BOUNDS(e.getMessage()));
            } catch (NonexistentException e) {
                System.out.println(e.getMessage() + " doesn't exist");
            } catch (Exception e) {
                System.out.println(Messages.ERROR("editing"));
            }
        }
    }
}
