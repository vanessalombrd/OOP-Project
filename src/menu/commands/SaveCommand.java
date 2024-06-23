package menu.commands;

import components.table.Table;
import exceptions.ClosedFileException;
import fileOperations.Writer;
import menu.Command;
import messages.Messages;

/**
 * Записва направените промени обратно в същия файл,
 * от който са били прочетени данните.
 */
public class SaveCommand implements Command {
    private final Writer writer;
    private final Table table;

    public SaveCommand(Writer writer, Table table) {
        this.writer = writer;
        this.table = table;
    }

    /**
     * Writer-ът записва таблицата в нейния файл
     * и по този начин промените се запазват.
     * При непредвиден проблем се хвърля грешка.
     *
     * @param data масив от частите на командата
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
