package components.cell;

import components.cell.typeChecker.*;
import components.cell.typeChecker.TypeChecker2;

import java.util.HashMap;
import java.util.Map;

/**
 * The {@code Cell} class represents a cell with a specific type and value.
 * It uses various type checkers to determine the type of the value assigned to the cell.
 * <p>
 * The cell type is determined based on the value provided during the cell creation or when the value is set.
 * The available cell types are managed by a map of {@link CellType} to {@link TypeChecker2}.
 * </p>
 *
 * @param <T> the type of the value stored in the cell
 *
 * <pre>
 * {@code
 * Cell<Integer> intCell = new Cell<>(123);
 * Cell<String> strCell = new Cell<>("Hello, World!");
 * }
 * </pre>
 *
 * @version 1.0
 * @since 2024-06-24
 */
public class Cell<T> {
    private CellType cellType;
    private T value;
    private final Map<CellType, TypeChecker2> cellTypes = new HashMap<>();

    /**
     * Constructs a {@code Cell} with the specified value.
     * The cell type is determined based on the value provided.
     *
     * @param value the value to be stored in the cell
     * @throws IllegalArgumentException if no matching cell type is found for the value
     */
    public Cell(T value) {
        fillCellTypes();
        setType(value);
        this.value = value;
    }

    /**
     * Fills the map of cell types with their respective type checkers.
     */
    private void fillCellTypes() {
        cellTypes.put(CellType.INTEGER, new IntegerTypeChecker());
        cellTypes.put(CellType.DOUBLE, new DoubleTypeChecker());
        cellTypes.put(CellType.NULL, new NullTypeChecker());
        cellTypes.put(CellType.FORMULA, new FormulaTypeChecker());
        cellTypes.put(CellType.STRING, new StringTypeChecker());
    }

    /**
     * Sets the cell type based on the provided value using the available type checkers.
     *
     * @param value the value whose type needs to be determined
     * @throws IllegalArgumentException if no matching cell type is found for the value
     */
    private void setType(T value) {
        for (TypeChecker2 checker : cellTypes.values()) {
            if (checker.check(value)) {
                cellType = checker.getCellType();
                return;
            }
        }
        throw new IllegalArgumentException("No data type matched");
    }

    /**
     * Returns the cell type of the current cell.
     *
     * @return the cell type of the current cell
     */
    public CellType getCellType() {
        return cellType;
    }

    /**
     * Returns the value stored in the current cell.
     *
     * @return the value stored in the current cell
     */
    public T getValue() {
        return value;
    }

    /**
     * Sets a new value for the cell and updates the cell type accordingly.
     *
     * @param value the new value to be stored in the cell
     * @throws IllegalArgumentException if no matching cell type is found for the value
     */
    public void setValue(T value) {
        setType(value);
        this.value = value;
    }

    /**
     * Returns the map of cell types and their respective type checkers.
     *
     * @return the map of cell types and their respective type checkers
     */
    public Map<CellType, TypeChecker2> getCellTypes() {
        return cellTypes;
    }
}
