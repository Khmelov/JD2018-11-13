package by.it.karnilava.jd03_02;

import by.it.karnilava.jd03_02.CRUD.Connect;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TaskA_SearchID {


    public static long searchID(
            String nameOfRole) throws SQLException {
        long id = 0;


        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("SELECT idRoles, Roles FROM `karnilava`.`Roles`  WHERE Roles= '%s'", nameOfRole);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                id = resultSet.getLong("idRoles");

            }
            System.out.println(nameOfRole + " has " + id + " ID");
        }

        return id;
    }

    public static void main(String[] args) throws SQLException {
        searchID("admin");
    }
}




