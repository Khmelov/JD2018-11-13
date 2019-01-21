package by.it.mnovikov.jd03_02.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by user on 19.01.2019.
 */

class Connect {
    private static volatile Connection connection;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            synchronized (Connect.class) {
                if (connection == null || connection.isClosed()) {
                    connection = DriverManager.getConnection(ConnC.URL_DB, ConnC.USER_DB, ConnC.PASSWORD_DB);
                }
            }
        }
        return connection;
    }
}
