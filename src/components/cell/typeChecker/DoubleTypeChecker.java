package components.cell.typeChecker;

import components.cell.CellType;

public class DoubleTypeChecker implements TypeChecker2 {
    @Override
    public boolean check(Object o) {
        try {
            Double.parseDouble(String.valueOf(o));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public CellType getCellType() {
        return CellType.DOUBLE;
    }

    @Override
    public Object parse(Object o) {
        return Double.parseDouble(String.valueOf(o));
    }
}
