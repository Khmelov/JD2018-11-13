package by.it.denisova.project.java.dao;

import by.it.denisova.project.java.beans.Lesson;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LessonDao implements InterfaceDao<Lesson>{

    public boolean create(Lesson lesson) throws SQLException {
        String sql = String.format(
                "INSERT INTO `lessons` (`theory`, `id_test`, `id_theme`, `id_type`) " +
                        "VALUES ('%s', '%d', '%d', '%d')",
                lesson.getTheory(), lesson.getId_test(), lesson.getId_theme(), lesson.getId_type()
        );
        long id = Dao.executeCreateAndGetId(sql);
        lesson.setId(id);
        return (id > 0);
    }

    public boolean delete(Lesson lesson) throws SQLException {
        String sql = String.format(
                "  DELETE FROM `lessons` WHERE `lessons`.`id_lesson` = %d",
                lesson.getId()
        );
        return Dao.executeUpdate(sql);
    }

    public boolean update(Lesson lesson) throws SQLException {
        String sql = String.format(
                "UPDATE `lessons` SET " +
                        "`theory` = '%s', `id_test` = '%d', " +
                        "`id_theme` = '%d',  `id_type` = '%d' " +
                        "WHERE `lessons`.`id_lesson` = %d",
                lesson.getTheory(), lesson.getId_test(), lesson.getId_theme(), lesson.getId_type(), lesson.getId()
        );
        return Dao.executeUpdate(sql);
    }

    public Lesson read(long id) throws SQLException {
        String sqlSuffix = String.format("WHERE `lessons`.`id_lesson` = %d", id);
        List<Lesson> all = getAll(sqlSuffix);
        return all.size() > 0 ? all.get(0) : null;
    }

    @Override
    public List<Lesson> getAll(String sqlSuffix) throws SQLException {
        List<Lesson> result=new ArrayList<>();
        String sql = String.format("SELECT `id_lesson`, `theory`, `id_test`, `id_theme`, `id_type` " +
                "FROM `lessons` %s",sqlSuffix);
        try (Connection connection = Connect.getConnection();
             Statement st = connection.createStatement()) {
            ResultSet resultSet = st.executeQuery(sql);
            while (resultSet.next()) {

                long id = resultSet.getLong("id_lesson");
                String theory = resultSet.getString("theory");
                long id_test = resultSet.getLong("id_test");
                long id_theme = resultSet.getLong("id_theme");
                long id_type = resultSet.getLong("id_type");
                Lesson lesson = new Lesson(id,theory,id_theme,id_test,id_type);
                result.add(lesson);
            }
            return result;
        }
    }
}
