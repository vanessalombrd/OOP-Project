package menu.commands;

import functions.Formula1;
import functions.Printer;
import menu.Command;

public class PrintCommand implements Command {
    private final Printer printer;
    private final Formula1 formula1;

    public PrintCommand(Printer printer, Formula1 formula1) {
        this.printer = printer;
        this.formula1 = formula1;
    }

    @Override
    public void execute(String[] data) {
        formula1.calculator();
        printer.print();
    }
}
