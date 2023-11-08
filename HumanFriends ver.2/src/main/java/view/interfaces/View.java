package view.interfaces;

import model.pets.Pet;
import presenter.Presenter;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public interface View {
    void start();
    void setPresenter(Presenter presenter);
    void print(String text);
    void printMenu();
    void exit();
    void addNewPet();
    void deletePet();
    void teachPetById();
    void getPetsCommandsById();
    void getPetInfo();
    void getPetsList();
    void load();
    void save();
}
