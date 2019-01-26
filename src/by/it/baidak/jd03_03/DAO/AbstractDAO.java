package by.it.baidak.jd03_03.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

abstract class AbstractDAO {

    protected static int executeUpdate(String sql, boolean returnLastID) throws SQLException {
        int result;
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            result = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if (result > 0 && returnLastID) {
                ResultSet resultSet = statement.getGeneratedKeys();
                if (resultSet.next()) result = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        }
        return result;
    }
}
