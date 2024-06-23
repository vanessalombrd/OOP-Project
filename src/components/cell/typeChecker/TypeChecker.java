package components.cell.typeChecker;

import components.cell.CellType;

public interface TypeChecker {
    boolean check(Object o);
    CellType getCellType();
    void parse(Object o);
}
