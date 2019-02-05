package by.it.denisova.project.java.dao;

import by.it.denisova.project.java.beans.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TestDao implements InterfaceDao<Test> {

    public boolean create(Test test) throws SQLException {
        String sql = String.format(
                "INSERT INTO `tests` (`test_name`) " +
                        "VALUES ('%s')",
                test.getTest_name()
        );
        long id = Dao.executeCreateAndGetId(sql);
        test.setId(id);
        return (id > 0);
    }

    public boolean delete(Test test) throws SQLException {
        String sql = String.format(
                "DELETE FROM `tests` WHERE `tests`.`id_test` = %d",
                test.getId()
        );
        return Dao.executeUpdate(sql);
    }

    public boolean update(Test test) throws SQLException {
        String sql = String.format(
                "UPDATE `tests` SET " +
                        "`test_name` = '%s'"+
                        "WHERE `tests`.`id_test` = %d",
                test.getTest_name() , test.getId()
        );
        return Dao.executeUpdate(sql);
    }

    public Test read(long id) throws SQLException {
        String sqlSuffix = String.format("WHERE id_test = %d", id);
        List<Test> all = getAll(sqlSuffix);
        return all.size() > 0 ? all.get(0) : null;
    }

    @Override
    public List<Test> getAll(String sqlSuffix) throws SQLException {
        List<Test> result=new ArrayList<>();
        String sql = String.format("SELECT `id_test`, `test_name`" +
                "FROM `tests` %s",sqlSuffix);
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                //id ok
                long id = resultSet.getLong("id_test");
                String test_name = resultSet.getString("test_name");
                Test test = new Test(id,test_name);
                result.add(test);
            }
            return result;
        }
    }


}