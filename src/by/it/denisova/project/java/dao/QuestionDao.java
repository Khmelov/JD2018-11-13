package by.it.denisova.project.java.dao;

import by.it.denisova.project.java.beans.Question;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class QuestionDao implements InterfaceDao<Question> {

    public boolean create(Question question) throws SQLException {
        String sql = String.format(
                "INSERT INTO `questions` (`question`, `id_test`) " +
                        "VALUES ('%s', '%d')",
               question.getQuestion(), question.getId_test()
        );
        long id = Dao.executeCreateAndGetId(sql);
        question.setId(id);
        return (id > 0);
    }

    public boolean delete(Question question) throws SQLException {
        String sql = String.format(
                "DELETE FROM `questions` WHERE `questions`.`id_question` = %d",
                question.getId()
        );
        return Dao.executeUpdate(sql);
    }

    public boolean update(Question question) throws SQLException {
        String sql = String.format(
                "UPDATE `questions` SET " +
                        "`question` = '%s', `id_test` = '%d' ",
               question.getQuestion(), question.getId_test()
        );
        return Dao.executeUpdate(sql);
    }

    public Question read(long id) throws SQLException {
        String sqlSuffix = String.format("WHERE id_question = %d", id);
        List<Question> all = getAll(sqlSuffix);
        return all.size() > 0 ? all.get(0) : null;
    }

    @Override
    public List<Question> getAll(String sqlSuffix) throws SQLException {
        List<Question> result=new ArrayList<>();
        String sql = String.format("SELECT `id_question`, `question`, `id_test`" +
                "FROM `questions` %s",sqlSuffix);
        try (Connection connection = Connect.getConnection();
             Statement st = connection.createStatement()) {
            ResultSet resultSet = st.executeQuery(sql);
            while (resultSet.next()) {

                long id = resultSet.getLong("id_question");
                String question = resultSet.getString("question");
                long id_test = resultSet.getLong("id_test");
                 Question question1 = new Question(id, question, id_test);
                result.add(question1);
            }
            return result;
        }
    }

}