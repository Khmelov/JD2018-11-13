package by.it.karnilava.jd03_02.CRUD;

import by.it.karnilava.jd03_02.beans.StateOfAccount;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StateCRUD {

//    `karnilava`.`State options` (`idState options`, `State optionscol`)

    boolean create(StateOfAccount stateOfAccount) {
        String sql = String.format(
                "INSERT INTO  `karnilava`.`State options` ( `State optionscol`) " +
                        "VALUES ('%s')",
                stateOfAccount.getState()
              );

        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            if (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    stateOfAccount.setIdState(generatedKeys.getLong(1));

                }
                return true;
            }
        } catch (Exception e) {
            System.out.println("Creation of " + stateOfAccount.toString() + " is failed");
            return false;

        }
        return false;
    }

    boolean delete(StateOfAccount stateOfAccount) throws SQLException {
        String sql = String.format(
                "DELETE FROM `karnilava`.`State options` WHERE `karnilava`.`State options`.`idState options` = %d",
                stateOfAccount.getIdState()
        );
        try (Connection connection = Connect.getConnection();

             Statement statement = connection.createStatement()) {
            return (1 == statement.executeUpdate(sql));
        }
    }

    boolean update(StateOfAccount stateOfAccount) throws SQLException {
        String sql = String.format(
                "UPDATE `karnilava`.`State options`  SET " +
                        "`State optionscol` = '%s' " +
                        "WHERE `karnilava`.`State options`.`idState options` = %d",
               stateOfAccount.getState(), stateOfAccount.getIdState()  );
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            return (1 == statement.executeUpdate(sql));
        }
    }

    StateOfAccount read(long id) throws SQLException {
        String sql=String.format("SELECT `idState options`,`State optionscol` " +
                "FROM  `karnilava`.`State options` WHERE `karnilava`.`State options`.`idState options`=%d",id);
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()){
                //id ok
                String state=resultSet.getString("State optionscol");

                return new StateOfAccount(id,state);
            }
            else
                return null;
        }

    }
}
