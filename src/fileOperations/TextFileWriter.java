package fileOperations;

import components.cell.Cell;
import components.row.Row;
import components.table.Table;

import java.io.FileWriter;
import java.io.IOException;

public class TextFileWriter implements Writer{
    @Override
    public void write(String file, Table table) {
        try (FileWriter fileWriter = new FileWriter(file)) {
            for (Row row : table.getRows()) {
                for (Cell<Object> cell : row.getCells()) {
                    fileWriter.write(String.valueOf(cell.getValue()));
                    fileWriter.write(", ");
                }
                fileWriter.write(System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
