package menu.commands;

import components.table.Table;
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
     *
     * @param data масив от частите на командата
     */

    @Override
    public void execute(String[] data) {
        try {
            writer.write(table.getFilePath(), table);
            System.out.println();
        } catch (Exception e) {
            System.out.println(Messages.ERROR("saving"));
        }
    }
}
