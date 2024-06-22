package menu.commands;

import components.table.Table;
import menu.Command;

public class CloseCommand implements Command {
    private final Table table;

    public CloseCommand(Table table) {
        this.table = table;
    }

    @Override
    public void execute(String[] data) {
        table.setFilePath(null);
    }
}
