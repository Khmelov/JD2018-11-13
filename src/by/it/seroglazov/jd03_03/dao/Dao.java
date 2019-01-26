package by.it.seroglazov.jd03_03.dao;

import java.util.List;

public interface Dao<T> {

    boolean create(T t) throws Exception;

    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    boolean update(T t) throws Exception;

    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    boolean delete(T t) throws Exception;

    T read(long id) throws Exception;

    List<T> getAll(String sqlCondition) throws Exception;

    default List<T> getAll() throws Exception {
        return getAll("");
    }

    default T findFirstByFieldValue(String pole, String value) throws Exception {
        String sqlSuffix = String.format("WHERE `%s` = '%s'", pole, value);
        List<T> list = getAll(sqlSuffix);
        if (list.size() > 0) return list.get(0);
        else return null;
    }

}
