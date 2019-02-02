package by.it.karnilava.jd03_03.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.it.karnilava.jd03_03.beans.State;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StateDAO extends DAO implements InterfaceDAO<State> {
    @Override
    public State read(long id) {
        String where = String.format("WHERE id=%d", id);
        List<State> states = getAll(where);
        if (states.size() > 0) {
            return states.get(0);
        } else
            return null;
    }

    @Override
    public boolean create(State state) throws SQLException {
        String sql = String.format(
                "INSERT INTO `karnilava1`.`state` (`state`) VALUES('%s');",
                state.getState()
        );
        long id = DAO.executeCreateAndGetId(sql);
        state.setId(id);
        return (id > 0);


    }

    @Override
    public boolean update(State state) throws SQLException {
        String sql = String.format(
                "UPDATE `karnilava1`.`state` SET `state` = '%s' " +
                        "WHERE  `karnilava1`.`state`.`id` =%d",
                state.getState(), state.getId()


        );
        return (executeUpdate(sql));
    }

    @Override
    public boolean delete(State state) throws SQLException {
        String sql = String.format("DELETE FROM `karnilava1`.`state` " +
                        "WHERE `karnilava1`.`state`.`id` =%d",
                state.getId()
        );
        return DAO.executeUpdate(sql);
    }

    @Override
    public List<State> getAll(String WhereAndOrder) {
        List<State> states = new ArrayList<>();
        String sql = String.format("SELECT `id`, `state` FROM `karnilava1`.`state` " + WhereAndOrder);

        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                State state = new State();
               state.setId(rs.getInt("id"));
                state.setState(rs.getString("state"));

                states.add(state);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return states;

    }
}
