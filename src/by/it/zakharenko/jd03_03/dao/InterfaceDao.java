package by.it.zakharenko.jd03_03.dao;

import java.sql.SQLException;
import java.util.List;

public interface InterfaceDao<Type> {

    boolean create(Type bean)  throws SQLException;
    boolean update(Type bean)  throws SQLException;
    boolean delete(Type bean)  throws SQLException;
    Type read(int id)   throws SQLException;
    List<Type> getAll(String sqlSuffix) throws SQLException;

    default List<Type> getAll() throws SQLException {
        return getAll("");
    }
}
