package menu;

import checker.TypeChecker;
import components.table.Table;
import fileOperations.TextFileReader;
import functions.Editor;
import functions.Formula1;
import functions.Printer;
import menu.commands.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MenuInvoker {
    private final Table table;
    private Formula1 formula1;
    private final Map<TypeOfCommand, Command> menu = new HashMap<>();

    public MenuInvoker() {
        this.table = new Table(new TypeChecker());
        this.formula1 = new Formula1(table);
        fillMenu();
    }

    private void fillMenu() {
        menu.put(TypeOfCommand.EDIT, new EditCommand(new Editor(table)));
        menu.put(TypeOfCommand.PRINT, new PrintCommand(new Printer(table), formula1));
        menu.put(TypeOfCommand.HELP, new HelpCommand());
        menu.put(TypeOfCommand.OPEN, new OpenCommand(new TextFileReader(new TypeChecker()), table));
//        menu.put(TypeOfCommand.CLOSE, new CloseCommand(AAAA));
//        menu.put(TypeOfCommand.EXIT, new ExitCommand(AAA));
//        menu.put(TypeOfCommand.SAVE, new SaveCommand(AAA));
//        menu.put(TypeOfCommand.SAVEAS, new SaveAsCommand(AAAA));
    }

    public void run() throws Exception {
        menu.get(TypeOfCommand.HELP).execute(null);

        Scanner scanner = new Scanner(System.in);

        while(true) {
            String[] input = scanner.nextLine().split("\\s");
            input[0] = input[0].toUpperCase(); //  za da go prevurne v enum
            TypeOfCommand command = TypeOfCommand.valueOf(input[0]);

            if (input[0].equalsIgnoreCase("EXIT")) {
                break; // exit
            }

            if (menu.containsKey(command)) {
                menu.get(command).execute(input);
                System.out.println("Enter new option:");
            } else {
                throw new Exception("Command Error, try again");
            }

        }
    }

}
