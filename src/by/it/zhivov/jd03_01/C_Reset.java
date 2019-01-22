package by.it.zhivov.jd03_01;

import java.sql.Statement;

class C_Reset {
    static void resetUsers(Statement statement) throws java.sql.SQLException {
        statement.executeUpdate("DELETE FROM `zhivov`.`users`");
        System.out.println("Reset \"user\" table complete");
    }

    static void resetAds(Statement statement) throws java.sql.SQLException {
        statement.executeUpdate("DELETE FROM `zhivov`.`ads`");
        System.out.println("Reset \"ads\" table complete");
    }

    static void resetRoles(Statement statement) throws java.sql.SQLException{
        statement.executeUpdate("DELETE FROM `zhivov`.`roles`");
        System.out.println("Reset \"roles\" table complete");
    }

    static void resetDB(Statement statement) throws java.sql.SQLException {
        statement.executeUpdate("DELETE FROM `zhivov`.`ads`");
        statement.executeUpdate("DELETE FROM `zhivov`.`users`");
        statement.executeUpdate("DELETE FROM `zhivov`.`roles`");
        System.out.println("Reset DB complete");
    }

    static void dropDB(Statement statement) throws java.sql.SQLException{
        statement.executeUpdate("DROP DATABASE `zhivov`");
        System.out.println("Drop DB complete");
    }

}