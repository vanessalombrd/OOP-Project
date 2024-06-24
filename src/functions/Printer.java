package functions;

import components.cell.Cell;
import components.row.Row;
import components.table.Table;

import java.util.List;

/**
 * The {@code Printer} class provides functionality to print the contents of a {@link Table} in a formatted manner.
 * <p>
 * This class ensures that all rows have the same number of cells before printing, filling in empty cells as needed.
 * </p>
 *
 * <pre>
 * {@code
 * Table table = new Table(new TypeChecker());
 * // Populate table with rows and cells
 * Printer printer = new Printer(table);
 * printer.print();
 * }
 * </pre>
 *
 * @version 1.0
 * @since 2024-06-24
 */
public class Printer {
    private final Table table;

    /**
     * Constructs a {@code Printer} with the specified {@link Table}.
     *
     * @param table the table to be printed
     */
    public Printer(Table table) {
        this.table = table;
    }

    /**
     * Returns the table associated with this printer.
     *
     * @return the table associated with this printer
     */
    public Table getTable() {
        return table;
    }

    /**
     * Prints the contents of the table in a formatted manner.
     * Each cell value is printed with a fixed width, and rows are printed line by line.
     */
    public void print() {
        fillCells();

        for (Row row : table.getRows()) {
            List<Cell<Object>> cells = row.getCells();
            for (Cell<Object> cell : cells) {
                System.out.printf("%20s|", cell.getValue());
            }
            System.out.println();
        }
    }

    /**
     * Ensures that all rows have the same number of cells by filling in empty cells as needed.
     */
    private void fillCells() {
        int maxSize = 0;
        for (Row row : table.getRows()) {
            int size = row.getCells().size();
            if (size > maxSize) {
                maxSize = size;
            }
        }
        for (int i = 0; i < table.getRows().size(); i++) {
            while (table.getRows().get(i).getCells().size() < maxSize) {
                table.getRows().get(i).addCell(new Cell<>(""));
            }
        }
    }
}
