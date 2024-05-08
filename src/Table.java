import java.util.ArrayList;
import java.util.List;

public class Table implements TableFunctions {
    private List<Row> rows;
    private final Parser parser;

    public Table(Parser parser) {
        this.parser = parser;
        this.rows = new ArrayList<>();
    }

    public List<Row> getRows() {
        return rows;
    }

    public void setRows(List<Row> rows) {
        this.rows = rows;
    }

    void addRow(Row row) {
        rows.add(row);
    }

    @Override
    public void edit(int row, int column, Object value) { //GOTOVO
        if (row <= rows.size() - 1) {
            Row row1 = rows.get(row);
            List<Cell<Object>> cells = row1.getCells();
            if (column <= cells.size() - 1) {
                Cell<Object> objectCell = cells.get(column);
                parseValues(value, objectCell);
            } else {
                System.out.println("Nqma takuv column, HAHA LOSER");
            }
        } else {
            System.out.println("Nqma takava row, HAHA LOSER");
        }
    }

    private void parseValues(Object value, Cell<Object> objectCell) {
        if (parser.checkInteger(value)) {
            objectCell.setValue(Integer.parseInt(String.valueOf(value)));
        } else if (parser.checkDouble(value)) {
            objectCell.setValue(Double.parseDouble(String.valueOf(value)));
        } else {
            objectCell.setValue(parser.checkString(value));
        }
    }

    @Override
    public void print() {
        fillCells();

        for (Row row : rows) {
            List<Cell<Object>> cells = row.getCells();
            for (Cell<Object> cell : cells) {
                System.out.printf("%20s|",cell.getValue());
            }
            System.out.println();
        }
    }

    private void fillCells() {
        int maxSize=0;
        for (Row row : rows) {
            int size = row.getCells().size();
            if(size>maxSize){
                maxSize=size;
            }
        }
        for (int i = 0; i <rows.size() ; i++) {
           while (true){
               if(rows.get(i).getCells().size()==maxSize){
                   break;
               }
               rows.get(i).addCell(new Cell<>(""));
           }
        }
    }
}
