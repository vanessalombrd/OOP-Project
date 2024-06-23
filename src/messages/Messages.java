package messages;

public class Messages {
    /**
     * Съобшение, което преизползва част от текста,
     * който се съдържа при възникване на
     * непредвидена грешка
     *
     * @param particularCommand_ING име на конкретната команда, написана в сегашно време (-ing)
     * @return цялото съобщение
     */
    public static String ERROR(String particularCommand_ING) {
        return "Unexpected error occurred when " + particularCommand_ING + " the file";
    }

    /**
     * Съобщение, което преизползва част от текста,
     * който се съдържа при успех на командите
     * open, close, edit, save и saveas
     *
     * @param particularCommand_ED име на конкретната команда, написана в минало време (-ed)
     * @param fileName             име на файла, за който се изпълнява командата
     * @return цялото съобщение
     */
    public static String FILE_SUCCESS(String particularCommand_ED, String fileName) {
        return "Successfully " + particularCommand_ED + " file " + fileName;
    }

    public static String NOT_INTEGER() {
        return "One or more of the provided values not a valid integer";
    }

    public static String OUT_OF_BOUNDS() {
        return "Insufficient data provided";
    }

    public static String OUT_OF_BOUNDS(String position) {
        return "Insufficient data provided at " + position + ". position";
    }







    public static String CREATE_FILE_SUCCESS(String fileName) {
        return "File " + fileName + " didn't exist but was created successfully";
    }

    public static String CREATE_FILE_FAIL(String fileName) {
        return "File " + fileName + " doesn't exist and can't be created";
    }
}
