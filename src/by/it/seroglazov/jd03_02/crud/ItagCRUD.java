package by.it.seroglazov.jd03_02.crud;

import by.it.seroglazov.jd03_02.MyDatabaseConnector;
import by.it.seroglazov.jd03_02.beans.Itag;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ItagCRUD {

    public boolean create(Itag itag) {
        String sql = String.format(
                "INSERT INTO `itags` (`id`, `text`) VALUES (DEFAULT, '%s');", itag.getText());
        try (Connection connection = MyDatabaseConnector.getConnection();
             Statement statement = connection.createStatement()) {
            if (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    itag.setId(generatedKeys.getLong(1));
                }
                return true;
            }
        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
        }
        return false;
    }
}
