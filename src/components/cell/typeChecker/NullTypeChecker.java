package components.cell.typeChecker;

import components.cell.CellType;

public class NullTypeChecker implements TypeChecker2 {
    @Override
    public boolean check(Object o) {
        return o == null || o.equals("");
    }

    @Override
    public CellType getCellType() {
        return CellType.NULL;
    }

    @Override
    public Object parse(Object o) {
        return null;
    }
}
