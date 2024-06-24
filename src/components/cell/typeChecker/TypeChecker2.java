package components.cell.typeChecker;

import components.cell.CellType;

/**
 * The {@code TypeChecker2} interface provides methods for checking the type of an object,
 * retrieving the cell type, and parsing the object.
 * <p>
 * Implementations of this interface are expected to define how to check the type of an object,
 * determine the {@link CellType}, and parse the object accordingly.
 * </p>
 *
 * <pre>
 * {@code
 * public class IntegerTypeChecker implements TypeChecker2 {
 *
 *     @Override
 *     public boolean check(Object o) {
 *         try {
 *             Integer.parseInt(String.valueOf(o));
 *             return true;
 *         } catch (Exception e) {
 *             return false;
 *         }
 *     }
 *
 *     @Override
 *     public CellType getCellType() {
 *         return CellType.INTEGER;
 *     }
 *
 *     @Override
 *     public Object parse(Object o) {
 *         try {
 *             return Integer.parseInt(String.valueOf(o));
 *         } catch (Exception e) {
 *             return null;
 *         }
 *     }
 * }
 * }
 * </pre>
 *
 * @version 1.0
 * @since 2024-06-24
 */
public interface TypeChecker2 {

    /**
     * Checks if the given object meets the criteria defined by the implementation.
     *
     * @param o the object to be checked
     * @return {@code true} if the object meets the criteria, {@code false} otherwise
     */
    boolean check(Object o);

    /**
     * Returns the {@link CellType} associated with this {@code TypeChecker2}.
     *
     * @return the {@link CellType} associated with this {@code TypeChecker2}
     */
    CellType getCellType();

    /**
     * Parses the given object to the desired type defined by the implementation.
     *
     * @param o the object to be parsed
     * @return the parsed object, or {@code null} if parsing fails
     */
    Object parse(Object o);
}
