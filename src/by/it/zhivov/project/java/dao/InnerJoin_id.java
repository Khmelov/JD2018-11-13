package by.it.zhivov.project.java.dao;

import java.sql.*;

public class InnerJoin_id {
    public static void join() throws SQLException {
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM `users` INNER JOIN `roles` ON `users`.`roles_id`=`roles`.`id`");
            while (resultSet.next()) {
                ResultSetMetaData metaData = resultSet.getMetaData();
                int coummCount = metaData.getColumnCount();
                for (int i = 1; i < coummCount + 1; i++) {
                    System.out.print(metaData.getColumnLabel(i) + " = " +
                            resultSet.getString(i) + "\t");
                }
                System.out.println();
            }
        }
    }

    public static int getAllRows() throws SQLException {
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM `users` INNER JOIN `roles` ON `users`.`roles_id`=`roles`.`id`");
            if (resultSet.next()) {
                System.out.println("Колличество строк: " + resultSet.getInt(1));
                return resultSet.getInt(1);
            }
        }
        return 0;
    }

    public static int getRolesRows() throws SQLException {
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM `roles` WHERE 1");
            if (resultSet.next()) {
                System.out.println("Колличество ролей: " + resultSet.getInt(1));
                return resultSet.getInt(1);
            }
        }
        return 0;
    }
}