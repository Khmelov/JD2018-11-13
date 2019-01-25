package by.it.nickgrudnitsky.jd03_02;


import by.it.nickgrudnitsky.jd03_02.CRUD.Connect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TaskB {
    public static void main(String[] args) {
        String sql1 = "SELECT viewers.id, viewers.email, viewers.password, viewers.nickname, roles.role FROM viewers INNER JOIN roles ON viewers.roles_id = roles.id";
        String sql2 = "SELECT streamers.id, streamers.email, streamers.password, streamers.channelname, roles.role FROM streamers INNER JOIN roles ON streamers.roles_id = roles.id";
        String sql3 = "SELECT COUNT(id) FROM viewers";
        String sql4 = "SELECT COUNT(id) FROM streamers";
        String sql5 = "SELECT role FROM roles";
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql1);
            System.out.println("Viewers:");
            while (resultSet.next()) {
                System.out.printf("id='%s ", resultSet.getString(1));
                System.out.printf("email='%s ", resultSet.getString(2));
                System.out.printf("password='%s ", resultSet.getString(3));
                System.out.printf("nickname='%s ", resultSet.getString(4));
                System.out.printf("role ='%s\n", resultSet.getString(5));
            }
        } catch (
                SQLException e) {
            e.printStackTrace();
        }

        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(sql2);
            System.out.println("Streamers:");
            while (resultSet.next()) {
                System.out.printf("id='%s ", resultSet.getString(1));
                System.out.printf("email='%s ", resultSet.getString(2));
                System.out.printf("password='%s ", resultSet.getString(3));
                System.out.printf("channelname='%s ", resultSet.getString(4));
                System.out.printf("role ='%s\n", resultSet.getString(5));
            }
            ResultSet resultSet1 = statement.executeQuery(sql3);
            if (resultSet1.next()){
                System.out.println("Viewers count: " + resultSet1.getString(1));
            }
            ResultSet resultSet2 = statement.executeQuery(sql4);
            if (resultSet2.next()){
                System.out.println("Streamers count: " + resultSet2.getString(1));
            }
            ResultSet resultSet3 = statement.executeQuery(sql5);
            System.out.println("Roles: ");
            while (resultSet3.next()){
                System.out.println(resultSet3.getString(1));
            }
        } catch (
                SQLException e) {
            e.printStackTrace();
        }

    }
}
