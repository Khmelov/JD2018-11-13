package by.it.zhivov.project.java.dao;

import by.it.zhivov.project.java.beans.Ad;
import by.it.zhivov.project.java.beans.Role;
import by.it.zhivov.project.java.beans.User;

import java.sql.*;

public class Dao {
    private static volatile Dao dao;
    public InterfaceDao<Role> role;
    public InterfaceDao<User> user;
    public InterfaceDao<Ad> ad;


    private Dao() {
        role = new RoleDao();
        user = new UserDao();
        ad = new AdDao();
    }

    public static Dao getDao() {
        if (dao == null) {
            synchronized (Dao.class) {
                if (dao == null) {
                    dao = new Dao();
                }
            }
        }
        return dao;
    }

    static boolean executeUpdate(String sql) throws SQLException {
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            return ( 1 == statement.executeUpdate(sql) );
        }
    }

    static long executeCreateAndGetId(String sql) throws SQLException {
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            if (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    return generatedKeys.getLong(1);
                }
            }
        }
        return -1;
    }


    public static void restoreDB() throws SQLException {
        System.out.println("Staring DB restore");
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:2016/?" +
                "useSSL=false" +
                "&" +
                "useUnicode=true&characterEncoding=UTF-8", "root", "");
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("DROP SCHEMA IF EXISTS `zhivov`");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `zhivov` DEFAULT CHARACTER SET utf8");
            statement.executeUpdate("USE `zhivov`");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `zhivov`.`roles` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `role` VARCHAR(20) NULL,\n" +
                    "  PRIMARY KEY (`id`))\n" +
                    "ENGINE = InnoDB");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `zhivov`.`users` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `name` VARCHAR(100) NULL,\n" +
                    "  `login` VARCHAR(45) NULL,\n" +
                    "  `password` VARCHAR(26) NULL,\n" +
                    "  `dateofbirth` DATE NULL,\n" +
                    "  `email` VARCHAR(45) NULL,\n" +
                    "  `tel` VARCHAR(45) NULL,\n" +
                    "  `roles_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  CONSTRAINT `fk_users_roles`\n" +
                    "    FOREIGN KEY (`roles_id`)\n" +
                    "    REFERENCES `zhivov`.`roles` (`id`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT)\n" +
                    "ENGINE = InnoDB");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `zhivov`.`ads` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `title` VARCHAR(50) NULL,\n" +
                    "  `description` VARCHAR(2000) NULL,\n" +
                    "  `brand` VARCHAR(45) NULL,\n" +
                    "  `model` VARCHAR(45) NULL,\n" +
                    "  `color` VARCHAR(45) NULL,\n" +
                    "  `body` VARCHAR(45) NULL,\n" +
                    "  `year` INT NULL,\n" +
                    "  `engine` DOUBLE NULL,\n" +
                    "  `at` VARCHAR(20) NULL,\n" +
                    "  `driveunit` VARCHAR(15) NULL,\n" +
                    "  `equipment` VARCHAR(45) NULL,\n" +
                    "  `mileage` INT NULL,\n" +
                    "  `crashed` VARCHAR(20) NULL,\n" +
                    "  `price` DOUBLE NULL,\n" +
                    "  `users_id` INT NOT NULL,\n" +
                    "  FULLTEXT (brand),\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  CONSTRAINT `fk_ads_users1`\n" +
                    "    FOREIGN KEY (`users_id`)\n" +
                    "    REFERENCES `zhivov`.`users` (`id`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE CASCADE)\n" +
                    "ENGINE = InnoDB");
            statement.executeUpdate("INSERT INTO `zhivov`.`roles` (`id`, `role`) VALUES (DEFAULT, 'admin')");
            statement.executeUpdate("INSERT INTO `zhivov`.`roles` (`id`, `role`) VALUES (DEFAULT, 'user')");
            statement.executeUpdate("INSERT INTO `zhivov`.`roles` (`id`, `role`) VALUES (DEFAULT, 'guest')");
            statement.executeUpdate("INSERT INTO `zhivov`.`users` (`id`, `name`, `login`, `password`, `dateofbirth`, `email`, `tel`, `roles_id`) VALUES (DEFAULT, 'm0rph3us', 'admin', 'admin', '1994-12-23', 'jeromeastero@gmail.com', '+375333830046', 1)");
            statement.executeUpdate("INSERT INTO `zhivov`.`users` (`id`, `name`, `login`, `password`, `dateofbirth`, `email`, `tel`, `roles_id`) VALUES (DEFAULT, 'Живов Антон Дмитриевич', 'zhivov', 'zhivov', '1994-12-23', 'drel@icloud.com', '+375333830040', 2)");
            statement.executeUpdate("INSERT INTO `zhivov`.`users` (`id`, `name`, `login`, `password`, `dateofbirth`, `email`, `tel`, `roles_id`) VALUES (DEFAULT, 'Живова Анна Русальская', 'zhivova', 'zhivova', '1995-07-11', 'eva_skandi@mail.ru', '+375291873010', 2)");
            statement.executeUpdate("INSERT INTO `zhivov`.`users` (`id`, `name`, `login`, `password`, `dateofbirth`, `email`, `tel`, `roles_id`) VALUES (DEFAULT, 'Шишко Алексей Евгеньевич', 'shishko', 'shishko', '1992-04-16', 'shishka_bel@mail.ru', '+375336549877', 2)");
            statement.executeUpdate("INSERT INTO `ads` (`id`, `title`, `description`, `brand`, `model`, `color`, `body`, `year`, `engine`, `at`, `driveunit`, `equipment`, `mileage`, `crashed`, `price`, `users_id`) VALUES (NULL, 'Не бито, не крашено', 'Хорошая машина на каждый день',                             'BMW',      '325',      'Black',     'Седан',    '2008', '2.5', 'Automatic', 'RWD', 'Minimal',      '120000', 'No',   '860000', '2')");
            statement.executeUpdate("INSERT INTO `ads` (`id`, `title`, `description`, `brand`, `model`, `color`, `body`, `year`, `engine`, `at`, `driveunit`, `equipment`, `mileage`, `crashed`, `price`, `users_id`) VALUES (NULL, 'Мощный джип', 'Никогда нигде не застревал',                                        'Dodge',    'Durango',  'Black',    'Джип',     '2005', '5.8', 'Manual',    '4WD', 'Base',         '460000', 'Yes',  '620000', '2')");
            statement.executeUpdate("INSERT INTO `ads` (`id`, `title`, `description`, `brand`, `model`, `color`, `body`, `year`, `engine`, `at`, `driveunit`, `equipment`, `mileage`, `crashed`, `price`, `users_id`) VALUES (NULL, 'Никогда не подводит', 'Самая простая машина, отдам в подарок комплект резины',     'Toyota',   'Corolla',  'Grey',     'Седан',    '2012', '2.0', 'Manual',     'FWD', 'Minimal',     '320000', 'No',   '400000', '3')");
            statement.executeUpdate("INSERT INTO `ads` (`id`, `title`, `description`, `brand`, `model`, `color`, `body`, `year`, `engine`, `at`, `driveunit`, `equipment`, `mileage`, `crashed`, `price`, `users_id`) VALUES (NULL, 'Восстановил немца', 'Полностью восстановлены: двигатель, подвеска, ходовка ',      'Audi',     'A4',       'Black',    'Седан',    '2006', '1.8', 'Manual',     '4WD', 'Middle',      '600000', 'No',   '800000', '3')");
            statement.executeUpdate("INSERT INTO `ads` (`id`, `title`, `description`, `brand`, `model`, `color`, `body`, `year`, `engine`, `at`, `driveunit`, `equipment`, `mileage`, `crashed`, `price`, `users_id`) VALUES (NULL, 'Продам срочно!', 'Продаю срочно, нужны деньги',                                    'BMW',      '760li',    'Black',     'Седан',    '2017', '6.0', 'Automatic',  'AWD', 'Premium',     '85000',  'No',   '2400000', '4')");
            statement.executeUpdate("INSERT INTO `ads` (`id`, `title`, `description`, `brand`, `model`, `color`, `body`, `year`, `engine`, `at`, `driveunit`, `equipment`, `mileage`, `crashed`, `price`, `users_id`) VALUES (NULL, 'Прекрасное авто со всех сторон', 'Машина семейная, в дтп не участвовала, использовалась бережно',     'Toyota',   'Camry',    'Metallic-black','Седан',    '2018', '3.5', 'Automatic',   'FWD', 'Top',        '35000', 'No',   '1100000', '3')");
            statement.executeUpdate("INSERT INTO `ads` (`id`, `title`, `description`, `brand`, `model`, `color`, `body`, `year`, `engine`, `at`, `driveunit`, `equipment`, `mileage`, `crashed`, `price`, `users_id`) VALUES (NULL, 'Немецкое качестно', 'Машина не доставляла никаких хлопот',                         'Audi',     'A6',       'Metallic-grey','Седан',    '2009', '2.5', 'Automatic', 'AWD', 'Middle',     '180000', 'No',   '790000', '4')");
            statement.executeUpdate("INSERT INTO `ads` (`id`, `title`, `description`, `brand`, `model`, `color`, `body`, `year`, `engine`, `at`, `driveunit`, `equipment`, `mileage`, `crashed`, `price`, `users_id`) VALUES (NULL, 'Верный конь', 'Ремонта не требует, из последнего заменены тормоза и кулиса',       'Audi',     '80',       'Murena',     'Седан',    '1994', '2.0', 'Manual',     'FWD', 'Minimal',     '240000', 'Yes',   '60000', '2')");
            System.out.println("DB restored successful");
        }
    }
}
