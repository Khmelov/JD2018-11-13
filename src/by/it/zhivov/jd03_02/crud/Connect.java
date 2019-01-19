package by.it.zhivov.jd03_02.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static volatile Connection connection;

    static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            synchronized (Connect.class) {
                if (connection == null || connection.isClosed()) {
                    connection = DriverManager.getConnection(CN.URL, CN.LOGIN, CN.PASSWORD);
                }
            }
        }
        return connection;

    }
}
