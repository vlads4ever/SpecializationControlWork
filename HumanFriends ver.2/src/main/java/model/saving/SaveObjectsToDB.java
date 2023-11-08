package model.saving;

import model.interfaces.Saveable;
import model.pets.Pet;
import model.petsRegistry.PetsRegistry;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SaveObjectsToDB implements Saveable {
    // JDBC URL, username and password of MySQL server
    private static String url;
    private static String user;
    private static String password;

    public SaveObjectsToDB() {
        url = "jdbc:mysql://localhost:3306/human_friends";
        user = "root";
        password = "12345678";
    }

    @Override
    public String saveObjects(PetsRegistry<Pet> activeRegistry) {
        clearTable("dogs");
        clearTable("cats");
        clearTable("hamsters");
        for (Pet pet: activeRegistry) {
            String type = pet.getClass().getSimpleName();
            switch (type) {
                case "Dog" -> saveToDB("dogs", 1, pet);
                case "Cat" -> saveToDB("cats", 2, pet);
                case "Hamster" -> saveToDB("hamsters", 3, pet);
            }
        }
        return "Pets was saved to DB.";
    }

    private void clearTable(String table) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection con = DriverManager.getConnection(url, user, password)) {
                String query = "DELETE FROM " + table + ";";
                PreparedStatement prepSt = con.prepareStatement(query);
                prepSt.executeUpdate();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(SaveObjectsToDB.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex.getMessage());
        }
    }

    private void saveToDB(String table, int typeId, Pet pet) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection con = DriverManager.getConnection(url, user, password)) {
                String query =
                        "INSERT INTO " + table + " (name, birthday, commands, animal_kind_id) VALUES (?, ?, ?, ?);";
                PreparedStatement prepSt = con.prepareStatement(query);
                prepSt.setString(1, pet.getName());
                prepSt.setDate(2, Date.valueOf(pet.getBirthdayDate()));
                prepSt.setString(3, String.join(",", pet.getCommands()));
                prepSt.setInt(4, typeId);
                prepSt.executeUpdate();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(SaveObjectsToDB.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex.getMessage());
        }
    }

}
