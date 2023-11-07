package view.commands;

import view.interfaces.Command;
import view.interfaces.View;

public class GetPetsList implements Command {
    private View view;

    public GetPetsList(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Print Pet`s list";
    }

    @Override
    public void execute() {
        view.getPetsList();
    }
}
