package by.it.vchernetski.jd03_02;

import by.it.vchernetski.jd03_01.C_Reset;
import by.it.vchernetski.jd03_02.beans.Car;
import by.it.vchernetski.jd03_02.beans.Garage;
import by.it.vchernetski.jd03_02.beans.Role;
import by.it.vchernetski.jd03_02.beans.User;
import by.it.vchernetski.jd03_02.crud.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TaskC {
    private static void deleteTables() {
        try (Statement statement = Connect.getConnection().createStatement()) {
            statement.executeUpdate("DROP TABLE IF EXISTS `cars`");
            statement.executeUpdate("DROP TABLE IF EXISTS `garages`");
            statement.executeUpdate("DROP TABLE IF EXISTS `users`");
            statement.executeUpdate("DROP TABLE IF EXISTS `roles`");
            System.out.println("tables deleted");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createTables() {
        try (Statement statement = Connect.getConnection().createStatement()) {
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
                    "    ON DELETE NO ACTION" +
                    "    ON UPDATE NO ACTION)" +
                    "ENGINE = InnoDB;");
            System.out.println("tables created");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void fillTables() {
        try {
            Role role1 = new Role(1, "admin");
            Role role2 = new Role(2, "user");
            Role role3 = new Role(3, "guest");
            Garage garage1 = new Garage(1, "Minsk, Lenina 3", 2, 1);
            Garage garage2 = new Garage(1, "Minsk, Moskovskaya 17", 1, 1);
            User user1 = new User(1, "Ivan Ivanovich Ivanov", "ivanich", "ivanich@mail.ru", "user", 2, 2);
            User user2 = new User(2, "Petr Petrovich Petrov", "petya", "petya@yandex.ru", "admin", 0, 1);
            User user3 = new User(3, "Василий Васильевич Васильев", "vasya", "vasya@gmail.com", "guest", 0, 3);
            Car car1 = new Car(1, "Range Rover Sport", "black", 2012, 1);
            Car car2 = new Car(2, "BMW X5", "white", 2015, 1);
            Car car3 = new Car(3, "Audi A4", "blue", 2018, 2);
            UserCRUD userCRUD = new UserCRUD();
            CarCRUD carCRUD = new CarCRUD();
            GarageCRUD garageCRUD = new GarageCRUD();
            RoleCRUD roleCRUD = new RoleCRUD();
            roleCRUD.create(role1);
            roleCRUD.create(role2);
            roleCRUD.create(role3);
            userCRUD.create(user1);
            userCRUD.create(user2);
            userCRUD.create(user3);
            garageCRUD.create(garage1);
            garageCRUD.create(garage2);
            carCRUD.create(car1);
            carCRUD.create(car2);
            carCRUD.create(car3);
            System.out.println("tables filled");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        String[] str=new String[]{"for","chek"};
//        C_Reset.main(str);
        try (Statement statement = Connect.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM roles");
            System.out.println("tables created");
        } catch (SQLException e) {
            System.err.println("no table");
        }
        Scanner sc = new Scanner(System.in);
        String in;
        System.out.println("1 - delete tables\n2 - create tables\n3 - fill tables\n");
        in = sc.nextLine();
        int op = Integer.parseInt(in);
        switch (op) {
            case 1:
                deleteTables();
                break;
            case 2:
                createTables();
                break;
            case 3:
                fillTables();
                break;
            default:
                System.out.println("wrong command");
        }
    }
}
