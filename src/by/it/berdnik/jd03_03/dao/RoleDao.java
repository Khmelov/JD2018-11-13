package by.it.berdnik.jd03_03.dao;

import by.it.berdnik.jd03_03.beans.Role;

import java.sql.SQLException;
import java.util.List;

public class RoleDao implements InterfaceDao<Role> {
    @Override
    public boolean create(Role bean) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Role bean) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(Role bean) throws SQLException {
        return false;
    }

    @Override
    public Role read(long id) throws SQLException {
        return null;
    }

    @Override
    public List<Role> getAll(String sqlSuffix) throws SQLException {
        return null;
    }
}
