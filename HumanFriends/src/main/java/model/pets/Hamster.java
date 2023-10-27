package model.pets;

import java.time.LocalDate;
import java.util.List;

public class Hamster extends Pet {
    public Hamster(int id, String name, LocalDate birthday, List<String> commands) {
        super(id, name, birthday, commands);
    }
}
