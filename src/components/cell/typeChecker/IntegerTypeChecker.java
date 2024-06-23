package components.cell.typeChecker;

import components.cell.CellType;

public class IntegerTypeChecker implements TypeChecker2 {
    @Override
    public boolean check(Object o) {
        try {
            Integer.parseInt(String.valueOf(o));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public CellType getCellType() {
        return CellType.INTEGER;
    }

    @Override
    public Object parse(Object o) {
//        try {
            return Integer.parseInt(String.valueOf(o));
//        } catch (Exception ignored) {}
    }
}
