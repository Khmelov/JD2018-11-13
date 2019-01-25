package by.it.baidak.jd03_03.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class Connect {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static String URL = "jdbc:mysql://127.0.0.1:2016/baidak?" + "useUnicode=true&characterEncoding=UTF-8";
    private static String USER = "root";
    private static String PASSWORD = "";

    private static volatile java.sql.Connection connection;

    static Connection getConnection() throws SQLException {
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
