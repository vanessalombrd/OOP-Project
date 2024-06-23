package components.cell;

import components.cell.typeChecker.*;
import components.cell.typeChecker.TypeChecker2;

import java.util.HashMap;
import java.util.Map;

public class Cell<T> {
    private CellType cellType;
    private T value;
    private final Map<CellType, TypeChecker2> cellTypes = new HashMap<>();

    public Cell(T value) {
        fillCellTypes();

        setType(value);
        this.value = value;
    }

    private void fillCellTypes() {
        cellTypes.put(CellType.INTEGER, new IntegerTypeChecker());
        cellTypes.put(CellType.DOUBLE, new DoubleTypeChecker());
        cellTypes.put(CellType.NULL, new NullTypeChecker());
        cellTypes.put(CellType.FORMULA, new FormulaTypeChecker());
        cellTypes.put(CellType.STRING, new StringTypeChecker());
    }

    private void setType(T value) {
        for (TypeChecker2 checker : cellTypes.values()) {
            if (checker.check(value)) {
                cellType = checker.getCellType();
                return;
            }
        }
        throw new IllegalArgumentException("No data type matched");
    }

    public CellType getCellType() {
        return cellType;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        setType(value);
        this.value = value;
    }

    public Map<CellType, TypeChecker2> getCellTypes() {
        return cellTypes;
    }
}
