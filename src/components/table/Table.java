package components.table;

import checker.TypeChecker;
import components.row.Row;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private List<Row> rows;
    private final TypeChecker typeChecker;
    private String filePath;

    public Table(TypeChecker typeChecker) {
        this.typeChecker = typeChecker;
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
        return typeChecker;
    }

    public void addRow(Row row) {
        rows.add(row);
    }

//    public void edit(int row, int column, Object newValue) { //GOTOVO
//        if (row <= rows.size() - 1) {
//            components.row.Row row1 = rows.get(row);
//            List<table.cell.Cell<Object>> cells = row1.getCells();
//            if (column <= cells.size() - 1) {
//                table.cell.Cell<Object> objectCell = cells.get(column);
//                parseValues(newValue, objectCell);
//            } else {
//                System.out.println("Nqma takuv column, HAHA LOSER");
//            }
//        } else {
//            System.out.println("Nqma takava row, HAHA LOSER");
//        }
//    }

//    public void parseValues(Object value, table.cell.Cell<Object> cell) {
//        if (typeChecker.checkInteger(value)) {
//            cell.setValue(Integer.parseInt(String.valueOf(value)));
//        } else if (typeChecker.checkDouble(value)) {
//            cell.setValue(Double.parseDouble(String.valueOf(value)));
//        } else {
//            cell.setValue(typeChecker.checkString(value));
//        }
//    }

//    public void print() {
//        fillCells();
//
//        for (components.row.Row row : rows) {
//            List<table.cell.Cell<Object>> cells = row.getCells();
//            for (table.cell.Cell<Object> cell : cells) {
//                System.out.printf("%20s|", cell.getValue());
//            }
//            System.out.println();
//        }
//    }
//
//    private void fillCells() {
//        int maxSize = 0;
//        for (components.row.Row row : rows) {
//            int size = row.getCells().size();
//            if (size > maxSize) {
//                maxSize = size;
//            }
//        }
//        for (int i = 0; i < rows.size(); i++) {
//            while (true) {
//                if (rows.get(i).getCells().size() == maxSize) {
//                    break;
//                }
//                rows.get(i).addCell(new table.cell.Cell<>(""));
//            }
//        }
//    }
}
