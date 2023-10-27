package model.pets;

import java.time.LocalDate;
import java.util.List;

public class Cat extends Pet {
    public Cat(int id, String name, LocalDate birthday, List<String> commands) {
        super(id, name, birthday, commands);
    }
}
