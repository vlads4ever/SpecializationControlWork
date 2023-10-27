package model.pets;

import java.time.LocalDate;
import java.util.List;

public class Dog extends Pet {
    public Dog(int id, String name, LocalDate birthday, List<String> commands) {
        super(id, name, birthday, commands);
    }
}
