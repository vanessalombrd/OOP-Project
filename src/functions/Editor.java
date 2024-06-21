package functions;

import components.cell.Cell;
import components.row.Row;
import components.table.Table;

import java.util.List;

public class Editor {
    private Table table;

    public Editor(Table table) {
        this.table = table;
    }

    public void edit(int row, int column, Object newValue) { //GOTOVO
        if (row <= table.getRows().size() - 1) {
            Row row1 = table.getRows().get(row);
            List<Cell<Object>> cells = row1.getCells();
            if (column <= cells.size() - 1) {
                Cell<Object> objectCell = cells.get(column);
                parseValues(newValue, objectCell);
            } else {
                System.out.println("Nqma takuv column, HAHA LOSER");
            }
        } else {
            System.out.println("Nqma takava row, HAHA LOSER");
        }
    }

    private void parseValues(Object value, Cell<Object> cell) {
        if (table.getTypeChecker().checkInteger(value)) {
            cell.setValue(Integer.parseInt(String.valueOf(value)));
        } else if (table.getTypeChecker().checkDouble(value)) {
            cell.setValue(Double.parseDouble(String.valueOf(value)));
        } else {
            cell.setValue(table.getTypeChecker().checkString(value));
        }
    }
}
