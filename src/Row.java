import java.util.ArrayList;
import java.util.List;

public class Row {
    private List<Cell<Object>> cells;

    public Row() {
        this.cells = new ArrayList<>();
    }

    void addCell(Cell<Object> cell) {
        cells.add(cell);
    }

    public List<Cell<Object>> getCells() {
        return cells;
    }

    public void setCells(List<Cell<Object>> cells) {
        this.cells = cells;
    }
}
