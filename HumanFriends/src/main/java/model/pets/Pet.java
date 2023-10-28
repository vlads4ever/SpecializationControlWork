package model.pets;

import model.interfaces.Animal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public abstract class Pet implements Animal {
    private int id;
    private String name;
    private LocalDate birthday;
    private List<String> commands;

    public Pet(int id) {
        this.id = id;
        this.commands = new ArrayList<>();
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setBirthday(LocalDate date) {
        this.birthday = date;
    }

    public void setCommands(List<String> commands) {
        this.commands = commands;
    }

    @Override
    public void addCommand(String command) {
        commands.add(command);
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    public LocalDate getBirthdayDate(){
        return birthday;
    }

    @Override
    public String getBirthday() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return formatter.format(birthday);
    }

    @Override
    public List<String> getCommands() {
        return commands;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append("ID: " + id + "    ");
        output.append("Type: " + this.getClass().getSimpleName() + "    ");
        output.append("Nickname: " + name + "    ");
        output.append("Birthday: " + birthday + "\n");
        output.append("Commands: ");
        if (commands.size() == 0) {
            output.append("Pet doesn`t know any command.");
        } else {
            for (String command : commands) {
                output.append(command + " ");
            }
        }
        output.append("\n");
        return output.toString();
    }
}
