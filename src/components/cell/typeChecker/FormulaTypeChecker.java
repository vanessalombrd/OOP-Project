package components.cell.typeChecker;

import components.cell.CellType;

/**
 * The {@code FormulaTypeChecker} class implements the {@code TypeChecker2} interface to handle checking and parsing
 * of objects as formula types.
 * <p>
 * This class provides methods to check if an object represents a formula, to get the corresponding
 * {@link CellType}, and to parse the object as a formula.
 * </p>
 *
 * <pre>
 * {@code
 * FormulaTypeChecker formulaChecker = new FormulaTypeChecker();
 * boolean isFormula = formulaChecker.check("= R1C1 + 5");
 * CellType cellType = formulaChecker.getCellType();
 * Object parsedValue = formulaChecker.parse("= R1C1 + 5");
 * }
 * </pre>
 *
 * @version 1.0
 * @since 2024-06-24
 */
public class FormulaTypeChecker implements TypeChecker2 {

    /**
     * Checks if the given object represents a formula.
     * A formula is identified by starting with an '=' character.
     *
     * @param o the object to be checked
     * @return {@code true} if the object represents a formula, {@code false} otherwise
     */
    @Override
    public boolean check(Object o) {
        if (o instanceof String) {
            String stringValue = (String) o;
            return stringValue.startsWith("=");
        }
        return false;
    }

    /**
     * Returns the {@link CellType} associated with this {@code FormulaTypeChecker}.
     *
     * @return the {@link CellType} associated with this {@code FormulaTypeChecker}
     */
    @Override
    public CellType getCellType() {
        return CellType.FORMULA;
    }

    /**
     * Parses the given object as a formula.
     *
     * @param o the object to be parsed
     * @return the parsed formula as a {@code String}
     */
    @Override
    public Object parse(Object o) {
        return o.toString();
    }
}
