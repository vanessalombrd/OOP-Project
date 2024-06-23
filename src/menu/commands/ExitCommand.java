package menu.commands;

import menu.Command;

/**
 * Излиза от програмата.
 */
public class ExitCommand implements Command {
    /**
     * Извежда се съобщение и се излиза от програмата
     * @param data масив от частите на командата
     */
    @Override
    public void execute(String[] data) {
        System.out.println("Exiting the program...");
        System.exit(0);
    }
}
