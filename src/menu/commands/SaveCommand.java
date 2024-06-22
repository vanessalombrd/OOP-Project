package menu.commands;

import components.table.Table;
import fileOperations.Writer;
import menu.Command;

public class SaveCommand implements Command {
    private final Writer writer;
    private final Table table;

    public SaveCommand(Writer writer, Table table) {
        this.writer = writer;
        this.table = table;
    }

    @Override
    public void execute(String[] data) {
        writer.write(table.getFilePath(), table);
    }
}
