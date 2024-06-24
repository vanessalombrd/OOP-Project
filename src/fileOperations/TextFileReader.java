package fileOperations;

import checker.TypeChecker;
import components.table.Table;
import components.cell.Cell;
import components.row.Row;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The {@code TextFileReader} class implements the {@code Reader} interface for reading text files and populating a {@link Table}.
 * <p>
 * This class uses a {@link TypeChecker} to determine the types of data read from the file and constructs {@link Cell} objects accordingly.
 * The data is expected to be in a comma-separated format.
 * </p>
 *
 * <pre>
 * {@code
 * TypeChecker typeChecker = new TypeChecker();
 * TextFileReader textFileReader = new TextFileReader(typeChecker);
 * Table table = new Table(typeChecker);
 * textFileReader.read("data.csv", table);
 * }
 * </pre>
 *
 * @version 1.0
 * @since 2024-06-24
 */
public class TextFileReader implements Reader {
    private final TypeChecker typeChecker0;

    /**
     * Constructs a {@code TextFileReader} with the specified {@link TypeChecker}.
     *
     * @param typeChecker0 the type checker to be used by the reader
     */
    public TextFileReader(TypeChecker typeChecker0) {
        this.typeChecker0 = typeChecker0;
    }

    /**
     * Reads the specified file and populates the provided {@link Table}.
     * The file is expected to contain data in a comma-separated format.
     *
     * @param file  the path to the file to be read
     * @param table the table to be populated with the data from the file
     */
    @Override
    public void read(String file, Table table) {
        try (FileReader fileReader = new FileReader(file)) {
            Scanner scanner = new Scanner(fileReader);
            table.setFilePath(file);
            while (scanner.hasNext()) {
                Row row = new Row();
                String line = scanner.nextLine();
                Object[] split = line.split(",");
                for (int i = 0; i < split.length; i++) {
                    String oString = (String) split[i];
                    if (!oString.startsWith("=")) {
                        oString = oString.replaceAll("\\s+", "");
                        split[i] = oString;
                    }
                }
                List<Cell<Object>> cells = getCells(split, table.getRows().size() + 1);
                fillEmptyCells(split, line, cells);
                addEmptyCellAtEnd(line, cells);
                row.setCells(cells);
                table.addRow(row);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Adds an empty cell at the end of the row if the line ends with a comma.
     *
     * @param line  the line read from the file
     * @param cells the list of cells in the current row
     */
    private static void addEmptyCellAtEnd(String line, List<Cell<Object>> cells) {
        if (line.endsWith(",")) {
            cells.add(new Cell<>(""));
        }
    }

    /**
     * Fills empty cells in the row based on the number of commas in the line.
     *
     * @param split the array of split elements from the line
     * @param line  the line read from the file
     * @param cells the list of cells in the current row
     */
    private static void fillEmptyCells(Object[] split, String line, List<Cell<Object>> cells) {
        if (split.length == 0) {
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == ',') {
                    cells.add(new Cell<>(" "));
                }
            }
        }
    }

    /**
     * Creates a list of cells from the split elements of the line.
     * Uses the {@link TypeChecker} to determine the type of each element.
     *
     * @param split the array of split elements from the line
     * @param row   the current row number (for error messages)
     * @return the list of cells created from the split elements
     */
    private List<Cell<Object>> getCells(Object[] split, int row) {
        List<Cell<Object>> cells = new ArrayList<>();
        int column = 1;
        for (Object s : split) {
            if (typeChecker0.checkInteger(s)) {
                cells.add(new Cell<>(Integer.parseInt(String.valueOf(s))));
            } else if (typeChecker0.checkDouble(s)) {
                cells.add(new Cell<>(Double.parseDouble(String.valueOf(s))));
            } else if (String.valueOf(s).startsWith("\"") && String.valueOf(s).endsWith("\"") || String.valueOf(s).isEmpty()) {
                cells.add(new Cell<>(typeChecker0.checkString(s)));
            } else if (String.valueOf(s).startsWith("=")) {
                cells.add(new Cell<>(s));
            } else {
                System.out.printf("Error: row %d, col %d, %s is unknown data type%n", row, column, s);
            }
            column++;
        }
        return cells;
    }
}
