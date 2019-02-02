package by.it.karnilava.project05.dao;

import by.it.karnilava.jd03_03.beans.Account;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO extends DAO implements InterfaceDAO<Account> {
    @Override
    public Account read(long id) {
        String where = String.format("WHERE id=%d", id);
        List<Account> accounts = getAll(where);
        if (accounts.size() > 0) {
            return accounts.get(0);
        } else
            return null;
    }



    @Override
    public boolean create(Account account) throws SQLException {
        String sql = String.format(
                "INSERT INTO `karnilava1`.`account` (`number`, " +
                        "`balance`, `idClient`, " +
                        "`idType`, `idState`)" +
                        "VALUES('%s' ,'%s' ,'%d' ,'%d' ,'%d');",
                account.getNumber(),account.getBalance(), account.getIdClient(),
                account.getIdType(), account.getIdState()
        );
        long id = DAO.executeCreateAndGetId(sql);
        account.setId(id);
        return (id>0);

    }

    @Override
    public boolean update(Account account) throws SQLException {
        String sql = String.format(
                "UPDATE `karnilava1`.`account` SET `number` = '%s', "+
                "`balance` = '%s', `idClient` = '%d' , " +
                        "`idType` = '%d' , `idState` = '%d' "+
                        "WHERE  `karnilava1`.`account`.`id` =%d",

                account.getNumber(),account.getBalance(), account.getIdClient(),
                account.getIdType(), account.getIdState(), account.getId()
        );
        return (executeUpdate(sql));
    }

    @Override
    public boolean delete(Account account) throws SQLException {
        String sql = String.format("DELETE FROM `karnilava1`.`account`" +
                "WHERE `karnilava1`.`account`.`id` =%d",
                account.getId()
        );
        return DAO.executeUpdate(sql);
    }

    @Override
    public List<Account> getAll(String WhereAndOrder) {
        List<Account> accounts = new ArrayList<>();
        String sql = "SELECT * FROM `karnilava1`.`account` " + WhereAndOrder + " ;";

        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Account account = new Account();
                account.setId(rs.getInt("id"));
                account.setNumber(rs.getString("number"));
                account.setBalance(rs.getString("balance"));
                account.setIdClient(rs.getInt("idClient"));
                account.setIdType(rs.getInt("idType"));
                account.setIdState(rs.getInt("idState"));
                accounts.add(account);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return accounts;

    }
}
