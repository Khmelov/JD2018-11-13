package by.it.zakharenko.jd03_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Runner {

    public static void main(String[] args) {
        // Создаем connection используя данные из config при помощи JDBC DriverManager
        try (Connection connection = DriverManager.getConnection(CONFIG.URL_DB, CONFIG.USER_DB, CONFIG.PASSWORD_DB)) {

            Statement statement = connection.createStatement();  // Создаем объект statement и ссылку на него
            C_Init.createDatabase(statement);                   // Создаем базу данных и заполняем ее (класс C_Init)
            System.out.println("DataBase has been created and filled!");
            System.out.println("...");
            System.out.println("Do you want to delete tables and DataBase now? (y/n)");
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            String question = bf.readLine();

            if (question.equalsIgnoreCase("y")) {
                C_Reset.deleteTables(statement);                       // Запускаем метод удаления таблиц и базы данных
                System.out.println("DataBase has been deleted... :(");
            } else {
                System.out.println("DataBase left. Thank you! :)");   // Иначе не удаляем базу
            }

            // Пробрасываем ошибки из вызываемых классов и ловим в Runner
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}