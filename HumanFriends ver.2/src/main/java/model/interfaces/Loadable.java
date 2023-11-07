package model.interfaces;

import model.pets.Pet;
import model.petsRegistry.PetsRegistry;

public interface Loadable {
    void loadObjects(PetsRegistry<Pet> activeRegistry);
}
