package components.cell.typeChecker;

import components.cell.CellType;

public class FormulaTypeChecker implements TypeChecker {
    @Override
    public boolean check(Object o) {
        if (o instanceof String) {
            String stringValue = (String) o;
            return stringValue.startsWith("=");
        }
        return false;
    }

    @Override
    public CellType getCellType() {
        return CellType.FORMULA;
    }

    @Override
    public void parse(Object o) {

    }
}
