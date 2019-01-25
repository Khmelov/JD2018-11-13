package by.it.naumenko.jd03_03;

import by.it.naumenko.jd03_02.CRUD.Conect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connected {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static volatile Connection connection;

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            synchronized (Connected.class) {
                if (connection == null || connection.isClosed())
                    connection = DriverManager.getConnection(Conect.URL, Conect.USER, Conect.PASSWORD);

            }
        }
        return connection;
    }
}
