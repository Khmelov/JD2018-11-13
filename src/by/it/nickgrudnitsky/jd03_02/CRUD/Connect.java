package by.it.nickgrudnitsky.jd03_02.CRUD;


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

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            synchronized (Connect.class) {
                if (connection == null || connection.isClosed()) {
                    //"jdbc:mysql://127.0.0.1:2016/", "root", ""
                    //"jdbc:mysql://127.0.0.1:3306/", "root", "12345Qwe"
                    connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:2016/", "root", "");
                }
            }
        }
        return connection;
    }
}
