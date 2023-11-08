
import model.interfaces.Loadable;
import model.interfaces.Saveable;
import model.petsRegistry.Counter;
import model.saving.LoadObjectsFromDB;
import model.saving.SaveObjectsToDB;
import model.service.Service;
import presenter.Presenter;
import view.ConsoleUI;
import view.interfaces.View;

public class Main {
    public static void main(String[] args) {
        try (Counter counter = new Counter()) {
            Saveable save = new SaveObjectsToDB();
            Loadable load = new LoadObjectsFromDB();
            View view = new ConsoleUI();
            Service service = new Service(counter, save, load);
            Presenter presenter = new Presenter(view, service);
            view.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}