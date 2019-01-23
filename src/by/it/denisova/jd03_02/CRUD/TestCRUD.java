package by.it.denisova.jd03_02.CRUD;

import by.it.denisova.jd03_02.beans.Test;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestCRUD {

    boolean create(Test test) throws SQLException {
        String sql = String.format("INSERT INTO `tests` (`test_name`) " +
                        "VALUES ('%s')",
                test.getTest_name()
        );
        try (Connection connection = Connect.getConnection();
             Statement st = connection.createStatement()) {
            if (1 == st.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet generatedKeys = st.getGeneratedKeys();
                if(generatedKeys.next()) {
                    test.setId(generatedKeys.getLong(1));
                }
                return true;
            }
        }

        return false;
    }

    boolean delete(Test test) throws SQLException {
        String sql = String.format(
                "DELETE FROM `tests` WHERE `tests`.`id_test` = %d",
                test.getId()
        );
        try (Connection connection = Connect.getConnection();
             Statement st = connection.createStatement()) {
            return (1 == st.executeUpdate(sql));
        }
    }

    boolean update (Test test) throws  SQLException {
        String sql = String.format(
                "UPDATE `tests` SET " +
                        "`test_name` = '%s' WHERE `tests`.`id_test` = %d",
            test.getTest_name(), test.getId()
        );
        try (Connection connection = Connect.getConnection();
             Statement st = connection.createStatement()){
            return (1 == st.executeUpdate(sql));
        }
    }

    Test read (long id) throws SQLException {
        String sql = String.format(
                "SELECT * FROM `tests` WHERE id_test = %d", id
        );

        try (Connection connection = Connect.getConnection();
             Statement st = connection.createStatement()) {
            ResultSet resSet = st.executeQuery(sql);
            if(resSet.next()) {
                String test_name = resSet.getString("test_name");

                return new Test(id, test_name);
            }
            else return null;
        }
    }

}
