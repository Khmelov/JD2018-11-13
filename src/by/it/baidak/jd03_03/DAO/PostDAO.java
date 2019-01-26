package by.it.baidak.jd03_03.DAO;

import by.it.baidak.jd03_03.beans.Post;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PostDAO extends AbstractDAO implements IDAO<Post> {

    @Override
    public Post read(int id) throws SQLException {
        String source = String.format("WHERE id=%d", id);
        List<Post> all = get(source);
        return all.size() > 0 ? all.get(0) : null;
    }

    @Override
    public boolean create(Post entity) throws SQLException {
        String sql = String.format("INSERT INTO `posts` (`head`, `date`, `users_id`) " +
                                    "VALUES ('%s', '%s', '%d')",
                                    entity.getHead(), entity.getDate(), entity.getUserID()
        );
        long id = executeUpdate(sql,true);
        entity.setId(id);
        return (id > 0);
    }

    @Override
    public boolean update(Post entity) throws SQLException {
        String sql = String.format("UPDATE `posts` SET " +
                                    "`head` = '%s', `date` = '%s', `users_id` = '%d' " +
                                    "WHERE `users`.`id` = %d",
                                    entity.getHead(), entity.getDate(), entity.getId()
        );
        return (executeUpdate(sql,true) > 0);
    }

    @Override
    public boolean delete(Post entity) throws SQLException {
        String sql = String.format(
                "DELETE FROM `posts` WHERE `users`.`id` = %d",
                entity.getId()
        );
        return (executeUpdate(sql,true) > 0);
    }

    @Override
    public List<Post> get(String source) throws SQLException {
        List<Post> result=new ArrayList<>();
        String sql = String.format("SELECT `id`, `head`, `date`, `users_id` FROM `posts` %s", source);
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String head = resultSet.getString("head");
                String date = resultSet.getString("date");
                long userID = resultSet.getLong("users_id");
                Post user = new Post(id, userID, head, date);
                result.add(user);
            }
            return result;
        }
    }
}
