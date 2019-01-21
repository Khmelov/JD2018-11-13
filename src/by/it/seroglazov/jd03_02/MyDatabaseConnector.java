package by.it.seroglazov.jd03_02;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyDatabaseConnector {
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

    private Connection connection;

    private MyDatabaseConnector(boolean withName) {
        try {
            if (withName) {
                connection = DriverManager.getConnection(
                        config.getDataBaseURL() + config.getDataBaseName(), config.getUserName(), config.getPassword());
            } else {
                connection = DriverManager.getConnection(
                        config.getDataBaseURL(), config.getUserName(), config.getPassword());
            }
        } catch (SQLException e) {
            System.err.println("Can't connect to database " + config.getDataBaseURL() + config.getDataBaseName()
                    + " with message: " + e.getMessage());
        }
    }


    public static Connection getConnection() {
        return new MyDatabaseConnector(true).connection;
    }

    public static Connection getConnectionWithoutDBName() {
        return new MyDatabaseConnector(false).connection;
    }


}
