package components.cell.typeChecker;

import components.cell.CellType;

/**
 * The {@code NullTypeChecker} class implements the {@code TypeChecker2} interface to handle checking and parsing
 * of objects as {@code NULL} types.
 * <p>
 * This class provides methods to check if an object is {@code null} or an empty string, to get the corresponding
 * {@link CellType}, and to parse the object as {@code null}.
 * </p>
 *
 * <pre>
 * {@code
 * NullTypeChecker nullChecker = new NullTypeChecker();
 * boolean isNull = nullChecker.check(null);
 * CellType cellType = nullChecker.getCellType();
 * Object parsedValue = nullChecker.parse(null);
 * }
 * </pre>
 *
 * @version 1.0
 * @since 2024-06-24
 */
public class NullTypeChecker implements TypeChecker2 {

    /**
     * Checks if the given object is {@code null} or an empty string.
     *
     * @param o the object to be checked
     * @return {@code true} if the object is {@code null} or an empty string, {@code false} otherwise
     */
    @Override
    public boolean check(Object o) {
        return o == null || o.equals("");
    }

    /**
     * Returns the {@link CellType} associated with this {@code NullTypeChecker}.
     *
     * @return the {@link CellType} associated with this {@code NullTypeChecker}
     */
    @Override
    public CellType getCellType() {
        return CellType.NULL;
    }

    /**
     * Parses the given object as {@code null}.
     *
     * @param o the object to be parsed
     * @return {@code null}
     */
    @Override
    public Object parse(Object o) {
        return null;
    }
}
