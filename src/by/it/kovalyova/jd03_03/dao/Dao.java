package by.it.kovalyova.jd03_03.dao;

import by.it.kovalyova.jd03_03.beans.Ad;
import by.it.kovalyova.jd03_03.beans.Role;
import by.it.kovalyova.jd03_03.beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Dao {
    private static volatile Dao dao;

    public InterfaceDao<Role> role;
    public InterfaceDao<User> user;
    public InterfaceDao<Ad> ad;

    public void reset(){
        Connect.reset();
    }
    private Dao() {
        role=new UniversalDAO<>(new Role(), "roles");
        user=new UserDao();
        ad=new UniversalDAO<>(new Ad(), "ads");


    }

    public static Dao getDao(){
        if (dao==null) {
            synchronized (Dao.class){
                if (dao==null) {
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
