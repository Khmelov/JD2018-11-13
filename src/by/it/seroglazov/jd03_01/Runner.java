package by.it.seroglazov.jd03_01;

import java.sql.*;

public class Runner {
    public static void main(String[] args) {
        String configFileName = System.getProperty("user.dir") + "/src/by/it/seroglazov/jd03_01/config.xml";
        Config config = new Config();
        if (config.load(configFileName)) {
            //C_Reset.deleteTable(config, "ingredients_itags");
            //C_Reset.deleteTable(config, "amounts");

            C_Reset.deleteDatabase(config);
            System.out.println("Database deleted");

            C_Init.createDatabase(config);
            System.out.println("Database created and filled");

        } else {
            System.err.println("Can't load file: "+ configFileName);
        }

        System.out.println("\nLet's try receive some users data:");
        try (Connection connection = DriverManager.getConnection(
                config.getDataBaseURL() + config.getDataBaseName(), config.getUserName(), config.getPassword())) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users;");
            while (resultSet.next()) {
                String out = resultSet.getString("nickname") + ", " + resultSet.getString("email");
                System.out.println(out);
            }

        } catch (SQLException e) {
            System.err.println("ClassNotFoundException: " + e.getMessage());
        }
    }
}
