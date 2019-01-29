package by.it.vchernetski.project.java.dao;

import java.util.List;

public interface InterfaceDAO<T> {
    boolean create() throws Exception;
    boolean update() throws Exception;
    boolean delete() throws Exception;
    T read(long id) throws Exception;
    default List<T> getAll() throws Exception{
        return getAll("");
    }
    List<T> getAll(String sqls) throws Exception;
}
