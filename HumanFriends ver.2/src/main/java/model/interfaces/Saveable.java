package model.interfaces;

import model.pets.Pet;
import model.petsRegistry.PetsRegistry;

public interface Saveable {
    String saveObjects(PetsRegistry<Pet> activeRegistry);
}
