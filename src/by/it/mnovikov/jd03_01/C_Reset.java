package by.it.mnovikov.jd03_01;

import java.sql.SQLException;
import java.sql.Statement;

class C_Reset {

    static void deleteTables(Statement statement) throws SQLException {
            statement.executeUpdate("DELETE FROM `mnovikov`.`orders_goods`");
            statement.executeUpdate("DELETE FROM `mnovikov`.`orders`");
            statement.executeUpdate("DELETE FROM `mnovikov`.`goods`");
            statement.executeUpdate("DELETE FROM `mnovikov`.`users`");
            statement.executeUpdate("DELETE FROM `mnovikov`.`roles`");
            System.out.println("Delete all data");
    }

    static void deleteDB (Statement statement) throws SQLException {
        statement.executeUpdate("DROP SCHEMA IF EXISTS `mnovikov`");
        System.out.println("DB deleted");
    }
}
