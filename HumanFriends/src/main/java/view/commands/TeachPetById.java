package view.commands;

import view.interfaces.Command;
import view.interfaces.View;

public class TeachPetById implements Command {
    private View view;

    public TeachPetById(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Teach Pet by id";
    }

    @Override
    public void execute() {
        view.teachPetById();
    }
}
