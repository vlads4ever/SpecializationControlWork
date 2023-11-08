package presenter;

import model.service.Service;
import view.interfaces.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }

    public void addNewPet(String type, String name, LocalDate birthday) {
        view.print(service.addNewPet(type, name, birthday));
    }

    public void deletePet (int id) {
        view.print(service.deletePet(id));
    }

    public void teachPetById(int id, String command) {
        view.print(service.teachPetById(id, command));
    }

    public void getPetsCommandsById(int id) {
        view.print(service.getPetsCommandsById(id));
    }

    public void getPetInfo(int id) {
        view.print(service.getPetInfo(id));
    }

    public void getPetsList() {
        view.print(service.getPetsList());
    }

    public void loadPetsFromDB() {
        view.print(service.loadPetsFromDB());
    }

    public void savePetsToDB() {
        view.print(service.savePetsToDB());
    }
}
