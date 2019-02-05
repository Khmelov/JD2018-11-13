package by.it.denisova.project.java.dao;

import by.it.denisova.project.java.beans.Lesson;
import by.it.denisova.project.java.beans.TypeLesson;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TypeDao implements InterfaceDao<TypeLesson> {

    public boolean create(TypeLesson type) throws SQLException {
        String sql = String.format(
                "INSERT INTO `type_lesson` (`id_type`, `type`) " +
                        "VALUES ('%d', '%s')",
            type.getId(), type.getType()
        );
        long id = Dao.executeCreateAndGetId(sql);
        type.setId(id);
        return (id > 0);
    }

    public boolean delete(TypeLesson type) throws SQLException {
        String sql = String.format(
                "  DELETE FROM `type_lesson` WHERE `type_lesson`.`id_type` = %d",
                type.getId()
        );
        return Dao.executeUpdate(sql);
    }

    public boolean update(TypeLesson type) throws SQLException {
        String sql = String.format(
                "UPDATE `type_lesson` SET " +
                        "`type` = '%s' " +
                        "WHERE `type_lesson`.`id_type` = %d",
                type.getType(), type.getId()
        );
        return Dao.executeUpdate(sql);
    }

    public TypeLesson read(long id) throws SQLException {
        String sqlSuffix = String.format("WHERE id_type = %d", id);
        List<TypeLesson> all = getAll(sqlSuffix);
        return all.size() > 0 ? all.get(0) : null;
    }

    @Override
    public List<TypeLesson> getAll(String sqlSuffix) throws SQLException {
        List<TypeLesson> result=new ArrayList<>();
        String sql = String.format("SELECT `id_type`, `type` " +
                "FROM `type_lesson` %s",sqlSuffix);
        try (Connection connection = Connect.getConnection();
             Statement st = connection.createStatement()) {
            ResultSet resultSet = st.executeQuery(sql);
            while (resultSet.next()) {

                long id = resultSet.getLong("id_type");
                String type = resultSet.getString("type");
                TypeLesson typeLesson = new TypeLesson(id,type);
                result.add(typeLesson);
            }
            return result;
        }
    }
}
