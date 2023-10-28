package model.service;

import model.pets.Pet;
import model.petsRegistry.Counter;
import model.petsRegistry.PetsRegistry;

import java.time.LocalDate;
import java.util.List;

public class Service {
    private PetsRegistry activeRegistry;

    public Service(Counter counter) {
        this.activeRegistry = new PetsRegistry(counter);
    }

    public String addNewPet(String type, String name, LocalDate birthday) {
        return activeRegistry.addNewPet(type, name, birthday);
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
}
