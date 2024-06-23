package menu.commands;

import functions.Formula1;
import functions.Printer;
import menu.Command;
import messages.Messages;

/**
 * Принтира съдържанието на таблицата в конзолата.
 */
public class PrintCommand implements Command {
    private final Printer printer;
    private final Formula1 formula1;

    public PrintCommand(Printer printer, Formula1 formula1) {
        this.printer = printer;
        this.formula1 = formula1;
    }

    /**
     * Ако се съдържа формула в някоя от клетките на таблицата,
     * тя се изчислява с метода на формулата.
     * След това се принтира съдържанието на таблицата
     * с промените, ако има такива.
     * При непредвидена грешка се извежда подходящо съобщение.
     *
     * @param data масив от частите на командата
     */
    @Override
    public void execute(String[] data) {
        try {
            formula1.calculator();
            printer.print();
        } catch (Exception e) {
            System.out.println(Messages.ERROR("printing"));
        }
    }
}
