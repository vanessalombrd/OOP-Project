public class Application {
    public static void main(String[] args) {
        Cell<Object> cell = new Cell<>(5);
        Cell<Object> cellString = new Cell<>("Vanessa");
        Row row = new Row();
        row.addCell(cell);
        row.addCell(cellString);
        System.out.println();
        Reader reader = new TextFileReader(new Parser());
        Parser parser=new Parser();
        Table table = new Table(parser);
        reader.read("input", table);
        table.edit(6,3,17);
        table.print();
        System.out.println();
    }
}
