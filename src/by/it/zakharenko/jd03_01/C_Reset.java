package by.it.zakharenko.jd03_01;

import java.sql.SQLException;
import java.sql.Statement;

class C_Reset {
    static void deleteTables(Statement statement) throws SQLException {
            // Удаляем таблицы
            statement.executeUpdate("DROP TABLE IF EXISTS `zakharnk`.`orders`");
            statement.executeUpdate("DROP TABLE IF EXISTS `zakharnk`.`clients`");
            statement.executeUpdate("DROP TABLE IF EXISTS `zakharnk`.`roles`");
            // Удаляем саму базу данных
            statement.executeUpdate("DROP SCHEMA IF EXISTS `zakharnk`");
    }
}