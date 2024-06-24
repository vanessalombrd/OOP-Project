package menu.commands;

import menu.Command;

/**
 * The {@code ExitCommand} class implements the {@code Command} interface to exit the program.
 * <p>
 * This command outputs a message indicating the program is exiting and then terminates the program.
 * </p>
 *
 * <pre>
 * {@code
 * ExitCommand exitCommand = new ExitCommand();
 * exitCommand.execute(new String[] {"exit"});
 * }
 * </pre>
 *
 * @version 1.0
 * @since 2024-06-24
 */
public class ExitCommand implements Command {

    /**
     * Executes the exit command. This method prints a message indicating the program is exiting and then
     * terminates the program.
     *
     * @param data an array of command parts
     */
    @Override
    public void execute(String[] data) {
        System.out.println("Exiting the program...");
        System.exit(0);
    }
}
