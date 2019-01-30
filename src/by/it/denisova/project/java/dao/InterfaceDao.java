package by.it.denisova.project.java.dao;

import java.sql.SQLException;
import java.util.List;

public interface InterfaceDao<Type> {

    boolean create(Type bean)  throws SQLException;
    boolean update(Type bean)  throws SQLException;
    boolean delete(Type bean)  throws SQLException;
    Type read(long id)   throws SQLException;
    List<Type> getAll(String sqlSuffix) throws SQLException;


    default List<Type> getAll() throws SQLException {
        return getAll("");
    };

}