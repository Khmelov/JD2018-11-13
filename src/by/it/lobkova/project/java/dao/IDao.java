package by.it.lobkova.project.java.dao;

import java.sql.SQLException;
import java.util.List;

public interface IDao<Type> {
    boolean create(Type type) throws SQLException;
    boolean update(Type type) throws SQLException;
    boolean delete(Type type) throws SQLException;
    Type read(long id) throws SQLException;
    List<Type> getAll(String sql) throws SQLException;

    default List<Type> getAll() throws SQLException {
        return getAll("");
    }
}
