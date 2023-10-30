package model.petsRegistry;

import model.interfaces.Animal;

import java.util.Iterator;
import java.util.List;

public class PetsIterator implements Iterator<Animal> {
    private int index;
    private List<Animal> registry;
    public PetsIterator(List<Animal> registry) {
        this.registry = registry;
    }

    @Override
    public boolean hasNext() {
        return index < registry.size();
    }

    @Override
    public Animal next() {
        return registry.get(index++);
    }
}
