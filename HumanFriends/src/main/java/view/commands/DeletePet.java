package view.commands;

import view.interfaces.Command;
import view.interfaces.View;

public class DeletePet implements Command {
    private View view;

    public DeletePet(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Delete Pet by id";
    }

    @Override
    public void execute() {
        view.deletePet();
    }
}
