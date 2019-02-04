package by.it.karnilava.project05.java.dao;

import java.sql.SQLException;
import java.util.List;

public interface InterfaceDAO <TYPE> {
    TYPE read(long id);
    boolean create(TYPE entity) throws SQLException;
    boolean update(TYPE entity) throws SQLException;
    boolean delete(TYPE entity) throws SQLException;

    List<TYPE> getAll(String WhereAndOrder);
}
