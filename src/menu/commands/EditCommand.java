package menu.commands;

import functions.Editor;
import menu.Command;

public class EditCommand implements Command {
    private final Editor editor;

    public EditCommand(Editor editor) {
        this.editor = editor;
    }

    @Override
    public void execute(String[] data) {
        editor.edit(Integer.parseInt(data[1]), Integer.parseInt(data[2]),Integer.parseInt(data[3]));
    }
}
