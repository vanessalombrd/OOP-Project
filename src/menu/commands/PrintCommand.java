package menu.commands;

import exceptions.ClosedFileException;
import functions.Formula1;
import functions.Printer;
import menu.Command;
import messages.Messages;

/**
 * The {@code PrintCommand} class implements the {@code Command} interface to print the contents of the table to the console.
 * <p>
 * If any cell in the table contains a formula, it is calculated using the {@link Formula1} class.
 * The updated contents of the table are then printed.
 * </p>
 *
 * <pre>
 * {@code
 * Table table = new Table(new TypeChecker());
 * Printer printer = new Printer(table);
 * Formula1 formula1 = new Formula1(table);
 * PrintCommand printCommand = new PrintCommand(printer, formula1);
 * printCommand.execute(new String[] {"print"});
 * }
 * </pre>
 *
 * @version 1.0
 * @since 2024-06-24
 */
public class PrintCommand implements Command {
    private final Printer printer;
    private final Formula1 formula1;

    /**
     * Constructs a {@code PrintCommand} with the specified {@link Printer} and {@link Formula1}.
     *
     * @param printer  the printer to be used for printing the table
     * @param formula1 the formula evaluator to be used for calculating cell formulas
     */
    public PrintCommand(Printer printer, Formula1 formula1) {
        this.printer = printer;
        this.formula1 = formula1;
    }

    /**
     * Executes the print command. This method performs the following steps:
     * <ol>
     *     <li>Checks if the table's file is open.</li>
     *     <li>If the file is open, any formulas in the cells are calculated using the formula evaluator.</li>
     *     <li>The contents of the table are then printed to the console.</li>
     *     <li>If an unexpected error occurs, an appropriate error message is displayed.</li>
     * </ol>
     *
     * @param data an array of command parts
     * @throws ClosedFileException if the table's file is closed
     */
    @Override
    public void execute(String[] data) throws ClosedFileException {
        if (printer.getTable().getFilePath() == null) {
            throw new ClosedFileException();
        } else {
            try {
                formula1.calculator();
                printer.print();
            } catch (Exception e) {
                System.out.println(Messages.ERROR("printing"));
            }
        }
    }
}
