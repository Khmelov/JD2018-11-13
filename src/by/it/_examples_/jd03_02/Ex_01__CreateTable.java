package by.it._examples_.jd03_02;

import by.it._examples_.jd03_02.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Ex_01__CreateTable {


    public static void main(String[] args) {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            //ПРИМЕР. удаляем таблицу
            statement.executeUpdate("DROP TABLE IF EXISTS DB_USER ");

            //ПРИМЕР. вставляем таблицу
            String createTableSQL = "CREATE TABLE DB_USER"+
                                    "(USER_ID INT(11) NOT NULL AUTO_INCREMENT COMMENT 'Primary key!!!', "+
                                    "USERNAME VARCHAR(20) NOT NULL, "+
                                    "PRIMARY KEY (USER_ID) )";
            statement.executeUpdate(createTableSQL);

            //ПРИМЕР. добавим запись
            statement.executeUpdate(
                    "INSERT INTO DB_USER (USERNAME) VALUES ('Test+Проверка');"
            );
            //ПРИМЕР. проверим эту запись
            ResultSet rs=statement.executeQuery("SELECT * FROM DB_USER");
            while (rs.next()){
                System.out.println(rs.getString("USER_ID")+":"+rs.getString("USERNAME"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
