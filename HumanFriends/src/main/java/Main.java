import model.pets.Cat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> catCommand = new ArrayList<>();
        catCommand.add("Meow");
        catCommand.add("Jump");
        LocalDate catBirthday = LocalDate.of(2014, 10, 5);
        Cat cat = new Cat(1, "Kitty", catBirthday, catCommand);
        System.out.println(cat);
    }
}