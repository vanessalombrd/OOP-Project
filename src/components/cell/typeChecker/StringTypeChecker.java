package components.cell.typeChecker;

import components.cell.CellType;

public class StringTypeChecker implements TypeChecker {
    @Override
    public boolean check(Object o) {
        return o instanceof String;
    }

    @Override
    public CellType getCellType() {
        return CellType.STRING;
    }

    @Override
    public void parse(Object o) {

    }
}
