package by.it.markelov.jd03_02.crud;

import by.it.markelov.jd03_02.beans.Role;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RoleCRUD {
    public Role create (Role role) throws SQLException {

        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {


            String sql = String.format("INSERT INTO `roles`(`Role`) VALUES (`%s`);", role.getRole());

            int countCreatedObject = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if (countCreatedObject == 1) {
                ResultSet keys = statement.getGeneratedKeys();
                int id = keys.getInt(1);
                role.setId(id);
            }
            return role;
        }
    }

    public Role read () {
        return null;
    }

    public boolean update () {
        return false;
    }
    public boolean delete () {
        return false;
    }

}