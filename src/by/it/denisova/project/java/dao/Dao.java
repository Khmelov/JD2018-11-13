package by.it.denisova.project.java.dao;

import by.it.denisova.project.java.beans.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Dao {

    private static volatile Dao dao;
    public InterfaceDao<Role> role;
    public InterfaceDao<User> user;
    public InterfaceDao<Test> test;
    public InterfaceDao<Question> question;
    public InterfaceDao<Answer> answer;
    public InterfaceDao<Lesson> lesson;
    public InterfaceDao<TypeLesson> type;
    public InterfaceDao<Theme> theme;

    public Dao() {
        role = new RoleDao();
        user = new UserDao();
        test = new TestDao();
        question = new QuestionDao();
        answer = new AnswerDao();
        lesson = new LessonDao();
        type = new TypeDao();
        theme = new ThemeDao();
    }

    public static Dao getDao(){
        if (dao== null) {
            synchronized (Dao.class) {
                if (dao== null) {
                    dao=new Dao();
                }
            }
        }
        return dao;
    }

    public void reset(){
        Connect.reset();
    }

    static boolean executeUpdate(String sql) throws SQLException {
        try (Connection connection = Connect.getConnection();

             Statement statement = connection.createStatement()) {
            return (1 == statement.executeUpdate(sql));
        }
    }

    static long executeCreateAndGetId(String sql) throws SQLException {
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            if (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    return generatedKeys.getLong(1);
                }
            }
        }
        return -1;
    }
}
