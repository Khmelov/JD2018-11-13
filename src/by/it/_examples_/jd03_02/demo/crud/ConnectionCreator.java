package by.it._examples_.jd03_02.demo.crud;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

class ConnectionCreator {

    //==============================================================================
    //регистрация драйвера
    static {
        Driver driver;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e);
        } catch (SQLException e) {
            System.out.println("Error: not register driver: "+e);
        }
    }

    //==============================================================================
    //аналог синглтона на случай множественного обращения
    private static volatile Connection connection = null;

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
                synchronized (CN.USER_DB) {
                    if (connection == null || connection.isClosed())
                        connection = DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
                }
        }
        return connection;
    }
    //==============================================================================
    //getConnection как синглтон это ДАЛЕКО не саме удачное решение, т.к.
    //два и более потока могут работать на одном подключении
    //что обязательно потребует их синхронизации
    //для этих целей удобнее применять пул подключений к базе.
    //этот вопрос мы рассмотрим на следующих занятиях

}
