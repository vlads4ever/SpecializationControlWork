package view;

import view.commands.*;
import view.interfaces.Command;
import view.interfaces.View;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private final List<Command> commandList;
    private View view;

    public MainMenu(View view) {
        this.view = view;
        commandList = new ArrayList<>();
        commandList.add(new Exit(view));
        commandList.add(new GetPetsList(view));
        commandList.add(new AddNewPet(view));
        commandList.add(new TeachPetById(view));
        commandList.add(new GetPetInfo(view));
        commandList.add(new GetPetsCommandsById(view));
        commandList.add(new DeletePet(view));
    }

    public String print(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("~~~~~~~~~~~~~~~~~Menu:~~~~~~~~~~~~~~~~~" + "\n");
        for (int i = 0; i < commandList.size(); i++) {
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.append("\n" + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        return stringBuilder.toString();
    }

    public void execute(int numCommand) {
        commandList.get(numCommand - 1).execute();
    }

    public int size(){
        return commandList.size();
    }


}
