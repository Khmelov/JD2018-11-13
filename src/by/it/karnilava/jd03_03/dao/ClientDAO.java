package by.it.karnilava.jd03_03.dao;

import by.it.karnilava.jd03_03.beans.Client;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO extends DAO implements InterfaceDAO<Client> {
    @Override
    public Client read(long id) {
        String where = String.format("WHERE id=%d", id);
        List<Client> clients = getAll(where);
        if (clients.size() > 0) {
            return clients.get(0);
        } else
            return null;
    }

    @Override
    public boolean create(Client client) throws SQLException {
        String sql = String.format(
                "INSERT INTO `karnilava1`.`client` (`passport`, " +
                        "`firstName`, `lastName`, " +
                        "`password`, `idRoles`)" +
                        "VALUES('%s' ,'%s' ,'%s' ,'%s' ,'%d');",
                client.getPassport(), client.getFirstName(), client.getLastName(),
                client.getPassword(), client.getIdRoles()
        );
        long id = DAO.executeCreateAndGetId(sql);
        client.setId(id);
        return (id>0);
    }

    @Override
    public boolean update(Client client) throws SQLException {
        String sql = String.format(
                "UPDATE `karnilava1`.`client` SET `passport` = '%s', " +
                        "`firstName` = '%s', `lastName` = '%s', " +
                        "`password` = '%s', `idRoles` = '%d' " +
                        "WHERE `karnilava1`.`client`.`id` =%d",

                client.getPassport(), client.getFirstName(), client.getLastName(),
                client.getPassword(), client.getIdRoles(), client.getId()
        );


        return (executeUpdate(sql));
    }

    @Override
    public boolean delete(Client client) throws SQLException {
        String sql = String.format(
                "DELETE FROM `karnilava1`.`client` WHERE `karnilava1`.`client`.`id` =%d",
                client.getId()
        );
        return DAO.executeUpdate(sql);
    }

    @Override
    public List<Client> getAll(String WhereAndOrder) {
        List<Client> clients = new ArrayList<>();
        String sql = String.format("SELECT `id`, `passport`, `firstName`, `lastName`, `password`, `idRoles` " +
                "FROM `karnilava1`.`client` " + WhereAndOrder);


        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Client client = new Client();
                client.setId(rs.getInt("id"));
                client.setPassport(rs.getString("passport"));
                client.setFirstName(rs.getString("firstName"));
                client.setLastName(rs.getString("lastName"));
                client.setPassword(rs.getString("password"));
                client.setIdRoles(rs.getInt("idRoles"));
               clients.add(client);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clients;
    }
}
