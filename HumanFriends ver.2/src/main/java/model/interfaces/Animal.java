package model.interfaces;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public interface Animal {
    void setName(String name);
    void setBirthday(LocalDate date);
    void addCommand(String command);
    int getId();
    String getName();
    String getBirthday();
    List<String> getCommands();
}
