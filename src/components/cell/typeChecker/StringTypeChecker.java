package components.cell.typeChecker;

import components.cell.CellType;

/**
 * The {@code StringTypeChecker} class implements the {@code TypeChecker2} interface to handle checking and parsing
 * of objects as {@code String} types.
 * <p>
 * This class provides methods to check if an object is a {@code String}, to get the corresponding
 * {@link CellType}, and to parse the object into a {@code String}.
 * </p>
 *
 * <pre>
 * {@code
 * StringTypeChecker stringChecker = new StringTypeChecker();
 * boolean isString = stringChecker.check("example");
 * CellType cellType = stringChecker.getCellType();
 * Object parsedValue = stringChecker.parse("example");
 * }
 * </pre>
 *
 * @version 1.0
 * @since 2024-06-24
 */
public class StringTypeChecker implements TypeChecker2 {

    /**
     * Checks if the given object is a {@code String}.
     *
     * @param o the object to be checked
     * @return {@code true} if the object is a {@code String}, {@code false} otherwise
     */
    @Override
    public boolean check(Object o) {
        return o instanceof String;
    }

    /**
     * Returns the {@link CellType} associated with this {@code StringTypeChecker}.
     *
     * @return the {@link CellType} associated with this {@code StringTypeChecker}
     */
    @Override
    public CellType getCellType() {
        return CellType.STRING;
    }

    /**
     * Parses the given object to a {@code String}.
     *
     * @param o the object to be parsed
     * @return the parsed {@code String} value
     */
    @Override
    public Object parse(Object o) {
        return o.toString();
    }
}
