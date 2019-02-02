package by.it.denisova.project.java.dao;

import by.it.denisova.project.java.beans.Answer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AnswerDao implements InterfaceDao<Answer> {

    public boolean create(Answer answer) throws SQLException {
        String sql = String.format(
                "INSERT INTO `answers` (`answer`, `status`, `id_question`) " +
                        "VALUES ('%s', '%s', '%d')",
                answer.getAnswer(), answer.getStatus(), answer.getId_question()
        );
        long id = Dao.executeCreateAndGetId(sql);
        answer.setId(id);
        return (id > 0);
    }

    public boolean delete(Answer answer) throws SQLException {
        String sql = String.format(
                "DELETE FROM `answers` WHERE `answers`.`id_answer` = %d",
                answer.getId()
        );
        return Dao.executeUpdate(sql);
    }

    public boolean update(Answer answer) throws SQLException {
        String sql = String.format(
                "UPDATE `answers` SET " +
                        "`answer` = '%s', `status` = '%s', `id_question` = %d ",
                answer.getAnswer(), answer.getStatus(), answer.getId_question()
        );
        return Dao.executeUpdate(sql);
    }

    public Answer read(long id) throws SQLException {
        String sqlSuffix = String.format("WHERE id_question = %d", id);
        List<Answer> all = getAll(sqlSuffix);
        return all.size() > 0 ? all.get(0) : null;
    }

    @Override
    public List<Answer> getAll(String sqlSuffix) throws SQLException {
        List<Answer> result=new ArrayList<>();
        String sql = String.format("SELECT `id_answer`, `answer`, `status`, `id_question`" +
                "FROM `answers` %s",sqlSuffix);
        try (Connection connection = Connect.getConnection();
             Statement st = connection.createStatement()) {
            ResultSet resultSet = st.executeQuery(sql);
            while (resultSet.next()) {

                long id = resultSet.getLong("id_answer");
                String answer = resultSet.getString("answer");
                String status = resultSet.getString("status");
                long id_question = resultSet.getLong("id_question");
                Answer answer1 = new Answer(id, id_question, answer, status);
                result.add(answer1);
            }
            return result;
        }
    }
}
