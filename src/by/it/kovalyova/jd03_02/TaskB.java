package by.it.kovalyova.jd03_02;


import by.it.kovalyova.jd03_02.crud.Connect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TaskB {
    public static void main(String[] args) {
        String sql = "SELECT `id`, `login`, `password`, `email`, `roles_id` FROM `users`";
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            int i = 0;
            int j = 0;
            while (resultSet.next()) {
                // id ok
                Long id= resultSet.getLong("id");
                String login = resultSet.getString("login");
                //String password = resultSet.getString("password");
                //String email = resultSet.getString("email");
                long roles_Id = resultSet.getLong("roles_Id");
                //return new User(id, login, password, email, roles_Id);
                System.out.println(Long.toString(id)+" "+login);
                i++;
                //String sql1 = String.format("SELECT `id`, `role` FROM `roles` "+
                //    "WHERE id=%d", roles_Id);
                //ResultSet resultSet1 = statement.executeQuery(sql1);
            }
            System.out.println("Users count: "+Integer.toString(i));

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
