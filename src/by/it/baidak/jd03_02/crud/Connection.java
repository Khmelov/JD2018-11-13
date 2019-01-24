package by.it.baidak.jd03_02.crud;

import java.sql.DriverManager;
import java.sql.SQLException;

class Connection {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    static String URL = "jdbc:mysql://127.0.0.1:2016/baidak?" +
            "useUnicode=true&characterEncoding=UTF-8";
    static String USER = "root";

    static String PASSWORD = "";

    private static volatile java.sql.Connection connection;

    static java.sql.Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            synchronized (Connection.class) {
                if (connection == null || connection.isClosed()) {
                    connection = DriverManager.getConnection(URL, USER, PASSWORD);
                }
            }
        }
        return connection;
    }
}
