package menu.commands;

import components.table.Table;
import fileOperations.Reader;
import menu.Command;

public class OpenCommand implements Command {
    private final Reader reader;
    private final Table table;

    public OpenCommand(Reader reader, Table table) {
        this.reader = reader;
        this.table = table;
    }

    /**
     * proba
     *
     * @param data
     */
    @Override
    public void execute(String[] data) {
        reader.read(data[1], table);
    }
}
