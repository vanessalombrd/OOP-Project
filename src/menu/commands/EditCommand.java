package menu.commands;

import components.table.Table;
import exceptions.NonexistentException;
import functions.Editor;
import menu.Command;
import messages.Messages;

/**
 * Променя съдържанието на дадена клетка,
 * като я търси по ред и колона
 * и се въвежда новата й стойност.
 */
public class EditCommand implements Command {
    private final Editor editor;
    private final Table table;

    public EditCommand(Editor editor, Table table) {
        this.editor = editor;
        this.table = table;
    }

    /**
     * Въвеждат се от потребителя 4 подкоманди:
     * 1. името на командата
     * 2. ред от таблицата
     * 3. колона от таблицата
     * 4. нова стойност на тази клетка
     * Хванати са всички възможни грешки, които може да възникнат
     *
     * @param data масив от частите на командата
     */
    @Override
    public void execute(String[] data) {
        try {
            int row = Integer.parseInt(data[1]);
            int column = Integer.parseInt(data[2]);
            String newValue = data[3];
            editor.edit(row, column, newValue);
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
