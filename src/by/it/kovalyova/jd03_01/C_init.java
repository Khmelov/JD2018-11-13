package by.it.kovalyova.jd03_01;

import java.sql.DriverManager;
import java.sql.SQLException;

public class C_init {
    public static void main(String[] args) throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        DriverManager.getConnection("jdbc:mysql://127.0.0.1:2016/", "root", "")

    (
                Statement statement = connect
        )
    }
}
