package by.it.markelov.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class C_Reset {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:2016/", "root", "")) {
            Statement statement = connection.createStatement();

//Потабличное удаление
/*
            statement.executeUpdate("DROP TABLE IF EXISTS `markelov`.`shoe_collour`;");
            statement.executeUpdate("DROP TABLE IF EXISTS `markelov`.`shoe_sizes`;");
            statement.executeUpdate("DROP TABLE IF EXISTS `markelov`.`shoe_names`;");
            statement.executeUpdate("DROP TABLE IF EXISTS `markelov`.`orders`;");
            statement.executeUpdate("DROP TABLE IF EXISTS `markelov`.`users`;");
            statement.executeUpdate("DROP TABLE IF EXISTS `markelov`.`roles`;");
            statement.executeUpdate("DROP SCHEMA IF EXISTS `markelov`;");
*/

//Построчное удаление
            statement.executeUpdate("DELETE FROM `markelov`.`shoe_collour`" +
                    "WHERE `shoe_collour`='White' ;");
            statement.executeUpdate("DELETE FROM `markelov`.`shoe_collour`" +
                    "WHERE `shoe_collour`='Black' ;");
            statement.executeUpdate("DELETE FROM `markelov`.`shoe_collour`" +
                    "WHERE `shoe_collour`='Green' ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `markelov`.`shoe_collour`;");
//=====================================================================================================================
            statement.executeUpdate("DELETE FROM `markelov`.`shoe_sizes`" +
                    "WHERE `shoe_size`='40';");
            statement.executeUpdate("DELETE FROM `markelov`.`shoe_sizes`" +
                    "WHERE `shoe_size`='36';");
            statement.executeUpdate("DELETE FROM `markelov`.`shoe_sizes`" +
                    "WHERE `shoe_size`='42';");
            statement.executeUpdate("DROP TABLE IF EXISTS `markelov`.`shoe_sizes`;");
//=====================================================================================================================
            statement.executeUpdate("DELETE FROM `markelov`.`shoe_names`" +
                    "WHERE `name`='Sandals';");
            statement.executeUpdate("DELETE FROM `markelov`.`shoe_names`" +
                    "WHERE `name`='Boots';");
            statement.executeUpdate("DELETE FROM `markelov`.`shoe_names`" +
                    "WHERE `name`='Sneakers';");
            statement.executeUpdate("DROP TABLE IF EXISTS `markelov`.`shoe_names`;");
//=====================================================================================================================
            statement.executeUpdate("DELETE FROM `markelov`.`orders`" +
                    "WHERE `ID`='3';");
            statement.executeUpdate("DELETE FROM `markelov`.`orders`" +
                    "WHERE `ID`='2';");
            statement.executeUpdate("DELETE FROM `markelov`.`orders`" +
                    "WHERE `ID`='1';");
            statement.executeUpdate("DROP TABLE IF EXISTS `markelov`.`orders`;");
//=====================================================================================================================
            statement.executeUpdate("DELETE FROM `markelov`.`users`" +
                    "WHERE `roles_ID`='2';");
            statement.executeUpdate("DELETE FROM `markelov`.`users`" +
                    "WHERE `roles_ID`='1';");
            statement.executeUpdate("DROP TABLE IF EXISTS `markelov`.`users`;");

            statement.executeUpdate("DELETE FROM `markelov`.`roles`" +
                    "WHERE `Role`='User';");
            statement.executeUpdate("DELETE FROM `markelov`.`roles`" +
                    "WHERE `Role`='Administrator';");
            statement.executeUpdate("DROP TABLE IF EXISTS `markelov`.`roles`;");
//=====================================================================================================================
            statement.executeUpdate("DROP SCHEMA IF EXISTS `markelov`;");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
