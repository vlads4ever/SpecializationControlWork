package model.service;

import model.interfaces.Loadable;
import model.pets.Pet;
import model.petsRegistry.Counter;
import model.petsRegistry.PetsRegistry;

import java.time.LocalDate;
import java.util.List;

public class Service {
    private final PetsRegistry<Pet> activeRegistry;
    private Loadable load;

    public Service(Counter counter, Loadable load) {
        this.activeRegistry = new PetsRegistry<>(counter);
        this.load = load;
    }

    public String addNewPet(String type, String name, LocalDate birthday) {
        return activeRegistry.addNewPet(type, name, birthday);
    }

    public String deletePet (int id) {
        return activeRegistry.deletePet(id);
    }

    public String teachPetById(int id, String command) {
        return activeRegistry.teachPetById(id, command);
    }

    public String getPetInfo(int id) {
        return activeRegistry.getPetInfo(id);
    }

    public String getPetsCommandsById(int id) {
        return  activeRegistry.getPetsCommandsById(id);
    }

    public String getPetsList() {
        return activeRegistry.getPetsList();
    }

    public String loadPetsFromDB() {
        load.loadObjects(activeRegistry);
        return "Pets was loaded from database";
    }
}
