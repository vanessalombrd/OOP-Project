package menu.commands;

import components.table.Table;
import fileOperations.Reader;
import menu.Command;
import messages.Messages;

import java.io.File;

/**
 * Зарежда съдържанието на даден файл.
 * Ако такъв не съществува се създава нов с празно съдържание.
 * Всички останали команди могат да се изпълняват само ако има успешно зареден файл.
 * Ако при зареждането на данните, приложението открие грешка,
 * то извежда подходящо съобщение за грешка и прекратява своето изпълнение.
 */

public class OpenCommand implements Command {
    private final Reader reader;
    private final Table table;

    public OpenCommand(Reader reader, Table table) {
        this.reader = reader;
        this.table = table;
    }

    /**
     * Първо се проверява дали файлът съществува:
     * 1. ако съществува - отваря се и се чете от рийдъра
     * 2. ако не съществува - създава се нов файл с указаното име
     * 3. хвърля грешка, ако се появи непредвиден проблем
     *
     * @param data масив от частите на командата
     */
    @Override
    public void execute(String[] data) {
        try {
            String fileName = data[1];
            File file = new File(fileName);
            if (file.exists()) {
                reader.read(fileName, table);
                System.out.println(Messages.FILE_SUCCESS("opened", fileName));
            } else {
                if (file.createNewFile()) {
                    System.out.println(Messages.CREATE_FILE_SUCCESS(fileName));
                } else {
                    System.out.println("File " + fileName + " doesn't exist and can't be created");
                }
            }
        } catch (Exception e) {
            System.out.println(Messages.ERROR("opening"));
        }
    }
}
