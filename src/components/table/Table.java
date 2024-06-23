package components.table;

import checker.TypeChecker;
import components.row.Row;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private List<Row> rows;
    private final TypeChecker typeChecker0;
    private String filePath;

    public Table(TypeChecker typeChecker0) {
        this.typeChecker0 = typeChecker0;
        this.filePath = null;
        this.rows = new ArrayList<>();
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public List<Row> getRows() {
        return rows;
    }

    public void setRows(List<Row> rows) {
        this.rows = rows;
    }

    public TypeChecker getTypeChecker() {
        return typeChecker0;
    }

    public void addRow(Row row) {
        rows.add(row);
    }

}
