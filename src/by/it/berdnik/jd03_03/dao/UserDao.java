package by.it.berdnik.jd03_03.dao;

import by.it.berdnik.jd03_03.beans.User;

import java.sql.SQLException;
import java.util.List;

public class UserDao implements InterfaceDao<User> {
    @Override
    public boolean create(User bean) throws SQLException {
        return false;
    }

    @Override
    public boolean update(User bean) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(User bean) throws SQLException {
        return false;
    }

    @Override
    public User read(long id) throws SQLException {
        return null;
    }

    @Override
    public List<User> getAll(String sqlSuffix) throws SQLException {
        return null;
    }
}
