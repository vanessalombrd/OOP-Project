package components.cell.typeChecker;

import components.cell.CellType;

/**
 * The {@code DoubleTypeChecker} class implements the {@code TypeChecker2} interface to handle checking and parsing
 * of objects as {@code Double} types.
 * <p>
 * This class provides methods to check if an object can be parsed as a {@code Double}, to get the corresponding
 * {@link CellType}, and to parse the object into a {@code Double}.
 * </p>
 *
 * <pre>
 * {@code
 * DoubleTypeChecker doubleChecker = new DoubleTypeChecker();
 * boolean isDouble = doubleChecker.check("123.45");
 * CellType cellType = doubleChecker.getCellType();
 * Object parsedValue = doubleChecker.parse("123.45");
 * }
 * </pre>
 *
 * @version 1.0
 * @since 2024-06-24
 */
public class DoubleTypeChecker implements TypeChecker2 {

    /**
     * Checks if the given object can be parsed as a {@code Double}.
     *
     * @param o the object to be checked
     * @return {@code true} if the object can be parsed as a {@code Double}, {@code false} otherwise
     */
    @Override
    public boolean check(Object o) {
        try {
            Double.parseDouble(String.valueOf(o));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Returns the {@link CellType} associated with this {@code DoubleTypeChecker}.
     *
     * @return the {@link CellType} associated with this {@code DoubleTypeChecker}
     */
    @Override
    public CellType getCellType() {
        return CellType.DOUBLE;
    }

    /**
     * Parses the given object to a {@code Double}.
     *
     * @param o the object to be parsed
     * @return the parsed {@code Double} value
     * @throws NumberFormatException if the object cannot be parsed as a {@code Double}
     */
    @Override
    public Object parse(Object o) {
        return Double.parseDouble(String.valueOf(o));
    }
}
