package components.cell.typeChecker;

import components.cell.CellType;

public interface TypeChecker2 {
    boolean check(Object o);
    CellType getCellType();
    Object parse(Object o);
}
