package view.commands;

import view.interfaces.Command;
import view.interfaces.View;

public class LoadPetsFromDB implements Command {
    private View view;

    public LoadPetsFromDB(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Load pets from DB";
    }

    @Override
    public void execute() {
        view.load();
    }
}
