
import model.petsRegistry.Counter;
import model.service.Service;
import presenter.Presenter;
import view.ConsoleUI;
import view.interfaces.View;

public class Main {
    public static void main(String[] args) {

        try (Counter counter = new Counter()) {
            View view = new ConsoleUI();
            Service service = new Service(counter);
            Presenter presenter = new Presenter(view, service);
            view.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}