package functions;

import checker.TypeChecker;
import components.cell.Cell;
import components.row.Row;
import components.table.Table;
import exceptions.NonexistentException;

import java.util.List;

/**
 * The {@code Editor} class provides functionality to edit the values in a {@link Table}.
 * <p>
 * This class allows for modifying the value of a specific cell in the table by specifying the row and column indices.
 * The new value is parsed and set using the {@link TypeChecker} associated with the table.
 * </p>
 *
 * <pre>
 * {@code
 * Table table = new Table(new TypeChecker());
 * // Populate table with rows and cells
 * Editor editor = new Editor(table);
 * editor.edit(0, 1, 42);
 * }
 * </pre>
 *
 * @version 1.0
 * @since 2024-06-24
 */
public class Editor {
    private final Table table;

    /**
     * Constructs an {@code Editor} with the specified {@link Table}.
     *
     * @param table the table to be edited
     */
    public Editor(Table table) {
        this.table = table;
    }

    /**
     * Edits the value of a specific cell in the table.
     *
     * @param row      the row index of the cell to be edited
     * @param column   the column index of the cell to be edited
     * @param newValue the new value to be set in the cell
     * @throws Exception if the specified row or column does not exist
     */
    public void edit(int row, int column, Object newValue) throws Exception {
        if (row <= table.getRows().size() - 1) {
            Row row1 = table.getRows().get(row);
            List<Cell<Object>> cells = row1.getCells();
            if (column <= cells.size() - 1) {
                Cell<Object> objectCell = cells.get(column);
                parseValues(newValue, objectCell);
            } else {
                throw new NonexistentException("Column");
            }
        } else {
            throw new NonexistentException("Row");
        }
    }

    /**
     * Parses the new value and sets it in the specified cell.
     * The value is parsed based on its type using the {@link TypeChecker} associated with the table.
     *
     * @param value the new value to be set in the cell
     * @param cell  the cell in which the value is to be set
     */
    private void parseValues(Object value, Cell<Object> cell) {
        if (table.getTypeChecker().checkInteger(value)) {
            cell.setValue(Integer.parseInt(String.valueOf(value)));
        } else if (table.getTypeChecker().checkDouble(value)) {
            cell.setValue(Double.parseDouble(String.valueOf(value)));
        } else {
            cell.setValue(table.getTypeChecker().checkString(value));
        }
    }
}
