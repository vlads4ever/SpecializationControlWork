package view.commands;

import view.interfaces.Command;
import view.interfaces.View;

public class SavePetsToDB implements Command {
    private View view;

    public SavePetsToDB(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Save pets to DB";
    }

    @Override
    public void execute() {
        view.save();
    }
}
