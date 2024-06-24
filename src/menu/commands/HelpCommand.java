package menu.commands;

import menu.Command;

/**
 * The {@code HelpCommand} class implements the {@code Command} interface to display information
 * about the commands supported by the program.
 * <p>
 * This command outputs a list of supported commands along with a brief description of each.
 * </p>
 *
 * <pre>
 * {@code
 * HelpCommand helpCommand = new HelpCommand();
 * helpCommand.execute(new String[] {"help"});
 * }
 * </pre>
 *
 * @version 1.0
 * @since 2024-06-24
 */
public class HelpCommand implements Command {

    /**
     * Executes the help command. This method prints a list of supported commands and their descriptions.
     *
     * @param data an array of command parts
     */
    @Override
    public void execute(String[] data) {
        System.out.print(
                "The following commands are supported:\n" +
                        "open <file>                    opens <file>\n" +
                        "print                          prints the opened file\n" +
                        "edit <row> <col> <newValue>    edits the cell at <row> and <col> with <newValue>\n" +
                        "close                          closes currently opened file\n" +
                        "save                           saves the currently open file\n" +
                        "saveas <file>                  saves the currently open file in <file>\n" +
                        "help                           prints this information\n" +
                        "exit                           exits the program\n" +
                        "\n> ");
    }
}
