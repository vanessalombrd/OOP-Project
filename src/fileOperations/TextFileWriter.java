package fileOperations;

import components.cell.Cell;
import components.row.Row;
import components.table.Table;

import java.io.FileWriter;
import java.io.IOException;

/**
 * The {@code TextFileWriter} class implements the {@code Writer} interface for writing the contents of a {@link Table} to a text file.
 * <p>
 * This class writes the table data in a comma-separated format, with each row on a new line.
 * </p>
 *
 * <pre>
 * {@code
 * Table table = new Table(new TypeChecker());
 * // Populate table with rows and cells
 * TextFileWriter textFileWriter = new TextFileWriter();
 * textFileWriter.write("output.csv", table);
 * }
 * </pre>
 *
 * @version 1.0
 * @since 2024-06-24
 */
public class TextFileWriter implements Writer {

    /**
     * Writes the contents of the specified {@link Table} to a file.
     * The table data is written in a comma-separated format, with each row on a new line.
     *
     * @param file  the path to the file to be written
     * @param table the table whose data is to be written to the file
     * @throws RuntimeException if an I/O error occurs
     */
    @Override
    public void write(String file, Table table) {
        try (FileWriter fileWriter = new FileWriter(file)) {
            for (Row row : table.getRows()) {
                for (Cell<Object> cell : row.getCells()) {
                    fileWriter.write(String.valueOf(cell.getValue()));
                    fileWriter.write(", ");
                }
                fileWriter.write(System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
