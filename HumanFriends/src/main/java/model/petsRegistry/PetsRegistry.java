package model.petsRegistry;

import model.interfaces.Animal;
import model.pets.Cat;
import model.pets.Dog;
import model.pets.Hamster;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PetsRegistry<E extends Animal> implements Iterable<E>{
    private final Counter counter;
    private final List<E> registry;

    public PetsRegistry(Counter counter) {
        this.registry = new ArrayList<>();
        this.counter = counter;
    }

    public String addNewPet(String type, String name, LocalDate birthday) {
        counter.add();  // Увеличиваем id на 1
        int id = counter.getNewId();    // Берем увеличенный на 1 id
        E newPet = createNewPet(type, id);
        if (newPet == null) {
            return "No such Pet type!";
        } else {
            newPet.setName(name);
            newPet.setBirthday(birthday);
            registry.add(newPet);
            return "New pet added.";
        }
    }

    public String teachPetById(int id, String command) {
        E pet = findPetById(id);
        if (pet != null) {
            pet.addCommand(command);
            return "Pet was taught.";
        }
        return  "Pet not found!";
    }

    public String getPetsCommandsById(int id) {
        E pet = findPetById(id);
        if (pet != null) {
            List<String> commands = pet.getCommands();
            StringBuilder output = new StringBuilder();
            output.append("Pet`s command by id ").append(id).append(": ").append("\n");
            if (commands.size() == 0) {
                output.append("Pet doesn`t know any command.");
            } else {
                for (String command : commands) {
                    output.append(command).append("\n");
                }
            }
            return output.toString();
        }
        return  "Pet not found!";
    }

    private E createNewPet (String type, int id) {
        return switch (type) {
            case "cat" -> (E) new Cat(id);
            case "dog" -> (E) new Dog(id);
            case "hamster" -> (E) new Hamster(id);
            default -> null;
        };
    }

    public String deletePet (int id) {
        E pet = findPetById(id);
        if (pet != null) {
            registry.remove(pet);
            return "Pet with id " + id + " was deleted.";
        }
        return  "Pet not found!";
    }

    private E findPetById(int id) {
        for (E pet: registry) {
            if (pet.getId() == id) return pet;
        }
        return null;
    }

    public String getPetInfo(int id) {
        E pet = findPetById(id);
        if (pet != null) {
            return pet.toString();
        }
        return  "Pet not found!";
    }

    public String getPetsList() {
        StringBuilder output = new StringBuilder();
        if (registry.size() == 0) {
            return "You have no Pets.";
        } else {
            Iterator<E> iterator = this.iterator();
            while (iterator.hasNext()) {
                E pet = iterator.next();
                output.append("ID: ").append(pet.getId()).append("    ");
                output.append("Type: ").append(pet.getClass().getSimpleName()).append("    ");
                output.append("Nickname: ").append(pet.getName()).append("    ");
                output.append("Birthday: ").append(pet.getBirthday()).append("\n");
            }
            return output.toString();
        }
    }

    @Override
    public Iterator<E> iterator() {
        return (Iterator<E>) new PetsIterator((List<Animal>) registry);
    }
}
