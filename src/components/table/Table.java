package components.table;

import checker.TypeChecker;
import components.row.Row;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@code Table} class represents a table consisting of a list of {@link Row} objects.
 * It includes a {@link TypeChecker} for checking data types and a file path for potential file operations.
 * <p>
 * This class provides methods to get, set, and manipulate the rows within the table, as well as to manage the file path.
 * </p>
 *
 * <pre>
 * {@code
 * TypeChecker typeChecker = new TypeChecker();
 * Table table = new Table(typeChecker);
 * table.addRow(new Row());
 * List<Row> rows = table.getRows();
 * }
 * </pre>
 *
 * @version 1.0
 * @since 2024-06-24
 */
public class Table {
    private List<Row> rows;
    private final TypeChecker typeChecker0;
    private String filePath;

    /**
     * Constructs a {@code Table} with the specified {@link TypeChecker}.
     * The table is initialized with an empty list of rows and no file path.
     *
     * @param typeChecker0 the type checker to be used by the table
     */
    public Table(TypeChecker typeChecker0) {
        this.typeChecker0 = typeChecker0;
        this.filePath = null;
        this.rows = new ArrayList<>();
    }

    /**
     * Returns the file path associated with this table.
     *
     * @return the file path associated with this table, or {@code null} if no file path is set
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * Sets the file path for this table.
     *
     * @param filePath the file path to be set
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Returns the list of rows in the table.
     *
     * @return the list of rows in the table
     */
    public List<Row> getRows() {
        return rows;
    }

    /**
     * Sets the list of rows in the table.
     *
     * @param rows the list of rows to be set in the table
     */
    public void setRows(List<Row> rows) {
        this.rows = rows;
    }

    /**
     * Returns the {@link TypeChecker} used by this table.
     *
     * @return the type checker used by this table
     */
    public TypeChecker getTypeChecker() {
        return typeChecker0;
    }

    /**
     * Adds a row to the end of the table.
     *
     * @param row the row to be added to the table
     */
    public void addRow(Row row) {
        rows.add(row);
    }
}
