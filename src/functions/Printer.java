package functions;

import components.cell.Cell;
import components.row.Row;
import components.table.Table;

import java.util.List;

public class Printer {
    private Table table;

    public Printer(Table table) {
        this.table = table;
    }

    public void print() {
        fillCells();

        for (Row row : table.getRows()) {
            List<Cell<Object>> cells = row.getCells();
            for (Cell<Object> cell : cells) {
                System.out.printf("%20s|", cell.getValue());
            }
            System.out.println();
        }
    }

    private void fillCells() {
        int maxSize = 0;
        for (Row row : table.getRows()) {
            int size = row.getCells().size();
            if (size > maxSize) {
                maxSize = size;
            }
        }
        for (int i = 0; i < table.getRows().size(); i++) {
            while (true) {
                if (table.getRows().get(i).getCells().size() == maxSize) {
                    break;
                }
                table.getRows().get(i).addCell(new Cell<>(""));
            }
        }
    }
}
