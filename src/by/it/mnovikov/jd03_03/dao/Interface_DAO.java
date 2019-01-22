package by.it.mnovikov.jd03_03.dao;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by user on 22.01.2019.
 */
public interface Interface_DAO<Type> {

    boolean create(Type bean) throws SQLException;

    boolean update(Type bean) throws SQLException;

    boolean delete(Type bean) throws SQLException;

    Type read(long id) throws SQLException;

    List<Type> getAll(String sqlSuffix) throws SQLException;

    List<Type> getAll() throws SQLException;

}
