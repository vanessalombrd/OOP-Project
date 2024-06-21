package menu;

import checker.TypeChecker;
import components.table.Table;
import functions.Editor;
import menu.commands.EditCommand;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MenuInvoker {
    private Table table;
    private Map<TypeOfCommand, Command> menu = new HashMap<>();

    public MenuInvoker() {
        this.table = new Table(new TypeChecker());
    }

    private void fillMap() {
        menu.put(TypeOfCommand.EDIT, new EditCommand(new Editor(table)));
        // i za drugite
    }

    public void run() throws Exception {
        fillMap();

        menu.get(TypeOfCommand.HELP).execute(null);

        Scanner scanner = new Scanner(System.in);
        while(true) {
            String[] tokens = scanner.nextLine().split("\\s");
            tokens[0] = tokens[0].toUpperCase(); //  za da go prevurne v enum
            TypeOfCommand command = TypeOfCommand.valueOf(tokens[0]);

            if (menu.containsKey(command)) {
                menu.get(command).execute(tokens);
                System.out.println("Enter new option:");
            } else {
                throw new Exception("Command Error, try again");
            }
        }
    }

}
