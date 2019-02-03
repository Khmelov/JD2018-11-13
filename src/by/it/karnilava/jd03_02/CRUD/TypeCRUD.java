package by.it.karnilava.jd03_02.CRUD;


import by.it.karnilava.jd03_02.beans.TypeOfAccount;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TypeCRUD {
    boolean create(TypeOfAccount typeOfAccount) {
        // `karnilava`.`Type of account` (`idType of account`, `Type`)
        String sql = String.format(
                "INSERT INTO `karnilava`.`Type of account` ( `Type`) " +
                        "VALUES ('%s')",
                typeOfAccount.getType());

        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            if (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    typeOfAccount.setIdType_of_account(generatedKeys.getLong(1));

                }
                return true;
            }
        } catch (Exception e) {
            System.out.println("Creation of " + typeOfAccount.toString() + " is failed");
            return false;

        }
        return false;
    }

    boolean delete(TypeOfAccount typeOfAccount) throws SQLException {
        String sql = String.format(
                "DELETE FROM `karnilava`.`Type of account` WHERE `karnilava`.`Type of account`.`idType of account` = %d",
                typeOfAccount.getIdType_of_account());
        try (Connection connection = Connect.getConnection();

             Statement statement = connection.createStatement()) {
            return (1 == statement.executeUpdate(sql));
        }
    }

    boolean update(TypeOfAccount typeOfAccount) throws SQLException {
        String sql = String.format(
                "UPDATE `karnilava`.`Type of account`  SET " +
                        "`Type` = '%s' " +
                        "WHERE `karnilava`.`Type of account`.`idType of account` = %d",
                typeOfAccount.getType(), typeOfAccount.getIdType_of_account()
        );
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            return (1 == statement.executeUpdate(sql));
        }
    }


   TypeOfAccount read(long id) throws SQLException {
        String sql = String.format("SELECT `idType of account`,`Type` " +
                "FROM  `karnilava`.`Type of account` WHERE `karnilava`.`Type of account`.`idType of account`=%d", id);
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                //id ok
                String type = resultSet.getString("Type");

                return new TypeOfAccount(id, type);
            } else
                return null;
        }

    }


}

