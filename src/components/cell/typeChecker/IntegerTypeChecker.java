package components.cell.typeChecker;

import components.cell.CellType;

public class IntegerTypeChecker implements TypeChecker {
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
    public void parse(Object o) {
//        try {
            Integer.parseInt(String.valueOf(o));
//        } catch (Exception ignored) {}
    }
}
