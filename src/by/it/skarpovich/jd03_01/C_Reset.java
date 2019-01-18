package by.it.skarpovich.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class C_Reset {
    static void deleteTables() {

            try (Connection connection = DriverManager.getConnection(CONFIG.URL_DB, CONFIG.USER_DB, CONFIG.PASSWORD_DB))
            {
            Statement statement = connection.createStatement();

                statement.executeUpdate("DROP TABLE IF EXISTS `skarpovich`.`purchases`");
                statement.executeUpdate("DROP TABLE IF EXISTS `skarpovich`.`buyers`");
                statement.executeUpdate("DROP TABLE IF EXISTS `skarpovich`.`roles`");
                statement.executeUpdate("DROP SCHEMA IF EXISTS `skarpovich`");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}