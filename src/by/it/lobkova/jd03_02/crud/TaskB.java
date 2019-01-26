package by.it.lobkova.jd03_02.crud;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TaskB {
    public static void main(String[] args) throws SQLException {
        String sql1 = "SELECT `users`.`name`,`roles`.`role` FROM `roles` INNER JOIN `users` ON `users`.`roles_ID` = `roles`.`id`";
        String sql2 = "SELECT COUNT(id) FROM `users`";
        String sql3 = "SELECT COUNT(id) FROM `roles`";
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql1);
            System.out.println("Все пользователи с их текстовыми ролями:");
            while (resultSet.next()) {
                System.out.printf("name = %s   ", resultSet.getString(1));
                System.out.printf("role = %s ", resultSet.getString(2));
                System.out.println();
            }

            ResultSet resultSet1 = statement.executeQuery(sql2);
            System.out.print("Количество юзеров:");
            if (resultSet1.next()) {
                System.out.println(resultSet1.getString(1));
            }

            ResultSet resultSet2 = statement.executeQuery(sql3);
            System.out.print("Количество ролей:");
            if (resultSet2.next()) {
                System.out.println(resultSet2.getString(1));
            }
        }
    }
}
