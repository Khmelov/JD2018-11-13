package by.it.denisova.jd03_03.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class Connect {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    private static volatile Connection connection;
    private static Statement statement;

    static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            synchronized (Connect.class) {
                if (connection == null || connection.isClosed()) {
                    connection = DriverManager.getConnection(CN.URL, CN.USER, CN.PASSWORD);
                }
            }
        }
        return connection;
    }

    static void reset() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:2016/", "root", "")) {
            statement = connection.createStatement();
            statement.executeUpdate("DROP SCHEMA IF EXISTS `denisova` ;");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `denisova` DEFAULT CHARACTER SET utf8 ;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `denisova`.`roles` (\n" +
                    "  `id_role` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `role` VARCHAR(45) NULL,\n" +
                    "  PRIMARY KEY (`id_role`))\n" +
                    "ENGINE = InnoDB;");

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `denisova`.`users` (\n" +
                    "  `id_user` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `login` VARCHAR(45) NULL,\n" +
                    "  `password` VARCHAR(45) NULL,\n" +
                    "  `email` VARCHAR(45) NULL,\n" +
                    "  `id_role` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id_user`),\n" +
                    "  CONSTRAINT `fk_users_roles`\n" +
                    "    FOREIGN KEY (`id_role`)\n" +
                    "    REFERENCES `denisova`.`roles` (`id_role`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT)\n" +
                    "ENGINE = InnoDB;");

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `denisova`.`themes` (\n" +
                    "  `id_theme` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `theme` VARCHAR(150) NULL,\n" +
                    "  PRIMARY KEY (`id_theme`))\n" +
                    "ENGINE = InnoDB;");

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `denisova`.`tests` (\n" +
                    "  `id_test` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `test_name` VARCHAR(100) NULL,\n" +
                    "  PRIMARY KEY (`id_test`))\n" +
                    "ENGINE = InnoDB;");

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `denisova`.`questions` (\n" +
                    "  `id_question` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `question` VARCHAR(350) NULL,\n" +
                    "  `id_test` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id_question`),\n" +
                    "  CONSTRAINT `fk_questions_tests1`\n" +
                    "    FOREIGN KEY (`id_test`)\n" +
                    "    REFERENCES `denisova`.`tests` (`id_test`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE CASCADE)\n" +
                    "ENGINE = InnoDB;");

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `denisova`.`answers` (\n" +
                    "  `id_answer` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `answer` VARCHAR(350) NULL,\n" +
                    "  `status` VARCHAR(45) NULL,\n" +
                    "  `id_question` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id_answer`),\n" +
                    "  CONSTRAINT `fk_answers_questions1`\n" +
                    "    FOREIGN KEY (`id_question`)\n" +
                    "    REFERENCES `denisova`.`questions` (`id_question`)\n" +
                    "    ON DELETE NO ACTION\n" +
                    "    ON UPDATE NO ACTION)\n" +
                    "ENGINE = InnoDB;");

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `denisova`.`type_lesson` (\n" +
                    "  `id_type` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `type` VARCHAR(100) NULL,\n" +
                    "  PRIMARY KEY (`id_type`))\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `denisova`.`lessons` (\n" +
                    "  `id_lesson` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `theory` VARCHAR(150) NULL,\n" +
                    "  `id_test` INT NOT NULL,\n" +
                    "  `id_theme` INT NOT NULL,\n" +
                    "  `id_type` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id_lesson`),\n" +
                    "  CONSTRAINT `fk_lessons_tests1`\n" +
                    "    FOREIGN KEY (`id_test`)\n" +
                    "    REFERENCES `denisova`.`tests` (`id_test`)\n" +
                    "    ON DELETE NO ACTION\n" +
                    "    ON UPDATE NO ACTION,\n" +
                    "  CONSTRAINT `fk_lessons_themes1`\n" +
                    "    FOREIGN KEY (`id_theme`)\n" +
                    "    REFERENCES `denisova`.`themes` (`id_theme`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE CASCADE,\n" +
                    "  CONSTRAINT `fk_lessons_type_lesson1`\n" +
                    "    FOREIGN KEY (`id_type`)\n" +
                    "    REFERENCES `denisova`.`type_lesson` (`id_type`)\n" +
                    "    ON DELETE NO ACTION\n" +
                    "    ON UPDATE NO ACTION)\n" +
                    "ENGINE = InnoDB;");

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `denisova`.`users_lessons` (\n" +
                    "  `state` VARCHAR(45) NULL,\n" +
                    "  `id_user` INT NOT NULL,\n" +
                    "  `id_lesson` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id_user`, `id_lesson`),\n" +
                    "  CONSTRAINT `fk_users_lessons_users1`\n" +
                    "    FOREIGN KEY (`id_user`)\n" +
                    "    REFERENCES `denisova`.`users` (`id_user`)\n" +
                    "    ON DELETE NO ACTION\n" +
                    "    ON UPDATE NO ACTION,\n" +
                    "  CONSTRAINT `fk_users_lessons_lessons1`\n" +
                    "    FOREIGN KEY (`id_lesson`)\n" +
                    "    REFERENCES `denisova`.`lessons` (`id_lesson`)\n" +
                    "    ON DELETE NO ACTION\n" +
                    "    ON UPDATE NO ACTION)\n" +
                    "ENGINE = InnoDB;");

            addRole("admin");
            addRole("user");
            addRole("guest");

            addUser("katia", "katia3768", "qwerty123@mail.ru", 1);
            addUser("nic", "nic3768", "qwerty120@mail.ru", 2);

            addTheme("Animal");
            addTheme("Greeting");

            addTypeLesson("Reading");
            addTypeLesson("Vocabulary");
            addTypeLesson("Listening");
            addTypeLesson("Rules");

            addTest("What do you know about animals?");

            addQuestion("How many years have lions lived?", 1);
            addAnswer("10 years", "right", 1);
            addAnswer("5 years", "wrong", 1);
            addAnswer("30 years", "wrong", 1);
            addAnswer("50 years", "wrong", 1);

            addLesson("lions live 10 years", 1, 1, 1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void addRole(String roleName) throws SQLException {
        statement.executeUpdate(
                "INSERT INTO `denisova`.`roles` (`id_role`, `role`) " +
                        "VALUES (DEFAULT, '" + roleName + "');");
    }

    private static void addUser(String login, String password, String email, long role) throws SQLException {
        statement.executeUpdate(
                "INSERT INTO `denisova`.`users` (`id_user`, `login`, `password`, `email`, `id_role`) " +
                        "VALUES (DEFAULT, '" + login + "', '" + password + "', '" + email + "', '" + role + "' );");
    }

    private static void addTheme(String theme) throws SQLException {
        statement.executeUpdate(
                "INSERT INTO `denisova`.`themes` (`id_theme`, `theme`)" +
                        " VALUES (DEFAULT, '" + theme + "');");
    }

    private static void addTypeLesson(String typeLesson) throws SQLException {
        statement.executeUpdate(
                "INSERT INTO `denisova`.`type_lesson` (`id_type`, `type`) " +
                        "VALUES (DEFAULT, '" + typeLesson + "');");
    }

    private static void addTest(String testName) throws SQLException {
        statement.executeUpdate("INSERT INTO `denisova`.`tests` (`id_test`, `test_name`)" +
                " VALUES (DEFAULT, '" + testName + "');");
    }

    private static void addQuestion(String question, long idTest) throws SQLException {
        statement.executeUpdate("INSERT INTO `denisova`.`questions` (`id_question`, `question`,`id_test`)" +
                "                VALUES (DEFAULT, '" + question + "', '" + idTest + "');");
    }

    private static void addAnswer(String answer, String status, long idQuestion) throws SQLException {
        statement.executeUpdate("INSERT INTO `denisova`.`answers` (`id_answer`, `answer`, `status`, `id_question`)" +
                " VALUES (DEFAULT, '" + answer + "', '" + status + "', '" + idQuestion + "');");
    }

    private static void addLesson(String theory, long idTest, long idTheme, long idType) throws SQLException {
        statement.executeUpdate("INSERT INTO `denisova`.`lessons` (`id_lesson`, `theory`, `id_test`, `id_theme`, `id_type`)" +
                " VALUES (DEFAULT, '" + theory + "', '" + idTest + "', '" + idTheme + "', '" + idType + "');");
    }
}