package model.pets;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Pet {
    private int id;
    private String name;
    private LocalDate birthday;
    private List<String> commands;

    public Pet(int id, String name, LocalDate birthday, List<String> commands) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
//        this.commands = new ArrayList<>();
        this.commands = commands;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(LocalDate date) {
        this.birthday = date;
    }

    public void setCommands(List<String> commands) {
        this.commands = commands;
    }

    public void addCommand(String command) {
        commands.add(command);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthdayDate(){
        return birthday;
    }

    public String getBirthday() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return formatter.format(birthday);
    }

    public List<String> getCommands() {
        return commands;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append("ID: " + id + "    ");
        output.append("Nickname: " + name + "    ");
        output.append("Birthday: " + birthday + "\n");
        output.append("Commands: ");
        for (String command: commands) {
            output.append(command + " ");
        }
        output.append("\n");
        return output.toString();
    }
}
