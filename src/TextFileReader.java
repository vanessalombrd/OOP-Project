import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextFileReader implements Reader {
    private final Parser parser;

    public TextFileReader(Parser parser) {
        this.parser = parser;
    }

    @Override
    public void read(String file, Table table) {
        try (FileReader fileReader = new FileReader(file)) {
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNext()) {
                Row row = new Row();
                String line = scanner.nextLine();
                line = line.replaceAll("\\s+", "");
                Object[] split = line.split(",");
                // row.setCells(collect);
                List<Cell<Object>> cells = getCells(split,table.getRows().size()+1);
                fillEmptyCells(split, line, cells);
                addEmptyCellAtEnd(line, cells);
                row.setCells(cells);
                table.addRow(row);
                // System.out.println();

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void addEmptyCellAtEnd(String line, List<Cell<Object>> cells) {
        if (line.endsWith(",")) {
            cells.add(new Cell<>(""));
        }
    }

    private static void fillEmptyCells(Object[] split, String line, List<Cell<Object>> cells) {
        if (split.length == 0) {
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == ',') {
                    cells.add(new Cell<>(" "));
                }
            }
        }
    }

    private List<Cell<Object>> getCells(Object[] split,int row) {
        List<Cell<Object>> cells = new ArrayList<>();
        int count=1;
        for (Object s : split) {
            if (parser.checkInteger(s)) {
                cells.add(new Cell<>(Integer.parseInt(String.valueOf(s))));
            } else if (parser.checkDouble(s)) {
                cells.add(new Cell<>(Double.parseDouble(String.valueOf(s))));
            } else if(String.valueOf(s).startsWith("\"") && String.valueOf(s).endsWith("\"") || String.valueOf(s).isEmpty()) {
                cells.add(new Cell<>(parser.checkString(s)));
            }else{
                System.out.printf("Error: row %d, col %d, %s is unknown data type%n",row,count,s);
            }
            count++;
        }
        return cells;
    }
}
