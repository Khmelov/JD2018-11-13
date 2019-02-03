package by.it.vchernetski.project.java.dao;

import java.sql.*;

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
                    connection = DriverManager.getConnection(CN.URLSTART, CN.USER, CN.PASSWORD);
                    connection.createStatement().executeUpdate("CREATE SCHEMA IF NOT EXISTS `vchernetski` DEFAULT CHARACTER SET utf8");
                    connection = DriverManager.getConnection(CN.URL, CN.USER, CN.PASSWORD);
                }
            }
        }
        return connection;
    }

    public static void deleteSCHEMA() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:2016/", "root", "");
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("DROP SCHEMA IF EXISTS `vchernetski`");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void resetSCHEMA() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:2016/", "root", "");
             Statement statement = connection.createStatement()){
            statement.executeUpdate("DROP SCHEMA IF EXISTS `vchernetski`");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `vchernetski` DEFAULT CHARACTER SET utf8");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `vchernetski`.`roles` (" +
                    "  `id` INT NOT NULL AUTO_INCREMENT," +
                    "  `role` VARCHAR(100) NULL," +
                    "  PRIMARY KEY (`id`))" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `vchernetski`.`users` (" +
                    "  `id` INT NOT NULL AUTO_INCREMENT," +
                    "  `fio` VARCHAR(100) NULL," +
                    "  `numbergarages` INT NULL," +
                    "  `nickname` VARCHAR(100) NULL," +
                    "  `email` VARCHAR(100) NULL," +
                    "  `password` VARCHAR(100) NULL," +
                    "  `roles_id` INT NOT NULL," +
                    "  PRIMARY KEY (`id`)," +
                    "  CONSTRAINT `fk_users_roles1`" +
                    "    FOREIGN KEY (`roles_id`)" +
                    "    REFERENCES `vchernetski`.`roles` (`id`)" +
                    "    ON DELETE NO ACTION" +
                    "    ON UPDATE NO ACTION)" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `vchernetski`.`garages` (" +
                    "  `id` INT NOT NULL AUTO_INCREMENT," +
                    "  `adress` VARCHAR(100) NULL," +
                    "  `carplaces` INT NULL," +
                    "  `users_id` INT NOT NULL," +
                    "  PRIMARY KEY (`id`, `users_id`)," +
                    "  INDEX `fk_garages_users1_idx` (`users_id` ASC)," +
                    "  CONSTRAINT `fk_garages_users1`" +
                    "    FOREIGN KEY (`users_id`)" +
                    "    REFERENCES `vchernetski`.`users` (`id`)" +
                    "    ON DELETE CASCADE" +
                    "    ON UPDATE CASCADE)" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `vchernetski`.`cars` (" +
                    "  `id` INT NOT NULL AUTO_INCREMENT," +
                    "  `model` VARCHAR(100) NOT NULL," +
                    "  `color` VARCHAR(100) NULL," +
                    "  `year` INT NULL," +
                    "  `garages_id` INT NOT NULL," +
                    "  PRIMARY KEY (`id`, `model`)," +
                    "  CONSTRAINT `fk_cars_garages1`" +
                    "    FOREIGN KEY (`garages_id`)" +
                    "    REFERENCES `vchernetski`.`garages` (`id`)" +
                    "    ON DELETE CASCADE" +
                    "    ON UPDATE CASCADE)" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("INSERT INTO `vchernetski`.`roles` (`id`, `role`) VALUES (DEFAULT, 'admin');");
            statement.executeUpdate("INSERT INTO `vchernetski`.`roles` (`id`, `role`) VALUES (DEFAULT, 'user');");
            statement.executeUpdate("INSERT INTO `vchernetski`.`roles` (`id`, `role`) VALUES (DEFAULT, 'guest');");
            statement.executeUpdate("INSERT INTO `vchernetski`.`users` (`id`, `fio`, `numbergarages`, `nickname`, `email`, `password`, `roles_id`) VALUES (DEFAULT, 'Ivan Ivanovich Ivanov', 2, 'ivanich', 'ivanich@mail.ru', 'user', 2);");
            statement.executeUpdate("INSERT INTO `vchernetski`.`users` (`id`, `fio`, `numbergarages`, `nickname`, `email`, `password`, `roles_id`) VALUES (DEFAULT, 'Petr Petrovich Petrov', 0, 'petya', 'petya@yandex.ru', 'admin', 1);");
            statement.executeUpdate("INSERT INTO `vchernetski`.`users` (`id`, `fio`, `numbergarages`, `nickname`, `email`, `password`, `roles_id`) VALUES (DEFAULT, 'Vasilii Aleksandrovich Alexandrov', 0, 'vasya', 'vasya@gmail.com', 'guest', 3);");
            statement.executeUpdate("INSERT INTO `vchernetski`.`garages` (`id`, `adress`, `carplaces`, `users_id`) VALUES (DEFAULT, 'Minsk, Lenina 3', 2, 1);");
            statement.executeUpdate("INSERT INTO `vchernetski`.`garages` (`id`, `adress`, `carplaces`, `users_id`) VALUES (DEFAULT, 'Minsk, Moskovskaya 17', 1, 1);");
            statement.executeUpdate("INSERT INTO `vchernetski`.`cars` (`id`, `model`, `color`, `year`, `garages_id`) VALUES (DEFAULT, 'BMW X5', 'white', 2015, 1);");
            statement.executeUpdate("INSERT INTO `vchernetski`.`cars` (`id`, `model`, `color`, `year`, `garages_id`) VALUES (DEFAULT, 'Range Rover Sport', 'black', 2012, 1);");
            statement.executeUpdate("INSERT INTO `vchernetski`.`cars` (`id`, `model`, `color`, `year`, `garages_id`) VALUES (DEFAULT, 'Audi A4', 'blue', 2018, 2);");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void getUsersWithRoles(){
        String sql = "SELECT * FROM roles INNER JOIN users ON users.roles_id=roles.id";
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:2016/vchernetski", "root", "");
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                ResultSetMetaData metaData = resultSet.getMetaData();
                System.out.print(metaData.getColumnLabel(2)+": "+resultSet.getString(2)+"\t\t");
                System.out.print(metaData.getColumnLabel(4)+": "+resultSet.getString(4)+"\t\t");
                System.out.print(metaData.getColumnLabel(3)+": "+resultSet.getString(3)+"\t\t");
                System.out.println();
            }
            resultSet=statement.executeQuery("SELECT COUNT(*) FROM roles WHERE id>0");
            if(resultSet.next()){
                System.out.println("количество возможных ролей: "+resultSet.getInt(1));
            }resultSet=statement.executeQuery("SELECT COUNT(*) FROM users WHERE id>0");
            if(resultSet.next()){
                System.out.println("количество пользователей: "+resultSet.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

