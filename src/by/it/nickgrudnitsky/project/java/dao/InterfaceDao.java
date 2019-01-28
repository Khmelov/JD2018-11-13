package by.it.nickgrudnitsky.project.java.dao;

import java.sql.SQLException;
import java.util.List;

public interface InterfaceDao<Type> {
    boolean create(Type bean) throws SQLException;

    Type read(long id) throws SQLException;

    boolean update(Type bean) throws SQLException;

    boolean delete(Type bean) throws SQLException;

    default List<Type> getAll() throws SQLException {
        return getAll("");
    }

    List<Type> getAll(String Where) throws SQLException;
}
