package by.it.kovalyova.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class C_init {

    public static void main(String[] args) throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
       try (Connection connection=DriverManager.getConnection("jdbc:mysql://127.0.0.1:2016/", "root", ""))
       {
           Statement statement=connection.createStatement();
           statement.executeUpdate("DROP SCHEMA IF EXISTS `kovalyova` ;");
           statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `kovalyova` DEFAULT CHARACTER SET utf8");
           statement.executeUpdate("CREATE TABLE IF NOT EXISTS `kovalyova`.`roles` (\n" +
                   "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                   "  `role` VARCHAR(100) NULL,\n" +
                   "  PRIMARY KEY (`id`))\n" +
                   "ENGINE = InnoDB;");
           statement.executeUpdate("CREATE TABLE IF NOT EXISTS `kovalyova`.`users` (\n" +
                   "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                   "  `login` VARCHAR(45) NULL,\n" +
                   "  `password` VARCHAR(45) NULL,\n" +
                   "  `email` VARCHAR(45) NULL,\n" +
                   "  `roles_id` INT NOT NULL,\n" +
                   "  PRIMARY KEY (`id`),\n" +
                   "  INDEX `fk_users_roles_idx` (`roles_id` ASC),\n" +
                   "  CONSTRAINT `fk_users_roles`\n" +
                   "    FOREIGN KEY (`roles_id`)\n" +
                   "    REFERENCES `kovalyova`.`roles` (`id`)\n" +
                   "    ON DELETE RESTRICT\n" +
                   "    ON UPDATE RESTRICT)\n" +
                   "ENGINE = InnoDB;");
           statement.executeUpdate("CREATE TABLE IF NOT EXISTS `kovalyova`.`flats` (" + "" + "\n"+
                   "           `id` INT UNSIGNED NOT NULL," + "\n"+
                   "           `description` VARCHAR(1000) NULL," + "\n"+
                   "           `address` VARCHAR(100) NULL," + "\n"+
                   "           `floor` INT NULL," + "\n"+
                   "           `floors` INT NULL," + "\n"+
                   "           `rooms` INT NULL," + "\n"+
                   "           `area` DECIMAL(10,2) NULL," + "\n"+
                   "               PRIMARY KEY (`id`))" + "\n"+
                   "           ENGINE = InnoDB;" + "\n");

           statement.executeUpdate("" +
                   "       CREATE TABLE IF NOT EXISTS `kovalyova`.`ads` (" + "\n" +
                   "      `id` INT NOT NULL," + "\n" +
                   "      `price` VARCHAR(45) NULL," + "\n" +
                   "      `users_id` INT NOT NULL," + "\n" +
                   "      `flats_id` INT UNSIGNED NOT NULL," + "\n" +
                   "  PRIMARY KEY (`id`)," + "\n" +
                   "      INDEX `fk_ads_users1_idx` (`users_id` ASC)," + "\n" +
                   "  INDEX `fk_ads_flats1_idx` (`flats_id` ASC)," + "\n" +
                   "  CONSTRAINT `fk_ads_users1`" + "\n" +
                   "  FOREIGN KEY (`users_id`)" + "\n" +
                   "  REFERENCES `kovalyova`.`users` (`id`)" + "\n" +
                   "  ON DELETE NO ACTION" + "\n" +
                   "  ON UPDATE NO ACTION," + "\n" +
                   "  CONSTRAINT `fk_ads_flats1`" + "\n" +
                   "  FOREIGN KEY (`flats_id`)" + "\n" +
                   "  REFERENCES `kovalyova`.`flats` (`id`)" + "\n" +
                   "  ON DELETE NO ACTION" + "\n" +
                   "  ON UPDATE NO ACTION)" + "\n" +
                   "ENGINE = InnoDB;");


           statement.executeUpdate("INSERT INTO `kovalyova`.`roles` (`id`, `role`) VALUES (DEFAULT, 'admin');");
           statement.executeUpdate("INSERT INTO `kovalyova`.`roles` (`id`, `role`) VALUES (DEFAULT, 'user');");
           statement.executeUpdate("INSERT INTO `kovalyova`.`roles` (`id`, `role`) VALUES (DEFAULT, 'guest');\n");
           statement.executeUpdate("INSERT INTO `kovalyova`.`users` (`id`, `login`, `password`, `email`, `roles_id`) VALUES (DEFAULT, 'admin', 'admin', 'admin@mail.ru', 1);");
           statement.executeUpdate("INSERT INTO `kovalyova`.`users` (`id`, `login`, `password`, `email`, `roles_id`) VALUES (DEFAULT, 'user', 'user', 'user@mail.ru', 2);");
           statement.executeUpdate("INSERT INTO `kovalyova`.`flats` (`id`, `description`, `address`, `floor`, `floors`, `rooms`, `area`) VALUES\n" +
                   "(1, NULL, 'пр.-т Независимости 1/120', 3, 9, 2, '56.50');");
           statement.executeUpdate("INSERT INTO `kovalyova`.`ads` (`id`, `price`, `users_id`, `flats_id`) VALUES\n" +
                   "(1, '180.2', 2, 1);");
       }catch (SQLException e){
           e.printStackTrace();
       }

    }
}
