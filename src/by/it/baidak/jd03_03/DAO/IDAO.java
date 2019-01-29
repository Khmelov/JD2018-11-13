package by.it.baidak.jd03_03.DAO;

import java.sql.SQLException;
import java.util.List;

interface IDAO<T> {

    T read(int id) throws SQLException;
    boolean create(T entity) throws SQLException;
    boolean update(T entity) throws SQLException;
    boolean delete(T entity) throws SQLException;
    List<T> get(String source) throws SQLException;
}
