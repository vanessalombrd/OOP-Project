package messages;

/**
 * The {@code Messages} class provides a set of static methods for generating standardized messages.
 * These messages are used for indicating errors and successes in various operations, such as file operations.
 *
 * <pre>
 * {@code
 * String errorMessage = Messages.ERROR("opening");
 * String successMessage = Messages.FILE_SUCCESS("opened", "data.csv");
 * }
 * </pre>
 *
 * @version 1.0
 * @since 2024-06-24
 */
public class Messages {

    /**
     * Returns an error message indicating an unexpected error occurred while performing a specific command.
     *
     * @param particularCommand_ING the name of the specific command, written in present participle form (-ing)
     * @return the complete error message
     */
    public static String ERROR(String particularCommand_ING) {
        return "Unexpected error occurred when " + particularCommand_ING + " the file";
    }

    /**
     * Returns a generic error message indicating an unexpected error occurred.
     *
     * @return the generic error message
     */
    public static String ERROR() {
        return "Unexpected error occurred";
    }

    /**
     * Returns a success message indicating a specific command was successfully performed on a file.
     *
     * @param particularCommand_ED the name of the specific command, written in past tense (-ed)
     * @param fileName             the name of the file on which the command was executed
     * @return the complete success message
     */
    public static String FILE_SUCCESS(String particularCommand_ED, String fileName) {
        return "Successfully " + particularCommand_ED + " " + fileName;
    }

    /**
     * Returns a message indicating that one or more provided values are not valid integers.
     *
     * @return the message indicating invalid integer values
     */
    public static String NOT_INTEGER() {
        return "One or more of the provided values not a valid integer";
    }

    /**
     * Returns a message indicating insufficient data was provided.
     *
     * @return the message indicating insufficient data
     */
    public static String OUT_OF_BOUNDS() {
        return "Insufficient data provided";
    }

    /**
     * Returns a message indicating insufficient data was provided at a specific position.
     *
     * @param position the position at which insufficient data was provided
     * @return the message indicating insufficient data at the specified position
     */
    public static String OUT_OF_BOUNDS(String position) {
        return "Insufficient data provided at " + position + ". position";
    }

    /**
     * Returns a message indicating that a file did not exist but was created successfully.
     *
     * @param fileName the name of the file that was created
     * @return the message indicating successful file creation
     */
    public static String CREATE_FILE_SUCCESS(String fileName) {
        return "File " + fileName + " didn't exist but was created successfully";
    }

    /**
     * Returns a message indicating that a file does not exist and cannot be created.
     *
     * @param fileName the name of the file that could not be created
     * @return the message indicating failed file creation
     */
    public static String CREATE_FILE_FAIL(String fileName) {
        return "File " + fileName + " doesn't exist and can't be created";
    }
}
