package by.it.baidak.jd03_02.crud;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TaskB {

    public static void main(String[] args) {

        String sql=String.format("SELECT `nickname`, `roles_id` FROM users");
        try (Connection connection = by.it.baidak.jd03_02.crud.Connection.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            int roles = 0;
            int summ = 0;
            while (resultSet.next()){
                summ++;
                System.out.println(resultSet.getString("nickname"));
                int tmp = resultSet.getInt("roles_id");
                if (tmp>roles) roles = tmp;
            }
            System.out.println("-------------------");
            System.out.println(summ + " users and " + roles + " roles");
    } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
