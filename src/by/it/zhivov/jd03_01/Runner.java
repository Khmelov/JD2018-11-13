package by.it.zhivov.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Runner {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:mysql://127.0.0.1:2016";
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "");
        properties.setProperty("useSSL", "false"); //что бы не ругался на SSL for mySQL8
        properties.setProperty("autoReconnect", "true");
        try (Connection connection = DriverManager.getConnection(url, properties)) {
            if (connection.isClosed()) {
                System.out.println("Connection to " + url + " failure");
            } else System.out.println("Connection to " + url + " complete");
            //Driver driver = new FabricMySQLDriver();
            //DriverManager.registerDriver(driver);
            Statement statement = connection.createStatement();
            C_Reset.resetAds(statement);    //удаляет записи из таблицы ads
            C_Reset.resetUsers(statement);  //удаляет записи из таблицы users
            C_Reset.resetRoles(statement);  //удаляет записи из таблицы roles
            C_Reset.resetDB(statement);     //удаляет записи из всех таблиц
            C_Reset.dropDB(statement);      //удаляет базу данных
            C_Init.restoreDB(statement);    //восстанавливает базу данных по шаблону C_Init
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
