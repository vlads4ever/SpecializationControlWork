package view;

import presenter.Presenter;
import view.interfaces.View;

import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements View {
    private Presenter presenter;
    private final MainMenu mainMenu;
    private final Scanner scanner;
    private boolean run;

    public ConsoleUI() {
        this.scanner = new Scanner(System.in);
        this.run = true;
        this.mainMenu = new MainMenu(this);
    }

    private void welcome() {
        print("Welcome to Pets Farm!");
        print("************************************");
        print("");
    }

    @Override
    public void start(){
        welcome();
        while (run) {
            printMenu();
            execute();
        }
    }

    private void execute() {
        System.out.print("Input command number> ");
        String userInput = scanner.nextLine();
        if (checkTextForInt(userInput)) {
            int numCommand = Integer.parseInt(userInput);
            if (checkCommand(numCommand)){
                mainMenu.execute(numCommand);
            }
        }
    }

    private boolean checkTextForInt(String text){
        if (text.matches("[0-9]+")) {
            return true;
        } else {
            print("An incorrect value was entered!" + "\n");
            return false;
        }
    }

    private boolean checkCommand(int numCommand){
        if (numCommand <= mainMenu.size() && numCommand > 0) {
            return true;
        } else {
            print("There is no such command!" + "\n");
            return false;
        }
    }

    @Override
    public void printMenu() {
        this.print(mainMenu.print());
    }

    @Override
    public void exit() {
        run = false;
        System.out.println("Shutting down...");
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void addNewPet() {
        print("Taking information about new Pet...");
        String type = inputString("Input type (cat, dog, hamster): ");
        String name = inputString("Input nickname: ");
        LocalDate birthday = inputDate("Input birthday (yyyy-mm-dd): ");
        if ( birthday != null) {
            presenter.addNewPet(type, name, birthday);
        }
        print("");
    }

    private String inputString(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    private LocalDate inputDate(String message) {
        System.out.print(message);
        String input = scanner.nextLine();
        String[] dateNumbers = input.split("-");
        if (dateNumbers.length == 3) {
            try {
                int year = Integer.parseInt(dateNumbers[0]);
                int month = Integer.parseInt(dateNumbers[1]);
                int day = Integer.parseInt(dateNumbers[2]);
                return LocalDate.of(year, month, day);
            } catch (NumberFormatException e) {
                print("It must be the integer numbers in date!" + "\n");
            } catch (DateTimeException e) {
                print("An incorrect date was entered!" + "\n");
            }
        } else {
            print("Not enough data for the date or wrong format!" + "\n");
        }


        return null;
    }

    @Override
    public void deletePet() {
        String strId = inputString("Input Pet`s id: ");
        try {
            int id = Integer.parseInt(strId);
            presenter.deletePet(id);
        } catch (NumberFormatException e) {
            print("An incorrect value was entered!");
        }
        print("");
    }

    @Override
    public void teachPetById() {
        String strId = inputString("Input Pet`s id: ");
        String command = inputString("Input Pet`s command: ");
        try {
            int id = Integer.parseInt(strId);
            presenter.teachPetById(id, command);
        } catch (NumberFormatException e) {
            print("An incorrect value was entered!");
        }
        print("");
    }

    @Override
    public void getPetsCommandsById() {
        String strId = inputString("Input Pet`s id: ");
        try {
            int id = Integer.parseInt(strId);
            presenter.getPetsCommandsById(id);
        } catch (NumberFormatException e) {
            print("An incorrect value was entered!");
        }
        print("");
    }

    @Override
    public void getPetInfo() {
        String strId = inputString("Input Pet`s id: ");
        try {
            int id = Integer.parseInt(strId);
            presenter.getPetInfo(id);
        } catch (NumberFormatException e) {
            print("An incorrect value was entered!");
        }
        print("");
    }

    @Override
    public void getPetsList() {
        print("------------Pets list----------");
        presenter.getPetsList();
        print("");
    }

    @Override
    public void load() {
        presenter.loadPetsFromDB();
    }
}
