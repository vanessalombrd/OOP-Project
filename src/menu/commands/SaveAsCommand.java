package menu.commands;

import components.table.Table;
import exceptions.ClosedFileException;
import fileOperations.Writer;
import menu.Command;
import messages.Messages;

/**
 * Записва направените промени във файл,
 * като позволява на потребителя да укаже неговия път.
 */
public class SaveAsCommand implements Command {
    private final Writer writer;
    private final Table table;

    public SaveAsCommand(Writer writer, Table table) {
        this.writer = writer;
        this.table = table;
    }

    /**
     * Запазва се въведеното име на файл в нова променлива.
     * Writer-ът записва съдържанието на таблицата в този файл.
     * Извежда се подходящо съобщение
     * в зависимост дали и каква грешка е намерена.
     *
     * @param data масив от частите на командата
     */
    @Override
    public void execute(String[] data) throws ClosedFileException {
        if (table.getFilePath() == null) {
            throw new ClosedFileException();
        } else {
            try {
                String newFile = data[1];
                writer.write(newFile, table);
                System.out.println(Messages.FILE_SUCCESS("saved another", newFile));
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(Messages.OUT_OF_BOUNDS());
            } catch (Exception e) {
                System.out.println(Messages.ERROR("saving another"));
            }
        }
    }
}
