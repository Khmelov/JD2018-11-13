package by.it.seroglazov.project.java.dao;

import by.it.seroglazov.project.java.controller.SiteException;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class DatabaseConnector {

    private static Config config;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Can't find jdbc.Driver class: " + e.getMessage());
        }
        try {
            config = new Config();
            config.loadFromXml();
        } catch (IOException e) {
            /*System.err.println("Can't read config file " + MyConstants.configFileFullName
                    + " with message: " + e.getMessage());*/
        }
    }

    private static volatile Connection connection;

    static Connection getConnection(boolean withDatabaseName) throws SQLException, SiteException {
        if (connection == null || connection.isClosed()) {
            synchronized (DatabaseConnector.class) {
                if (connection == null || connection.isClosed()) {
                    if (withDatabaseName) {
                        connection = DriverManager.getConnection(
                                config.getDataBaseURL() + config.getDataBaseName() + config.getDataBaseSuffix(), config.getUserName(), config.getPassword());
                    } else {
                        connection = DriverManager.getConnection(
                                config.getDataBaseURL(), config.getUserName(), config.getPassword());
                    }
                }
            }
        }
        return connection;
    }

    public static Connection getConnection() throws SQLException, SiteException {
        return getConnection(true);
    }

    private DatabaseConnector() {
    }


}
