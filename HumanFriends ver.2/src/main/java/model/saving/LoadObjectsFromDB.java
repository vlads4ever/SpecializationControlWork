package model.saving;

import model.interfaces.Loadable;
import model.pets.Pet;
import model.petsRegistry.PetsRegistry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.time.LocalDate;

public class LoadObjectsFromDB implements Loadable {

    // JDBC URL, username and password of MySQL server
    private static String url;
    private static String user;
    private static String password;

    // JDBC variables for opening and managing connection
    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    public LoadObjectsFromDB() {
        url = "jdbc:mysql://localhost:3306/human_friends";
        user = "root";
        password = "12345678";
    }

    @Override
    public String loadObjects(PetsRegistry<Pet> activeRegistry) {
        return loadFromDb("cat", activeRegistry) + "\n" +
                loadFromDb("dog", activeRegistry) + "\n" +
                loadFromDb("hamster", activeRegistry);
    }

    private String loadFromDb(String type, PetsRegistry<Pet> activeRegistry) {
        String query = String.format("SELECT name, birthday, commands FROM %ss;", type);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);

            // getting Statement object to execute query
            stmt = con.createStatement();

            // executing SELECT query
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                String name = rs.getString("name");
                LocalDate birthday = LocalDate.parse(rs.getString("birthday"));
                String commands = rs.getString("commands");
                System.out.printf("Name: %s, Birthday: %s, Commands: %s \n", name, birthday, commands);
                String[] splCommands = commands.split(",");
                activeRegistry.addNewPet(type, name, birthday, splCommands);
            }
            return String.format("%s was loaded from database.", type);
        } catch (SQLException | ClassNotFoundException sqlEx) {
            sqlEx.printStackTrace();
            return String.format("%s was not loaded from database.", type);
        } finally {
            //close connection ,stmt and resultset here
            try { con.close(); } catch(SQLException se) { /*can't do anything */ }
            try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
            try { rs.close(); } catch(SQLException se) { /*can't do anything */ }
        }
    }
}
