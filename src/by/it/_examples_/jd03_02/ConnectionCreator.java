package by.it._examples_.jd03_02;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class ConnectionCreator {

    //Памятка. Корректно держать эти настройки соединения вне кода (!)
    private static final String URL_DB =
            "jdbc:mysql://127.0.0.1:2016/itacademy"
             +"?useUnicode=true&characterEncoding=UTF-8";
    private static final String USER_DB = "root";
    private static final String PASSWORD_DB = "";

    //==============================================================================
    //регистрация драйвера mysql
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            DriverManager.registerDriver(new FabricMySQLDriver());
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
                synchronized (URL_DB) {
                    if (connection == null || connection.isClosed())
                        connection = DriverManager.getConnection(URL_DB, USER_DB, PASSWORD_DB);
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
