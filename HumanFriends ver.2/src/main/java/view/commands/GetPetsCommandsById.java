package view.commands;

import view.interfaces.Command;
import view.interfaces.View;

public class GetPetsCommandsById implements Command {
    private View view;

    public GetPetsCommandsById(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Get Pet`s commands by id";
    }

    @Override
    public void execute() {
        view.getPetsCommandsById();
    }
}
