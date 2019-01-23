package by.it.seroglazov.jd03_03;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {

    private static Config config;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Can't find jdbc.Driver class: " + e.getMessage());
        }
        try {
            config = new Config();
            config.loadFromXml(MyConstants.configFileFullName);
        } catch (IOException e) {
            System.err.println("Can't read config file " + MyConstants.configFileFullName
                    + " with message: " + e.getMessage());
        }
    }

    private static volatile Connection connection;

    static Connection getConnection(boolean withDatabaseName) throws SQLException {
        if (connection == null || connection.isClosed()) {
            synchronized (DatabaseConnector.class) {
                if (connection == null || connection.isClosed()) {
                    if (withDatabaseName) {
                        connection = DriverManager.getConnection(
                                config.getDataBaseURL() + config.getDataBaseName(), config.getUserName(), config.getPassword());
                    } else {
                        connection = DriverManager.getConnection(
                                config.getDataBaseURL(), config.getUserName(), config.getPassword());
                    }
                }
            }
        }
        return connection;
    }

    public static Connection getConnection() throws SQLException {
        return getConnection(true);
    }

    private DatabaseConnector() {
    }


}
