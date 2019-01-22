package by.it._examples_.jd03_03.badpath;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionCreator {

    private static final String URL_DB =
            "jdbc:mysql://127.0.0.1:2016/login"
                    + "?useUnicode=true&characterEncoding=UTF-8";
    private static final String USER_DB = "root";
    private static final String PASSWORD_DB = "";

    private static Connection connection;

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed())
                connection = DriverManager.getConnection(
                        URL_DB, USER_DB, PASSWORD_DB
                );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
