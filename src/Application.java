import components.table.Table;
import components.cell.Cell;
import components.row.Row;
import fileOperations.TextFileWriter;
import functions.Editor;
import functions.Formula1;
import functions.Printer;
import menu.MenuInvoker;

public class Application {
    public static void main(String[] args) throws Exception {
//        Cell<Object> cell = new Cell<>(5);
//        Cell<Object> cellString = new Cell<>("Vanessa");
//        Row row = new Row();
//        row.addCell(cell);
//        row.addCell(cellString);
//        System.out.println();
//        fileOperations.Reader reader = new fileOperations.TextFileReader(new checker.TypeChecker());
//        checker.TypeChecker typeChecker = new checker.TypeChecker();
//        Table table = new Table(typeChecker);
//        reader.read("input", table);
//        Editor editor = new Editor(table);
////        editor.edit(6,3,17);
//        Formula1 formula1 = new Formula1(table);
//        formula1.calculator();
//        Printer printer = new Printer(table);
//        printer.print();
        MenuInvoker menuInvoker = new MenuInvoker();
        menuInvoker.run();
//        TextFileWriter writer = new TextFileWriter();
//        writer.write("dancho.txt", table);

        System.out.println();
    }
}
