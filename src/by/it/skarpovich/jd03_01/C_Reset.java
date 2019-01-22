package by.it.skarpovich.jd03_01;

import java.sql.SQLException;
import java.sql.Statement;

class C_Reset {
    static void deleteTables(Statement statement) throws SQLException {
            // Удаляем таблицы
            statement.executeUpdate("DROP TABLE IF EXISTS `skarpovich`.`purchases`");
            statement.executeUpdate("DROP TABLE IF EXISTS `skarpovich`.`buyers`");
            statement.executeUpdate("DROP TABLE IF EXISTS `skarpovich`.`roles`");
            // Удаляем саму базу данных
            statement.executeUpdate("DROP SCHEMA IF EXISTS `skarpovich`");
    }
}