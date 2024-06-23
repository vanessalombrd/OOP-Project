package menu;

import exceptions.ClosedFileException;

import java.io.IOException;

public interface Command {
    // String data sa komandite
    void execute(String[] data) throws ClosedFileException;
}
