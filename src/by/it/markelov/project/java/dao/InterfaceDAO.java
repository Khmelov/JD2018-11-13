package by.it.markelov.project.java.dao;

import java.sql.SQLException;
import java.util.List;

public interface InterfaceDAO <T>{
    T create(T entity) throws SQLException;
    T read(int id) throws SQLException;
    boolean update(T entity) throws SQLException;
    boolean delete(T entity) throws SQLException;

    List<T> getAll(String where) throws SQLException;
}
