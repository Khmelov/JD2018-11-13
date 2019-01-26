package by.it.baidak.project.java.DAO;

import by.it.baidak.project.java.beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends AbstractDAO implements IDAO<User> {

    @Override
    public User read(int id) throws SQLException {
        String source = String.format("WHERE id=%d", id);
        List<User> all = get(source);
        return all.size() > 0 ? all.get(0) : null;
    }

    @Override
    public boolean create(User entity) throws SQLException {
        String sql = String.format("INSERT INTO `users` (`email`, `nickname`, `pass`, `roles_id`) " +
                                   "VALUES ('%s', '%s', '%s', '%d')",
                                    entity.getEmail(), entity.getNickname(), entity.getPass(), entity.getRoles_Id()
        );
        long id = executeUpdate(sql,true);
        entity.setId(id);
        return (id > 0);
    }

    @Override
    public boolean update(User entity) throws SQLException {
        String sql = String.format("UPDATE `users` SET " +
                                    "`email` = '%s', `nickname` = '%s', " +
                                    "`pass` = '%s',  `roles_id` = '%d' " +
                                    "WHERE `users`.`id` = %d",
                                    entity.getEmail(), entity.getNickname(),
                                    entity.getPass(), entity.getRoles_Id(),
                                    entity.getId()
        );
        return (executeUpdate(sql,true) > 0);
    }

    @Override
    public boolean delete(User entity) throws SQLException {
        String sql = String.format(
                "DELETE FROM `users` WHERE `users`.`id` = %d",
                entity.getId()
        );
        return (executeUpdate(sql,true) > 0);
    }

    @Override
    public List<User> get(String source) throws SQLException {
        List<User> result=new ArrayList<>();
        String sql = String.format("SELECT `id`, `email`, `nickname`, `pass`, `roles_id` FROM `users` %s", source);
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String email = resultSet.getString("email");
                String nickname = resultSet.getString("nickname");
                String pass = resultSet.getString("pass");
                long roles_Id = resultSet.getLong("roles_id");
                User user = new User(id, email, nickname, pass, roles_Id);
                result.add(user);
            }
            return result;
        }
    }
}
