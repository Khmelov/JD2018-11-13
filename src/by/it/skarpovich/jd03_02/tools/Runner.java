package by.it.skarpovich.jd03_02.tools;
import by.it.skarpovich.jd03_02.crud.CONFIG;
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
        try (Connection connection = DriverManager.getConnection(CONFIG.URL, CONFIG.USER, CONFIG.PASSWORD)) {

            Statement statement = connection.createStatement();  // Создаем объект statement и ссылку на него
            System.out.println("CREATE DATABASE or DELETE DATABASE? (c/d)");
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            String question = bf.readLine();

            if (question.equalsIgnoreCase("d")) {
                C_Reset.deleteTables(statement);                       // Запускаем метод удаления таблиц и базы данных
                System.out.println("DataBase has been deleted... :(");
            } else {
                C_Init.createDatabase(statement);                   // Создаем базу данных и заполняем ее (класс C_Init)
                System.out.println("Initial DataBase has been created and filled!");
            }

            // Пробрасываем ошибки из вызываемых классов и ловим в Runner
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}