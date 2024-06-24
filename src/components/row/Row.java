package components.row;

import components.cell.Cell;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@code Row} class represents a row in a table, consisting of a list of {@link Cell} objects.
 * <p>
 * This class provides methods to add cells to the row and to get or set the list of cells.
 * </p>
 *
 * <pre>
 * {@code
 * Row row = new Row();
 * row.addCell(new Cell<>(123));
 * row.addCell(new Cell<>("Hello"));
 * List<Cell<Object>> cells = row.getCells();
 * }
 * </pre>
 *
 * @version 1.0
 * @since 2024-06-24
 */
public class Row {
    private List<Cell<Object>> cells;

    /**
     * Constructs an empty {@code Row}.
     */
    public Row() {
        this.cells = new ArrayList<>();
    }

    /**
     * Adds a cell to the end of the row.
     *
     * @param cell the cell to be added to the row
     */
    public void addCell(Cell<Object> cell) {
        cells.add(cell);
    }

    /**
     * Returns the list of cells in the row.
     *
     * @return the list of cells in the row
     */
    public List<Cell<Object>> getCells() {
        return cells;
    }

    /**
     * Sets the list of cells in the row.
     *
     * @param cells the list of cells to be set in the row
     */
    public void setCells(List<Cell<Object>> cells) {
        this.cells = cells;
    }
}
