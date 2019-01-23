package by.it.seroglazov.jd03_03;

import java.sql.SQLException;
import java.util.List;

public interface Dao<T> {
    boolean create(T t) throws Exception;

    boolean update(T t) throws SQLException;

    boolean delete(T t) throws SQLException;

    T read(long id) throws Exception;

    List<T> getAll(String sqlCondition) throws Exception;

    default List<T> getAll() throws Exception {
        return getAll("");
    }
}
