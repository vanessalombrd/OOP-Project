package checker;

import messages.Messages;

/**
 * The {@code TypeChecker} class provides methods to check and manipulate the types of objects.
 * It includes methods to verify if an object can be parsed as a Double or Integer,
 * and a method to process a string representation of an object.
 * <p>
 * The {@code checkDouble} and {@code checkInteger} methods return boolean values indicating
 * whether the object can be parsed to the respective types. The {@code checkString} method
 * processes the string by removing escape characters and quotes.
 * </p>
 *
 * <pre>
 * {@code
 * TypeChecker typeChecker = new TypeChecker();
 * boolean isDouble = typeChecker.checkDouble("123.45");
 * boolean isInteger = typeChecker.checkInteger("123");
 * String processedString = typeChecker.checkString("\"Hello, World!\"");
 * }
 * </pre>
 *
 * @version 1.0
 * @since 2024-06-24
 */
public class TypeChecker {

    /**
     * Checks if the given object can be parsed as a Double.
     *
     * @param o the object to be checked
     * @return {@code true} if the object can be parsed as a Double, {@code false} otherwise
     */
    public boolean checkDouble(Object o) {
        try {
            Double.parseDouble(String.valueOf(o));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Checks if the given object can be parsed as an Integer.
     *
     * @param o the object to be checked
     * @return {@code true} if the object can be parsed as an Integer, {@code false} otherwise
     */
    public boolean checkInteger(Object o) {
        try {
            Integer.parseInt(String.valueOf(o));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Processes the string representation of the given object by removing escape characters and quotes.
     * <p>
     * If the string is empty after processing, it returns the empty string. If any error occurs during processing,
     * it prints an error message using {@link messages.Messages#ERROR()} and returns {@code null}.
     * </p>
     *
     * @param o the object to be processed
     * @return the processed string, or {@code null} if an error occurs
     */
    public String checkString(Object o) {
        try {
            String s = String.valueOf(o);
            s = s.replaceAll("\\\"", "\"");
            s = s.replaceAll("\\\\", "");
            if (s.isEmpty()) {
                return s;
            }
            s = s.substring(1, s.length() - 1);
            return s;
        } catch (Exception e) {
            System.out.println(Messages.ERROR());
            return null;
        }
    }
}
