package view.commands;

import view.interfaces.Command;
import view.interfaces.View;

public class AddNewPet implements Command {
    private View view;

    public AddNewPet(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Add new Pet";
    }

    @Override
    public void execute() {
        view.addNewPet();
    }
}
