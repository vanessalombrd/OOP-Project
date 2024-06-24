package components.cell.typeChecker;

import components.cell.CellType;

/**
 * The {@code IntegerTypeChecker} class implements the {@code TypeChecker2} interface to handle checking and parsing
 * of objects as {@code Integer} types.
 * <p>
 * This class provides methods to check if an object can be parsed as an {@code Integer}, to get the corresponding
 * {@link CellType}, and to parse the object into an {@code Integer}.
 * </p>
 *
 * <pre>
 * {@code
 * IntegerTypeChecker integerChecker = new IntegerTypeChecker();
 * boolean isInteger = integerChecker.check("123");
 * CellType cellType = integerChecker.getCellType();
 * Object parsedValue = integerChecker.parse("123");
 * }
 * </pre>
 *
 * @version 1.0
 * @since 2024-06-24
 */
public class IntegerTypeChecker implements TypeChecker2 {

    /**
     * Checks if the given object can be parsed as an {@code Integer}.
     *
     * @param o the object to be checked
     * @return {@code true} if the object can be parsed as an {@code Integer}, {@code false} otherwise
     */
    @Override
    public boolean check(Object o) {
        try {
            Integer.parseInt(String.valueOf(o));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Returns the {@link CellType} associated with this {@code IntegerTypeChecker}.
     *
     * @return the {@link CellType} associated with this {@code IntegerTypeChecker}
     */
    @Override
    public CellType getCellType() {
        return CellType.INTEGER;
    }

    /**
     * Parses the given object to an {@code Integer}.
     *
     * @param o the object to be parsed
     * @return the parsed {@code Integer} value
     * @throws NumberFormatException if the object cannot be parsed as an {@code Integer}
     */
    @Override
    public Object parse(Object o) {
        return Integer.parseInt(String.valueOf(o));
    }
}
