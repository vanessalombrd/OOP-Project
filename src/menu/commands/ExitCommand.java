package menu.commands;

import menu.Command;

public class ExitCommand implements Command {
    @Override
    public void execute(String[] data) {
        System.out.println("Exiting the program...");
        System.exit(0);
    }
}
