package by.it.lobkova.jd03_03.dao;

import by.it.lobkova.jd03_03.beans.Goal;
import by.it.lobkova.jd03_03.beans.Role;
import by.it.lobkova.jd03_03.beans.Task;
import by.it.lobkova.jd03_03.beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Dao {
    private static volatile Dao dao;

    public static IDao<User> user;
    public static IDao<Role> role;
    public static IDao<Goal> goal;
    public static IDao<Task> task;

    public void reset(){
        Connect.reset();
    }

    private Dao() {
        user = new UserDao();
        task = new TaskDao();
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
