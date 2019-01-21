package by.it.berdnik.jd03_02.crud;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

class ConnectionCreator {

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

    private static volatile Connection connection = null;

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
                synchronized (by.it.berdnik.jd03_02.crud.CN.USER_DB) {
                    if (connection == null || connection.isClosed())
                        connection = DriverManager.getConnection(by.it.berdnik.jd03_02.crud.CN.URL_DB, by.it.berdnik.jd03_02.crud.CN.USER_DB, by.it.berdnik.jd03_02.crud.CN.PASSWORD_DB);
                }
        }
        return connection;
    }
}
