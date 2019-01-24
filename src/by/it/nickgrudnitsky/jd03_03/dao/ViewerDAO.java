package by.it.nickgrudnitsky.jd03_03.dao;





import by.it.nickgrudnitsky.jd03_03.beans.Viewer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ViewerDAO {
    public boolean create(Viewer viewer) throws SQLException {
        String sql = String.format("INSERT INTO `ngrudnitsky`.`viewers` (`email`, `password`, `nickname`, `roles_id`)"+
                " VALUES ('%s', '%s', '%s', '%d')", viewer.getEmail(), viewer.getPassword(), viewer.getNickname(), viewer.getRoles_id()
        );
        try (Connection connection = MyConnection.getConnection();
             Statement statement = connection.createStatement()) {
            if (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    viewer.setId(generatedKeys.getLong(1));
                }
                return true;
            }
        }
        return false;
    }

    public boolean delete(Viewer viewer) throws SQLException {
        String sql = String.format(
                "DELETE FROM `viewers` WHERE `viewers`.`id` = %d",
                viewer.getId()
        );
        try (Connection connection = MyConnection.getConnection();

             Statement statement = connection.createStatement()) {
            return (1 == statement.executeUpdate(sql));
        }
    }

    public boolean update(Viewer viewer) throws SQLException {
        String sql = String.format(
                "UPDATE `viewers` SET " +
                        "`email` = '%s', `password` = '%s', " +
                        "`nickname` = '%s',  `roles_id` = '%d' " +
                        "WHERE `viewers`.`id` = %d",
                viewer.getEmail(), viewer.getPassword(),
                viewer.getNickname(), viewer.getRoles_id(),
                viewer.getId()
        );
        try (Connection connection = MyConnection.getConnection();
             Statement statement = connection.createStatement()) {
            return (1 == statement.executeUpdate(sql));
        }
    }

    public Viewer read(long id) throws SQLException {
        String sql=String.format("SELECT `id`, `email`, `password`, `nickname`, `roles_id` " +
                "FROM `viewers` WHERE id=%d",id);
        try (Connection connection = MyConnection.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()){
                //id ok
                String email=resultSet.getString("email");
                String password=resultSet.getString("password");
                String nickname=resultSet.getString("nickname");
                long roles_Id=resultSet.getLong("roles_id");
                return new Viewer(email,password,nickname,roles_Id);
            }
            else
                return null;
        }

    }
}
