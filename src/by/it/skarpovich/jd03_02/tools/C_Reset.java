package by.it.skarpovich.jd03_02.tools;

import java.sql.SQLException;
import java.sql.Statement;

class C_Reset {
    static void deleteTables(Statement statement) throws SQLException {
            // Удаляем таблицы (снизу вверх!)
//            statement.executeUpdate("DROP TABLE IF EXISTS `skarpovich`.`purchases`");
//            statement.executeUpdate("DROP TABLE IF EXISTS `skarpovich`.`buyers`");
//            statement.executeUpdate("DROP TABLE IF EXISTS `skarpovich`.`roles`");
            // Удаляем саму базу данных
            statement.executeUpdate("DROP SCHEMA IF EXISTS `skarpovich`");
    }
}