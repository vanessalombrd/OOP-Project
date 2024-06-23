package menu;

import checker0.TypeChecker0;
import components.table.Table;
import exceptions.ClosedFileException;
import fileOperations.TextFileReader;
import fileOperations.TextFileWriter;
import functions.Editor;
import functions.Formula1;
import functions.Printer;
import menu.commands.*;
import messages.Messages;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MenuInvoker {
    private final Table table;
    private final Formula1 formula1;
    private final Map<TypeOfCommand, Command> menu = new HashMap<>();

    public MenuInvoker() {
        this.table = new Table(new TypeChecker0());
        this.formula1 = new Formula1(table);
        fillMenu();
    }

    private void fillMenu() {
        menu.put(TypeOfCommand.EDIT, new EditCommand(new Editor(table), table));
        menu.put(TypeOfCommand.PRINT, new PrintCommand(new Printer(table), formula1));
        menu.put(TypeOfCommand.HELP, new HelpCommand());
        menu.put(TypeOfCommand.OPEN, new OpenCommand(new TextFileReader(new TypeChecker0()), table));
        menu.put(TypeOfCommand.CLOSE, new CloseCommand(table));
        menu.put(TypeOfCommand.EXIT, new ExitCommand());
        menu.put(TypeOfCommand.SAVE, new SaveCommand(new TextFileWriter(), table));
        menu.put(TypeOfCommand.SAVEAS, new SaveAsCommand(new TextFileWriter(), table));
    }

    public void run() throws ClosedFileException {
        menu.get(TypeOfCommand.HELP).execute(null);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                String[] input = scanner.nextLine().split("\\s");
                String commandUpper = input[0].toUpperCase(); // to later convert into enum

                TypeOfCommand command = TypeOfCommand.valueOf(commandUpper);
                menu.get(command).execute(input);
            } catch (IllegalArgumentException e) {
                System.out.println("No such command");
            } catch (ClosedFileException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(Messages.ERROR() + ": " + e.getMessage());
            } finally {
                System.out.print("> ");
            }
        }
    }
}
