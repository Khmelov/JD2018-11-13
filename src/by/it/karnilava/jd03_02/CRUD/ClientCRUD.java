package by.it.karnilava.jd03_02.CRUD;

import by.it.karnilava.jd03_02.beans.Client;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClientCRUD {

    boolean create(Client client)  {
        String sql = String.format(
                "INSERT INTO `karnilava`.`Client` ( `ID passport`, `first name`, `last name`, `password`, `Roles_idRoles`) " +
                        "VALUES ('%s', '%s', '%s', '%s','%d')",
                client.getID_passport(), client.getFirstName(), client.getLastName(), client.getPassword(), client.getRoles_idRoles()
        );
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            if (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    client.setIdClient(generatedKeys.getLong(1));

                }
                return true;
            }
        } catch (Exception e){
            System.out.println("Creation of "+client.toString()+" is failed");
            return false;

        }
        return false;
    }

    boolean delete(Client client) throws SQLException {
        String sql = String.format(
               "DELETE FROM `karnilava`.`Client` WHERE `karnilava`.`Client`.`idClient` = %d",

                client.getIdClient()
        );
        try (Connection connection = Connect.getConnection();

             Statement statement = connection.createStatement()) {
            return (1 == statement.executeUpdate(sql));
        }
    }

    boolean update(Client client) throws SQLException {
        String sql = String.format(
                "UPDATE `karnilava`.`Client`  SET " +
                        "`ID passport` = '%s', `first name` = '%s', " +
                        "`last name` = '%s', `password` = '%s', `Roles_idRoles` = '%d' " +
                        "WHERE `karnilava`.`Client`.`idClient` = %d",
                client.getID_passport(), client.getFirstName(),
                client.getLastName(), client.getPassword(),
                client.getRoles_idRoles(),client.getIdClient()
        );
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            return (1 == statement.executeUpdate(sql));
        }
    }

    Client read(long id) throws SQLException {
        String sql=String.format("SELECT `idClient`,`ID passport`, `first name`, `last name`, `password`, `Roles_idRoles` " +
                "FROM  `karnilava`.`Client` WHERE `karnilava`.`Client`.`idClient`=%d",id);
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()){
                //id ok
                String idPassport=resultSet.getString("ID passport");
                String firstName=resultSet.getString("first name");
                String lastName=resultSet.getString("last name");
                String password=resultSet.getString("password");
                long roles_Id=resultSet.getLong("Roles_idRoles");
                return new Client(id,idPassport,firstName,lastName,password,roles_Id);
            }
            else
                return null;
        }

    }
}
