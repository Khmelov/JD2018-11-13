package by.it.denisova.jd03_01;

import java.sql.*;

public class Runner {
    public static void main(String[] args) {
        String configFileName = System.getProperty("user.dir") + "/src/by/it/denisova/jd03_01/config.xml";
        Config config = new Config();

        if(config.load(configFileName)) {
            C_Reset.deleteDatabase(config);
            System.out.println("Database deleted");

            C_Init.createDatabase(config);
            System.out.println("Database created");
        }
        else {
            System.out.println("file: "+ configFileName + "can't load");
        }

        System.out.println("\nLet's try receive some users data:");
        try (Connection connection = DriverManager.getConnection(
                config.getDatabaseURL() + config.getNameDatabase(), config.getUserName(), config.getPassword())) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users;");
            while (resultSet.next()) {
                String out = resultSet.getString("login") + ", " + resultSet.getString("email");
                System.out.println(out);
            }

        } catch (SQLException e) {
            System.err.println("ClassNotFoundException: " + e.getMessage());
        }
    }

}
