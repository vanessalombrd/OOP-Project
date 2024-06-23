import exceptions.ClosedFileException;
import menu.MenuInvoker;

public class Application {
    public static void main(String[] args) throws ClosedFileException {
        MenuInvoker menuInvoker = new MenuInvoker();
        menuInvoker.run();
        System.out.println();
    }
}
