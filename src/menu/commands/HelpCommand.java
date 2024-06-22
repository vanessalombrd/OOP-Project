package menu.commands;

import menu.Command;

public class HelpCommand implements Command {
    public void execute(String[] data) {
        System.out.println(
                "> help\n" +
                "The following commands are supported:\n" +
                "open <file>                    opens <file>\n" +
                "print                          prints the opened file\n" +
                "edit <row> <col> <newValue>    opens <file>\n" +
                "close                          closes currently opened file\n" +
                "save                           saves the currently open file\n" +
                "saveas <file>                  saves the currently open file in <file>\n" +
                "help                           prints this information\n" +
                "exit                           exists the program");
    }
}