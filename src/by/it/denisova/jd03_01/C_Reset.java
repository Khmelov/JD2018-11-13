package by.it.denisova.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;



    class C_Reset {

        private static void executeUpdate(Config config, String command) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                System.err.println("ClassNotFoundException: " + e.getMessage());
            }
            try (Connection connection = DriverManager.getConnection(
                    config.getDatabaseURL(), config.getUserName(), config.getPassword())) {
                Statement statement = connection.createStatement();
                statement.executeUpdate(command);

            } catch (SQLException e) {
                System.err.println("ClassNotFoundException: " + e.getMessage());
            }
        }

        static void deleteDatabase(Config config) {
            executeUpdate(config, "DROP SCHEMA IF EXISTS `" + config.getNameDatabase() + "` ;");
        }

        @SuppressWarnings("unused")
        static void deleteTable(Config config, String tableName) {
            executeUpdate(config, "DROP TABLE IF EXISTS `" + config.getNameDatabase() + "`.`" + tableName + "`;");
        }
    }

