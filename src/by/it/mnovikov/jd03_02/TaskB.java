package by.it.mnovikov.jd03_02;

import by.it.mnovikov.jd03_02.crud.Connect_DB;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class TaskB {
    public static void main(String[] args) {
        try (Statement statement = Connect_DB.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(
                    "SELECT * FROM `users` INNER JOIN `roles` ON `users`.`roles_ID`= `roles`.`ID`");
            while (resultSet.next()) {
                ResultSetMetaData metaData = resultSet.getMetaData();
                int columnCount = metaData.getColumnCount();
                for (int i = 1; i < columnCount + 1; i++) {
                    System.out.println(metaData.getColumnLabel(i) + " = " + resultSet.getString(i) + "\t");
                }
                System.out.println("--------------------------------");
            }

            resultSet = statement.executeQuery("SELECT COUNT(*) FROM `users` INNER JOIN `roles` ON `users`.`roles_ID`= `roles`.`ID`");
            if (resultSet.next()) {
                System.out.println("Всего записей в таблице пользователей: " + resultSet.getInt(1));
            }

            resultSet = statement.executeQuery("SELECT COUNT(*) FROM `roles`");
            if (resultSet.next()){
                System.out.println("Количество возможных ролей: " + resultSet.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
