package by.it.karnilava.jd03_02.CRUD;

import by.it.karnilava.jd03_02.beans.Account;
import by.it.karnilava.jd03_02.beans.Client;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccountCRUD {

    boolean create(Account account) {
        String sql = String.format(
                "INSERT INTO `karnilava`.`Account features` ( `Number`, `Balance`, `Client_idClient`, `Type of account_idType of account`, `State options_idState options` )" +
                        " VALUES ( '%s', '%s', '%d', '%d', '%d')",
                account.getNumberOfAccount(), account.getBalance(), account.getIdClient(), account.getIdType(), account.getIdState());


        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            if (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    account.setIdAccount(generatedKeys.getLong(1));

                }
                return true;
            }
        } catch (Exception e) {
            System.out.println("Creation of " + account.toString() + " is failed");
            return false;

        }
        return false;
    }

    boolean delete(Account account) throws SQLException {
        String sql = String.format(
                "DELETE FROM `karnilava`.`Account features` WHERE `karnilava`.`Account features`.`idAccounts` = %d",

                account.getIdAccount()
        );
        try (Connection connection = Connect.getConnection();

             Statement statement = connection.createStatement()) {
            return (1 == statement.executeUpdate(sql));
        }
    }

    boolean update(Account account) throws SQLException {
        String sql = String.format(
                "UPDATE `karnilava`.`Account features`  SET " +
                        "`Number`= '%s', `Balance` = '%s', `Client_idClient` = '%d', " +
                        "`Type of account_idType of account` = '%d', " +
                        "`State options_idState options`= '%d'" +
                        "WHERE `karnilava`.`Account features`.`idAccounts` = %d",

                account.getNumberOfAccount(), account.getBalance(), account.getIdType(),
                account.getIdClient(), account.getIdState(), account.getIdAccount());
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            return (1 == statement.executeUpdate(sql));
        }
    }

    Account read(long id) throws SQLException {
        String sql = String.format("SELECT `idAccounts`,`Number`, `Balance`, `Client_idClient`, `Type of account_idType of account`, `State options_idState options` " +
                "FROM  `karnilava`.`Account features` WHERE `karnilava`.`Account features`.`idAccounts`=%d", id);
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                //id ok
                String number = resultSet.getString("Number");
                String balance = resultSet.getString("Balance");
                long client_Id = resultSet.getLong("Client_idClient");
                long type_Id = resultSet.getLong("Type of account_idType of account");
                long state_Id = resultSet.getLong("State options_idState options");
                return new Account(id, number, balance, client_Id, type_Id, state_Id);
            } else
                return null;
        }

    }
}
