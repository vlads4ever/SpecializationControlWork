package view.commands;

import view.interfaces.Command;
import view.interfaces.View;

public class GetPetInfo implements Command {
    private View view;

    public GetPetInfo(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Get info about Pet";
    }

    @Override
    public void execute() {
        view.getPetInfo();
    }
}
