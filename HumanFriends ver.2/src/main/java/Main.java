
import model.interfaces.Loadable;
import model.petsRegistry.Counter;
import model.saving.LoadObjectsFromDB;
import model.service.Service;
import presenter.Presenter;
import view.ConsoleUI;
import view.interfaces.View;

public class Main {
    public static void main(String[] args) {

        Loadable load = new LoadObjectsFromDB();
        try (Counter counter = new Counter()) {
            View view = new ConsoleUI();
            Service service = new Service(counter, load);
            Presenter presenter = new Presenter(view, service);
            view.start();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}