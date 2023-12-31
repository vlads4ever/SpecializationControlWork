package model.interfaces;

import model.pets.Pet;
import model.petsRegistry.PetsRegistry;

public interface Loadable {
    String loadObjects(PetsRegistry<Pet> activeRegistry);
}
