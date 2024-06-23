package menu.commands;

import components.table.Table;
import exceptions.NonexistentException;
import functions.Editor;
import menu.Command;
import messages.Messages;

public class EditCommand implements Command {
    private final Editor editor;
    private final Table table;

    public EditCommand(Editor editor, Table table) {
        this.editor = editor;
        this.table = table;
    }

    @Override
    public void execute(String[] data) {
        try {
            editor.edit(Integer.parseInt(data[1]), Integer.parseInt(data[2]), data[3]);
            System.out.println(Messages.FILE_SUCCESS("edited", table.getFilePath()));
        } catch (NumberFormatException e) {
            System.out.println("One or more of the provided values not a valid integer");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Insufficient data provided");
        } catch (NonexistentException e) {
            System.out.println(e.getMessage() + " doesn't exist");
        } catch (Exception e) {
            System.out.println(Messages.ERROR("editing"));
        }
    }
}
