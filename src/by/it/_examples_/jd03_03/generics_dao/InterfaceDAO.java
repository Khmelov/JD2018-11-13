package by.it._examples_.jd03_03.generics_dao;

import java.sql.SQLException;
import java.util.List;

interface InterfaceDAO<TYPE> {
    //READ чтение отдельной сущности
    TYPE read(int id) throws SQLException;

    //CREATE,UPDATE,DELETE обновление сущности
    boolean create(TYPE entity) throws SQLException;

    boolean update(TYPE entity) throws SQLException;

    boolean delete(TYPE entity) throws SQLException;

    //READ - чтение всех элементов по условию
    List<TYPE> getAll(String WhereAndOrder) throws SQLException;
    //и другие необходимые системе операции

}
