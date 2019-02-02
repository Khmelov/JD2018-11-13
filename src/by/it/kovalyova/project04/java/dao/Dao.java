package by.it.kovalyova.project04.java.dao;


import by.it.kovalyova.project04.java.beans.Ad;
import by.it.kovalyova.project04.java.beans.Flat;
import by.it.kovalyova.project04.java.beans.Role;
import by.it.kovalyova.project04.java.beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Dao {
    private static volatile Dao dao;

    public InterfaceDao<Role> role;
    public InterfaceDao<User> user;
    public InterfaceDao<Ad> ad;
    public InterfaceDao<Flat> flat;

    public void reset(){
        Connect.reset();
    }
    private Dao() {
        role=new RoleDao();
        user=new UserDao();
        ad=new UniversalDAO<>(new Ad(), "ads");
        flat=new UniversalDAO<>(new Flat(), "flats");


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
