package by.it.nickgrudnitsky.jd03_02.CRUD;


import by.it.nickgrudnitsky.jd03_02.beans.Streamer;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StreamerCRUD {
    public boolean create(Streamer streamer) throws SQLException {
        String sql = String.format("INSERT INTO `ngrudnitsky`.`streamers` (`email`, `password`, `channelname`, `roles_id`)"+
                " VALUES ('%s', '%s', '%s', '%d')", streamer.getEmail(), streamer.getPassword(), streamer.getChannelname(), streamer.getRoles_id()
        );
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            if (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    streamer.setId(generatedKeys.getLong(1));
                }
                return true;
            }
        }
        return false;
    }

    public boolean delete(Streamer streamer) throws SQLException {
        String sql = String.format(
                "DELETE FROM `streamers` WHERE `streamers`.`id` = %d",
                streamer.getId()
        );
        try (Connection connection = Connect.getConnection();

             Statement statement = connection.createStatement()) {
            return (1 == statement.executeUpdate(sql));
        }
    }

    public boolean update(Streamer streamer) throws SQLException {
        String sql = String.format(
                "UPDATE `streamers` SET " +
                        "`email` = '%s', `password` = '%s', " +
                        "`channelname` = '%s',  `roles_id` = '%d' " +
                        "WHERE `streamers`.`id` = %d",
                streamer.getEmail(), streamer.getPassword(),
                streamer.getChannelname(), streamer.getRoles_id(),
                streamer.getId()
        );
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            return (1 == statement.executeUpdate(sql));
        }
    }

    public Streamer read(long id) throws SQLException {
        String sql=String.format("SELECT `id`, `email`, `password`, `channelname`, `roles_id` " +
                "FROM `streamers` WHERE id=%d",id);
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()){
                String email=resultSet.getString("email");
                String password=resultSet.getString("password");
                String channelname=resultSet.getString("channelname");
                long roles_Id=resultSet.getLong("roles_id");
                return new Streamer(email,password,channelname,roles_Id);
            }
            else
                return null;
        }

    }
}
