package menu.commands;

import components.table.Table;
import menu.Command;
import messages.Messages;

/**
 * Затваря текущо отворения документ.
 * Затварянето изчиства текущо заредената информация
 * и след това програмата не може да изпълнява други команди,
 * освен отваряне на файл (Open).
 */
public class CloseCommand implements Command {
    private final Table table;

    public CloseCommand(Table table) {
        this.table = table;
    }

    /**
     * Пътят към файла на таблицата се нулира
     * и по този начин файлът се затваря
     *
     * @param data масив от частите на командата
     */
    @Override
    public void execute(String[] data) {
        String path = table.getFilePath();
        table.setFilePath(null);
        System.out.println(Messages.FILE_SUCCESS("closed", path));
    }
}
