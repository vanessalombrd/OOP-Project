import components.table.Table;
import components.cell.Cell;
import components.row.Row;
import functions.Editor;
import functions.Formula1;
import functions.Printer;

public class Application {
    public static void main(String[] args) {
        Cell<Object> cell = new Cell<>(5);
        Cell<Object> cellString = new Cell<>("Vanessa");
        Row row = new Row();
        row.addCell(cell);
        row.addCell(cellString);
        System.out.println();
        fileOperations.Reader reader = new fileOperations.TextFileReader(new checker.TypeChecker());
        checker.TypeChecker typeChecker =new checker.TypeChecker();
        Table table = new Table(typeChecker);
        reader.read("input", table);
        Editor editor = new Editor(table);
        editor.edit(6,3,17);
        Formula1 formula1 = new Formula1(table);
        for (Row tableRow : table.getRows()) {
            for (Cell<Object> tableRowCell : tableRow.getCells()) {
                String value = String.valueOf(tableRowCell.getValue());
                if (value.startsWith("=")) {
                    formula1.startCalculations(value);
                    tableRowCell.setValue(formula1.startCalculations(value));
                }


            }
        }

        Printer printer = new Printer(table);
        printer.print();
        System.out.println();
    }
}
