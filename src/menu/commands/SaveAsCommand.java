package menu.commands;

import components.table.Table;
import fileOperations.Writer;
import menu.Command;

public class SaveAsCommand implements Command {
    private Writer writer;
    private Table table;

    public SaveAsCommand(Writer writer, Table table) {
        this.writer = writer;
        this.table = table;
    }

    @Override
    public void execute(String[] data) {
        writer.write(data[1], table);
    }
}
