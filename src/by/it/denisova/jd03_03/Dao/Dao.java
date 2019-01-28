package by.it.denisova.jd03_03.Dao;

import by.it.denisova.jd03_03.beans.Question;
import by.it.denisova.jd03_03.beans.Role;
import by.it.denisova.jd03_03.beans.Test;
import by.it.denisova.jd03_03.beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Dao {

    private static volatile Dao dao;
    public InterfaceDao<Role> role;
    public InterfaceDao<User> user;
    public InterfaceDao<Test> test;

    public Dao() {
        role = new RoleDao();
        user = new UserDao();
        test = new TestDao();
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
