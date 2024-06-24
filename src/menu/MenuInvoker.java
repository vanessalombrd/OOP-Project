package menu;

import checker.TypeChecker;
import components.table.Table;
import fileOperations.TextFileReader;
import fileOperations.TextFileWriter;
import functions.Editor;
import functions.Formula1;
import functions.Printer;
import exceptions.ClosedFileException;
import menu.commands.*;
import messages.Messages;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * The {@code MenuInvoker} class is responsible for invoking commands based on user input.
 * It initializes the menu with various commands and provides a method to run the menu, continuously listening for user input.
 * <p>
 * The class supports commands such as EDIT, PRINT, HELP, OPEN, CLOSE, EXIT, SAVE, and SAVEAS.
 * </p>
 *
 * <pre>
 * {@code
 * MenuInvoker menuInvoker = new MenuInvoker();
 * menuInvoker.run();
 * }
 * </pre>
 *
 * @version 1.0
 * @since 2024-06-24
 */
public class MenuInvoker {
    private final Table table;
    private final Formula1 formula1;
    private final Map<TypeOfCommand, Command> menu = new HashMap<>();

    /**
     * Constructs a {@code MenuInvoker} and initializes the table and formula evaluator.
     * It also populates the menu with available commands.
     */
    public MenuInvoker() {
        this.table = new Table(new TypeChecker());
        this.formula1 = new Formula1(table);
        fillMenu();
    }

    /**
     * Populates the menu with available commands.
     */
    private void fillMenu() {
        menu.put(TypeOfCommand.EDIT, new EditCommand(new Editor(table), table));
        menu.put(TypeOfCommand.PRINT, new PrintCommand(new Printer(table), formula1));
        menu.put(TypeOfCommand.HELP, new HelpCommand());
        menu.put(TypeOfCommand.OPEN, new OpenCommand(new TextFileReader(new TypeChecker()), table));
        menu.put(TypeOfCommand.CLOSE, new CloseCommand(table));
        menu.put(TypeOfCommand.EXIT, new ExitCommand());
        menu.put(TypeOfCommand.SAVE, new SaveCommand(new TextFileWriter(), table));
        menu.put(TypeOfCommand.SAVEAS, new SaveAsCommand(new TextFileWriter(), table));
    }

    /**
     * Runs the menu, continuously listening for user input and executing the corresponding command.
     * <p>
     * This method will print the HELP menu initially and then wait for user input.
     * It handles exceptions and prints appropriate error messages.
     * </p>
     *
     * @throws ClosedFileException if a command is executed on a closed file
     */
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
