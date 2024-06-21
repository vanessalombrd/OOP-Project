package components.cell;

import checker.TypeChecker;

public class Cell <T> {
    private CellType cellType;
    private T value;
    private final TypeChecker typeChecker;

    public Cell(T value) {
        this.typeChecker = new TypeChecker();
        setType(value);
        this.value = value;
    }

    private void setType(T value) {
        if (typeChecker.checkInteger(value)) cellType = CellType.INTEGER;
        else if (typeChecker.checkDouble(value)) cellType = CellType.DOUBLE;
        else if (value == null || value == "") cellType = CellType.NULL;
        else if (value instanceof String) {
            String stringValue = (String) value;
            if (stringValue.startsWith("=")) {
                cellType = CellType.FORMULA;
            } else {
                cellType = CellType.STRING;
            }
        } else {
            throw new IllegalArgumentException("IllegalArgumentException");
        }
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
}
