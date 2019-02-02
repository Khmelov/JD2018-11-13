package by.it.karnilava.jd03_02;

import by.it.karnilava.jd03_02.CRUD.Connect;

import java.sql.Connection;
import java.sql.Statement;

public class TaskC {
    public static void main(String[] args) {
        String tableName = null;
        String baseName = null;

        try (
                Connection connection = Connect.getConnection();
                Statement statement = connection.createStatement()) {

            // Удаление таблицы по имени. Имя берем в одинарные ковычки. Для примера взяла таблицу `Account features`
            tableName = "`Account features`";
            baseName = "`karnilavaTest`";
            String deleteTable = "DROP TABLE IF EXISTS " + baseName + "." + tableName + " ;";
            statement.executeUpdate(deleteTable);

            // удаление базы данных по имени

            String deleteBase = "DROP SCHEMA IF EXISTS " + baseName + " ;";
            statement.executeUpdate(deleteBase);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
